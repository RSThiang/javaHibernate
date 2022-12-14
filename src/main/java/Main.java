

import Dao.EcoleDaoImp;
import Dao.LogiImplement;
import Entity.Ecole;
import Entity.Login;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    private EntityManager emf = Persistence.createEntityManagerFactory("persistenceUniName").createEntityManager();

     public static void main(String[] args) {
         for (Ecole ecole: new EcoleDaoImp().listeEcole()) {
             System.out.println(ecole.getNomecole());
         }
          for(Login login : new LogiImplement().listeusers()){
              System.out.println(login.getUsername());
         }
    }



}