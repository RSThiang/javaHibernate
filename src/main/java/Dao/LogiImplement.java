package Dao;


import DaoImplement.LogInter;
import Entity.Login;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class LogiImplement implements LogInter<Login> {


    private EntityManager emf = Persistence.createEntityManagerFactory("persistenceUniName").createEntityManager();

     @Override
    public List<Login> listeusers() {
        List<Login> login = emf.createQuery("Select t from  Login  t",Login.class).getResultList();
        return login;
    }



}
