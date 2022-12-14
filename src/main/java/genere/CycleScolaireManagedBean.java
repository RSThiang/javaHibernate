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

import Entity.CycleScolaire;

public class CycleScolaireManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM CycleScolaire AS o";

    private CycleScolaire myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public CycleScolaireManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public CycleScolaire getEntity() {
        return myEntity;
    }

    public void setEntity(CycleScolaire entity) {
        myEntity = entity;
    }

    // add new CycleScolaire
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

        return "cycleScolaireList";
    }

    // save edited CycleScolaire
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
        return "cycleScolaireList";
    }

    // delete CycleScolaire
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            CycleScolaire entity = getCurrentEntity();
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

        return "cycleScolaireList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<CycleScolaire> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<CycleScolaire>(entities));
    }

    public String startCreate() {
        myEntity = new CycleScolaire();
        return "createCycleScolaire";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewCycleScolaire";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editCycleScolaire";
    }

    public CycleScolaire getCurrentEntity() {
        CycleScolaire entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public CycleScolaire getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        CycleScolaire entity = (CycleScolaire) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public CycleScolaire findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        CycleScolaire entity = entityManager.find(CycleScolaire.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<CycleScolaire> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (CycleScolaire entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<CycleScolaire> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<CycleScolaire> entities = (List<CycleScolaire>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
