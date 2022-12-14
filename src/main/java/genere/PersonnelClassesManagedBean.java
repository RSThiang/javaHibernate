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

import Entity.PersonnelClasses;

public class PersonnelClassesManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM PersonnelClasses AS o";

    private PersonnelClasses myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public PersonnelClassesManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public PersonnelClasses getEntity() {
        return myEntity;
    }

    public void setEntity(PersonnelClasses entity) {
        myEntity = entity;
    }

    // add new PersonnelClasses
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

        return "personnelClassesList";
    }

    // save edited PersonnelClasses
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
        return "personnelClassesList";
    }

    // delete PersonnelClasses
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            PersonnelClasses entity = getCurrentEntity();
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

        return "personnelClassesList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<PersonnelClasses> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<PersonnelClasses>(entities));
    }

    public String startCreate() {
        myEntity = new PersonnelClasses();
        return "createPersonnelClasses";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewPersonnelClasses";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editPersonnelClasses";
    }

    public PersonnelClasses getCurrentEntity() {
        PersonnelClasses entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public PersonnelClasses getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        PersonnelClasses entity = (PersonnelClasses) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public PersonnelClasses findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        PersonnelClasses entity = entityManager.find(PersonnelClasses.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<PersonnelClasses> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (PersonnelClasses entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<PersonnelClasses> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<PersonnelClasses> entities = (List<PersonnelClasses>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
