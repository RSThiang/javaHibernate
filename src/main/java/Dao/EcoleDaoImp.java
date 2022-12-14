package Dao;

import DaoImplement.DaoInterface;
import Entity.Ecole;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


public class EcoleDaoImp implements DaoInterface<Ecole> {

    private EntityManager emf = Persistence.createEntityManagerFactory("persistenceUniName").createEntityManager();

    @Override
    public void save(Ecole ecole) {
        emf.getTransaction().begin();
        emf.persist(ecole);
        emf.getTransaction().commit();
    }

    @Override
    public Ecole load(int id) {

        Ecole ec = emf.find(Ecole.class, id);
        return ec;
    }

    @Override
    public void delete(long id) {
         Ecole  e = emf.find(Ecole.class, id);

        emf.getTransaction().begin();
        emf.remove(e);
        emf.getTransaction().commit();
    }

    @Override
    public void update(Ecole ecole) {

         emf.getTransaction().begin();
        emf.merge(ecole);
        emf.getTransaction().commit();
    }

    @Override
    public List<Ecole> listeEcole() {
         List<Ecole> ecoles = emf.createQuery("Select t from  Ecole  t",Ecole.class).getResultList();
        return ecoles;
    }

}

