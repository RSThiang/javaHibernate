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

import Entity.ProgrammeReunion;

public class ProgrammeReunionManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM ProgrammeReunion AS o";

    private ProgrammeReunion myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public ProgrammeReunionManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public ProgrammeReunion getEntity() {
        return myEntity;
    }

    public void setEntity(ProgrammeReunion entity) {
        myEntity = entity;
    }

    // add new ProgrammeReunion
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

        return "programmeReunionList";
    }

    // save edited ProgrammeReunion
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
        return "programmeReunionList";
    }

    // delete ProgrammeReunion
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            ProgrammeReunion entity = getCurrentEntity();
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

        return "programmeReunionList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<ProgrammeReunion> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<ProgrammeReunion>(entities));
    }

    public String startCreate() {
        myEntity = new ProgrammeReunion();
        return "createProgrammeReunion";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewProgrammeReunion";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editProgrammeReunion";
    }

    public ProgrammeReunion getCurrentEntity() {
        ProgrammeReunion entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public ProgrammeReunion getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        ProgrammeReunion entity = (ProgrammeReunion) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public ProgrammeReunion findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        ProgrammeReunion entity = entityManager.find(ProgrammeReunion.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<ProgrammeReunion> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (ProgrammeReunion entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<ProgrammeReunion> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<ProgrammeReunion> entities = (List<ProgrammeReunion>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
