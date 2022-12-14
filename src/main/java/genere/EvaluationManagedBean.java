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

import Entity.Evaluation;

public class EvaluationManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM Evaluation AS o";

    private Evaluation myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public EvaluationManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public Evaluation getEntity() {
        return myEntity;
    }

    public void setEntity(Evaluation entity) {
        myEntity = entity;
    }

    // add new Evaluation
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

        return "evaluationList";
    }

    // save edited Evaluation
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
        return "evaluationList";
    }

    // delete Evaluation
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Evaluation entity = getCurrentEntity();
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

        return "evaluationList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<Evaluation> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<Evaluation>(entities));
    }

    public String startCreate() {
        myEntity = new Evaluation();
        return "createEvaluation";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewEvaluation";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editEvaluation";
    }

    public Evaluation getCurrentEntity() {
        Evaluation entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public Evaluation getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        Evaluation entity = (Evaluation) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public Evaluation findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        Evaluation entity = entityManager.find(Evaluation.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<Evaluation> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (Evaluation entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<Evaluation> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<Evaluation> entities = (List<Evaluation>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
