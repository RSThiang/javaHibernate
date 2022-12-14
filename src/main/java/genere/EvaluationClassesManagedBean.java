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

import Entity.EvaluationClasses;

public class EvaluationClassesManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM EvaluationClasses AS o";

    private EvaluationClasses myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public EvaluationClassesManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public EvaluationClasses getEntity() {
        return myEntity;
    }

    public void setEntity(EvaluationClasses entity) {
        myEntity = entity;
    }

    // add new EvaluationClasses
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

        return "evaluationClassesList";
    }

    // save edited EvaluationClasses
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
        return "evaluationClassesList";
    }

    // delete EvaluationClasses
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            EvaluationClasses entity = getCurrentEntity();
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

        return "evaluationClassesList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<EvaluationClasses> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<EvaluationClasses>(entities));
    }

    public String startCreate() {
        myEntity = new EvaluationClasses();
        return "createEvaluationClasses";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewEvaluationClasses";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editEvaluationClasses";
    }

    public EvaluationClasses getCurrentEntity() {
        EvaluationClasses entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public EvaluationClasses getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        EvaluationClasses entity = (EvaluationClasses) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public EvaluationClasses findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        EvaluationClasses entity = entityManager.find(EvaluationClasses.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<EvaluationClasses> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (EvaluationClasses entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<EvaluationClasses> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<EvaluationClasses> entities = (List<EvaluationClasses>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
