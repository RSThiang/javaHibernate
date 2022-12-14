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

import Entity.NoteCours;

public class NoteCoursManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM NoteCours AS o";

    private NoteCours myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public NoteCoursManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public NoteCours getEntity() {
        return myEntity;
    }

    public void setEntity(NoteCours entity) {
        myEntity = entity;
    }

    // add new NoteCours
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

        return "noteCoursList";
    }

    // save edited NoteCours
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
        return "noteCoursList";
    }

    // delete NoteCours
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            NoteCours entity = getCurrentEntity();
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

        return "noteCoursList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<NoteCours> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<NoteCours>(entities));
    }

    public String startCreate() {
        myEntity = new NoteCours();
        return "createNoteCours";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewNoteCours";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editNoteCours";
    }

    public NoteCours getCurrentEntity() {
        NoteCours entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public NoteCours getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        NoteCours entity = (NoteCours) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public NoteCours findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        NoteCours entity = entityManager.find(NoteCours.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<NoteCours> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (NoteCours entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<NoteCours> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<NoteCours> entities = (List<NoteCours>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
