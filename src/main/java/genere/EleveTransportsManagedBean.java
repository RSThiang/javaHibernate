package genere;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Entity.EleveTransports;

public class EleveTransportsManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM EleveTransports AS o";

    private EleveTransports myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public EleveTransportsManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public EleveTransports getEntity() {
        return myEntity;
    }

    public void setEntity(EleveTransports entity) {
        myEntity = entity;
    }

    // add new EleveTransports
    public String create() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(getEntity());
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        }
        entityManager.close();

        return "eleveTransportsList";
    }

    // save edited EleveTransports
    public String save() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            myEntity = entityManager.merge(getEntity());
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        }
        entityManager.close();
        return "eleveTransportsList";
    }

    // delete EleveTransports
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            EleveTransports entity = getCurrentEntity();
            entity = entityManager.merge(entity);
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            try {
                entityManager.getTransaction().rollback();
            } catch (Exception e) {
            }
        }
        entityManager.close();

        return "eleveTransportsList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<EleveTransports> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<EleveTransports>(entities));
    }

    public String startCreate() {
        myEntity = new EleveTransports();
        return "createEleveTransports";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewEleveTransports";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editEleveTransports";
    }

    public EleveTransports getCurrentEntity() {
        EleveTransports entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public EleveTransports getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        EleveTransports entity = (EleveTransports) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public EleveTransports findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        EleveTransports entity = entityManager.find(EleveTransports.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<EleveTransports> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (EleveTransports entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<EleveTransports> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<EleveTransports> entities = (List<EleveTransports>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
