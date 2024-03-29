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

import Entity.PayementScolaire;

public class PayementScolaireManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM PayementScolaire AS o";

    private PayementScolaire myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public PayementScolaireManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public PayementScolaire getEntity() {
        return myEntity;
    }

    public void setEntity(PayementScolaire entity) {
        myEntity = entity;
    }

    // add new PayementScolaire
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

        return "payementScolaireList";
    }

    // save edited PayementScolaire
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
        return "payementScolaireList";
    }

    // delete PayementScolaire
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            PayementScolaire entity = getCurrentEntity();
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

        return "payementScolaireList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<PayementScolaire> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<PayementScolaire>(entities));
    }

    public String startCreate() {
        myEntity = new PayementScolaire();
        return "createPayementScolaire";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewPayementScolaire";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editPayementScolaire";
    }

    public PayementScolaire getCurrentEntity() {
        PayementScolaire entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public PayementScolaire getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        PayementScolaire entity = (PayementScolaire) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public PayementScolaire findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        PayementScolaire entity = entityManager.find(PayementScolaire.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<PayementScolaire> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (PayementScolaire entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<PayementScolaire> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<PayementScolaire> entities = (List<PayementScolaire>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
