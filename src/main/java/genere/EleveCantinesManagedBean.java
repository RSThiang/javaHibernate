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

import Entity.EleveCantines;

public class EleveCantinesManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM EleveCantines AS o";

    private EleveCantines myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public EleveCantinesManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public EleveCantines getEntity() {
        return myEntity;
    }

    public void setEntity(EleveCantines entity) {
        myEntity = entity;
    }

    // add new EleveCantines
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

        return "eleveCantinesList";
    }

    // save edited EleveCantines
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
        return "eleveCantinesList";
    }

    // delete EleveCantines
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            EleveCantines entity = getCurrentEntity();
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

        return "eleveCantinesList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<EleveCantines> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<EleveCantines>(entities));
    }

    public String startCreate() {
        myEntity = new EleveCantines();
        return "createEleveCantines";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewEleveCantines";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editEleveCantines";
    }

    public EleveCantines getCurrentEntity() {
        EleveCantines entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public EleveCantines getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        EleveCantines entity = (EleveCantines) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public EleveCantines findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        EleveCantines entity = entityManager.find(EleveCantines.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<EleveCantines> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (EleveCantines entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<EleveCantines> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<EleveCantines> entities = (List<EleveCantines>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
