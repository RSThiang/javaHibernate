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

import Entity.Personnel;

public class PersonnelManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM Personnel AS o";

    private Personnel myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public PersonnelManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public Personnel getEntity() {
        return myEntity;
    }

    public void setEntity(Personnel entity) {
        myEntity = entity;
    }

    // add new Personnel
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

        return "personnelList";
    }

    // save edited Personnel
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
        return "personnelList";
    }

    // delete Personnel
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Personnel entity = getCurrentEntity();
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

        return "personnelList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<Personnel> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<Personnel>(entities));
    }

    public String startCreate() {
        myEntity = new Personnel();
        return "createPersonnel";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewPersonnel";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editPersonnel";
    }

    public Personnel getCurrentEntity() {
        Personnel entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public Personnel getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        Personnel entity = (Personnel) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public Personnel findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        Personnel entity = entityManager.find(Personnel.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<Personnel> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (Personnel entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<Personnel> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<Personnel> entities = (List<Personnel>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
