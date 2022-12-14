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

import Entity.Deliberation;

public class DeliberationManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM Deliberation AS o";

    private Deliberation myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public DeliberationManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public Deliberation getEntity() {
        return myEntity;
    }

    public void setEntity(Deliberation entity) {
        myEntity = entity;
    }

    // add new Deliberation
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

        return "deliberationList";
    }

    // save edited Deliberation
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
        return "deliberationList";
    }

    // delete Deliberation
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Deliberation entity = getCurrentEntity();
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

        return "deliberationList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<Deliberation> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<Deliberation>(entities));
    }

    public String startCreate() {
        myEntity = new Deliberation();
        return "createDeliberation";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewDeliberation";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editDeliberation";
    }

    public Deliberation getCurrentEntity() {
        Deliberation entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public Deliberation getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        Deliberation entity = (Deliberation) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public Deliberation findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        Deliberation entity = entityManager.find(Deliberation.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<Deliberation> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (Deliberation entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<Deliberation> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<Deliberation> entities = (List<Deliberation>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
