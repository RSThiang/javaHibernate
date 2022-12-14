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

import Entity.EmploiDuTemps;

public class EmploiDuTempsManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM EmploiDuTemps AS o";

    private EmploiDuTemps myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public EmploiDuTempsManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public EmploiDuTemps getEntity() {
        return myEntity;
    }

    public void setEntity(EmploiDuTemps entity) {
        myEntity = entity;
    }

    // add new EmploiDuTemps
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

        return "emploiDuTempsList";
    }

    // save edited EmploiDuTemps
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
        return "emploiDuTempsList";
    }

    // delete EmploiDuTemps
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            EmploiDuTemps entity = getCurrentEntity();
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

        return "emploiDuTempsList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<EmploiDuTemps> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<EmploiDuTemps>(entities));
    }

    public String startCreate() {
        myEntity = new EmploiDuTemps();
        return "createEmploiDuTemps";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewEmploiDuTemps";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editEmploiDuTemps";
    }

    public EmploiDuTemps getCurrentEntity() {
        EmploiDuTemps entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public EmploiDuTemps getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        EmploiDuTemps entity = (EmploiDuTemps) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public EmploiDuTemps findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        EmploiDuTemps entity = entityManager.find(EmploiDuTemps.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<EmploiDuTemps> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (EmploiDuTemps entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<EmploiDuTemps> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<EmploiDuTemps> entities = (List<EmploiDuTemps>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
