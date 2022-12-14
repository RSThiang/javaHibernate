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

import Entity.ActiviteScolaire;

public class ActiviteScolaireManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM ActiviteScolaire AS o";

    private ActiviteScolaire myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public ActiviteScolaireManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public ActiviteScolaire getEntity() {
        return myEntity;
    }

    public void setEntity(ActiviteScolaire entity) {
        myEntity = entity;
    }

    // add new ActiviteScolaire
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

        return "activiteScolaireList";
    }

    // save edited ActiviteScolaire
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
        return "activiteScolaireList";
    }

    // delete ActiviteScolaire
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            ActiviteScolaire entity = getCurrentEntity();
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

        return "activiteScolaireList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<ActiviteScolaire> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<ActiviteScolaire>(entities));
    }

    public String startCreate() {
        myEntity = new ActiviteScolaire();
        return "createActiviteScolaire";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewActiviteScolaire";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editActiviteScolaire";
    }

    public ActiviteScolaire getCurrentEntity() {
        ActiviteScolaire entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public ActiviteScolaire getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        ActiviteScolaire entity = (ActiviteScolaire) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public ActiviteScolaire findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        ActiviteScolaire entity = entityManager.find(ActiviteScolaire.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<ActiviteScolaire> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (ActiviteScolaire entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<ActiviteScolaire> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<ActiviteScolaire> entities = (List<ActiviteScolaire>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
