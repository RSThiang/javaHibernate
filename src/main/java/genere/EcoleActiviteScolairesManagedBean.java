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

import Entity.EcoleActiviteScolaires;

public class EcoleActiviteScolairesManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM EcoleActiviteScolaires AS o";

    private EcoleActiviteScolaires myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public EcoleActiviteScolairesManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public EcoleActiviteScolaires getEntity() {
        return myEntity;
    }

    public void setEntity(EcoleActiviteScolaires entity) {
        myEntity = entity;
    }

    // add new EcoleActiviteScolaires
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

        return "ecoleActiviteScolairesList";
    }

    // save edited EcoleActiviteScolaires
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
        return "ecoleActiviteScolairesList";
    }

    // delete EcoleActiviteScolaires
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            EcoleActiviteScolaires entity = getCurrentEntity();
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

        return "ecoleActiviteScolairesList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<EcoleActiviteScolaires> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<EcoleActiviteScolaires>(entities));
    }

    public String startCreate() {
        myEntity = new EcoleActiviteScolaires();
        return "createEcoleActiviteScolaires";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewEcoleActiviteScolaires";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editEcoleActiviteScolaires";
    }

    public EcoleActiviteScolaires getCurrentEntity() {
        EcoleActiviteScolaires entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public EcoleActiviteScolaires getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        EcoleActiviteScolaires entity = (EcoleActiviteScolaires) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public EcoleActiviteScolaires findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        EcoleActiviteScolaires entity = entityManager.find(EcoleActiviteScolaires.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<EcoleActiviteScolaires> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (EcoleActiviteScolaires entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<EcoleActiviteScolaires> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<EcoleActiviteScolaires> entities = (List<EcoleActiviteScolaires>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
