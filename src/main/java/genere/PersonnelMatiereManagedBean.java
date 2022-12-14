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

import Entity.PersonnelMatiere;

public class PersonnelMatiereManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM PersonnelMatiere AS o";

    private PersonnelMatiere myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public PersonnelMatiereManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public PersonnelMatiere getEntity() {
        return myEntity;
    }

    public void setEntity(PersonnelMatiere entity) {
        myEntity = entity;
    }

    // add new PersonnelMatiere
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

        return "personnelMatiereList";
    }

    // save edited PersonnelMatiere
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
        return "personnelMatiereList";
    }

    // delete PersonnelMatiere
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            PersonnelMatiere entity = getCurrentEntity();
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

        return "personnelMatiereList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<PersonnelMatiere> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<PersonnelMatiere>(entities));
    }

    public String startCreate() {
        myEntity = new PersonnelMatiere();
        return "createPersonnelMatiere";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewPersonnelMatiere";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editPersonnelMatiere";
    }

    public PersonnelMatiere getCurrentEntity() {
        PersonnelMatiere entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public PersonnelMatiere getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        PersonnelMatiere entity = (PersonnelMatiere) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public PersonnelMatiere findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        PersonnelMatiere entity = entityManager.find(PersonnelMatiere.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<PersonnelMatiere> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (PersonnelMatiere entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<PersonnelMatiere> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<PersonnelMatiere> entities = (List<PersonnelMatiere>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
