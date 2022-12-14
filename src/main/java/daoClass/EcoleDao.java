package daoClass;


import Dao.EcoleDaoImp;
import Entity.Ecole;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Named
@RequestScoped
public class EcoleDao {
private int idEcole;
    private String addresseecole;
    private String nomecole;
    private List<Ecole> listes;
    private List<Ecole> l;
    private Ecole ecole;


@PostConstruct
public void init(){
    ecole = new Ecole();
}
   public void ajouterEcoles(){
      new EcoleDaoImp().save(ecole);

   }
   public void modifier(){
    new EcoleDaoImp().update(ecole);
}

    public int getIdEcole() {
        return idEcole;
    }

    public Ecole getEcole() {
        return ecole;
    }


    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    public String getAddresseecole() {
        return addresseecole;
    }

    public void setAddresseecole(String addresseecole) {
        this.addresseecole = addresseecole;
    }

    public String getNomecole() {
        return nomecole;
    }

    public void setNomecole(String nomecole) {
        this.nomecole = nomecole;
    }
    public List<Ecole> getListes() {

       listes = new EcoleDaoImp().listeEcole();
        return listes;
    }

    public void setListes(List<Ecole> liste) {
        this.listes = liste;
    }

    public List<Ecole> getL() {

        l = (List<Ecole>) new EcoleDaoImp().load(idEcole);
         return l;
    }


    public void setL(List<Ecole> l) {
        this.l = l;
    }
}

