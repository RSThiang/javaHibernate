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

import Entity.Chauffeur;

public class ChauffeurManagedBean {
    final public static String SELECT_ALL_ENTITIES_SQL = "SELECT o FROM Chauffeur AS o";

    private Chauffeur myEntity;

    private EntityManagerFactory myEntityManagerFactory;

    private ListDataModel myList;
    private ListDataModel myReferencesEntities; // M-N and M-1 references

    public ChauffeurManagedBean() {
        myEntityManagerFactory = Persistence.createEntityManagerFactory("persistenceUniName");
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return myEntityManagerFactory;
    }

    public Chauffeur getEntity() {
        return myEntity;
    }

    public void setEntity(Chauffeur entity) {
        myEntity = entity;
    }

    // add new Chauffeur
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

        return "chauffeurList";
    }

    // save edited Chauffeur
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
        return "chauffeurList";
    }

    // delete Chauffeur
    public String delete() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Chauffeur entity = getCurrentEntity();
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

        return "chauffeurList";
    }

    public DataModel getReferencedEntities() {
        return myReferencesEntities;
    }

    public void setReferencedEntities(Collection<Chauffeur> entities) {
        myReferencesEntities = new ListDataModel(new ArrayList<Chauffeur>(entities));
    }

    public String startCreate() {
        myEntity = new Chauffeur();
        return "createChauffeur";
    }

    public String startView() {
        setEntityFromRequestParam();
        return "viewChauffeur";
    }

    public String startEdit() {
        setEntityFromRequestParam();
        return "editChauffeur";
    }

    public Chauffeur getCurrentEntity() {
        Chauffeur entity = getEntityFromRequestParam();

        return entity == null ? myEntity : entity;
    }

    public Chauffeur getEntityFromRequestParam() {
        if (myList == null) return null;

        EntityManager entityManager = getEntityManagerFactory().createEntityManager();
        Chauffeur entity = (Chauffeur) myList.getRowData();
        entity = entityManager.merge(entity);
        entityManager.close();

        return entity;
    }

    public void setEntityFromRequestParam() {
        myEntity = getCurrentEntity();
    }

    public Chauffeur findEntity(long id) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        Chauffeur entity = entityManager.find(Chauffeur.class, id);

        entityManager.close();

        return entity;
    }

    public DataModel getAllEntities() {
        myList = new ListDataModel(getEntities());

        return myList;
    }

    public SelectItem[] getAllEntitiesAsSelectedItems() {
        List<Chauffeur> entities = getEntities();
        SelectItem selectItems[] = new SelectItem[entities.size()];
        int i = 0;
        for (Chauffeur entity : entities) {
            selectItems[i++] = new SelectItem(entity);
        }
        return selectItems;
    }

    public List<Chauffeur> getEntities() {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        List<Chauffeur> entities = (List<Chauffeur>) entityManager.createQuery(SELECT_ALL_ENTITIES_SQL).getResultList();

        entityManager.close();

        return entities;
    }
}
