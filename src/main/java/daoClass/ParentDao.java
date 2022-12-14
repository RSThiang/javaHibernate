package daoClass;


import Entity.Ecole;
import Entity.Parents;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Named
@RequestScoped
public class ParentDao {
    private long idParents;
    private String attrAdresse;
    private String email;
    private String prenomMere;
    private String prenomPere;
    private String tel1;
    private String tel2;
    private List<Parents> parents;
    EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUniName").createEntityManager();


    @PostConstruct
    public void init(){

    }
    public long getIdParents() {
        return idParents;
    }

    public void setIdParents(long idParents) {
        this.idParents = idParents;
    }

    public String getAttrAdresse() {
        return attrAdresse;
    }

    public void setAttrAdresse(String attrAdresse) {
        this.attrAdresse = attrAdresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public void ajouterParent(){

        Parents p = new Parents();
        p.setAttrAdresse(attrAdresse);
        p.setEmail(email);
        p.setPrenomMere(prenomMere);
        p.setPrenomPere(prenomPere);
        p.setTel1(tel1);
        p.setTel2(tel2);

        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }


}
