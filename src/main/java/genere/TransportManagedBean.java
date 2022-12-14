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

import Entity.Transport;

public class TransportManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM Transport AS o";

    private Transport myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public TransportManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public Transport getEntity() {
        return myEntity;
    }

    public void setEntity(Transport entity) {
        myEntity = entity;
    }

    // add new Transport
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

        return "transportList";
    }

    // save edited Transport
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
        return "transportList";
    }

    // delete Transport
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Transport entity = getCurrentEntity();
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

        return "transportList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<Transport> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<Transport>(entities));
    }

    public String startCreate() {
        myEntity = new Transport();
        return "createTransport";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewTransport";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editTransport";
    }

    public Transport getCurrentEntity() {
        Transport entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public Transport getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        Transport entity = (Transport) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public Transport findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        Transport entity = entityManager.find(Transport.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<Transport> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (Transport entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<Transport> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<Transport> entities = (List<Transport>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
