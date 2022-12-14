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

import Entity.PersonnelEcoles;

public class PersonnelEcolesManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM PersonnelEcoles AS o";

    private PersonnelEcoles myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public PersonnelEcolesManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public PersonnelEcoles getEntity() {
        return myEntity;
    }

    public void setEntity(PersonnelEcoles entity) {
        myEntity = entity;
    }

    // add new PersonnelEcoles
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

        return "personnelEcolesList";
    }

    // save edited PersonnelEcoles
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
        return "personnelEcolesList";
    }

    // delete PersonnelEcoles
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            PersonnelEcoles entity = getCurrentEntity();
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

        return "personnelEcolesList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<PersonnelEcoles> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<PersonnelEcoles>(entities));
    }

    public String startCreate() {
        myEntity = new PersonnelEcoles();
        return "createPersonnelEcoles";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewPersonnelEcoles";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editPersonnelEcoles";
    }

    public PersonnelEcoles getCurrentEntity() {
        PersonnelEcoles entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public PersonnelEcoles getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        PersonnelEcoles entity = (PersonnelEcoles) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public PersonnelEcoles findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        PersonnelEcoles entity = entityManager.find(PersonnelEcoles.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<PersonnelEcoles> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (PersonnelEcoles entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<PersonnelEcoles> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<PersonnelEcoles> entities = (List<PersonnelEcoles>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
