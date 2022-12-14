package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Eleve {
    private long idEleve;
    private String email;
    private String matricule;
    private String nomEleve;
    private String password;
    private String prenomEleve;
    private String tel;
    private String type;
    private Long idClasse;
    private Long idDeliberation;
    private Long idParents;

    @Id
    @Column(name = "id_eleve")
    public long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(long idEleve) {
        this.idEleve = idEleve;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "matricule")
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Basic
    @Column(name = "nom_eleve")
    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "prenom_eleve")
    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "id_classe")
    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    @Basic
    @Column(name = "id_deliberation")
    public Long getIdDeliberation() {
        return idDeliberation;
    }

    public void setIdDeliberation(Long idDeliberation) {
        this.idDeliberation = idDeliberation;
    }

    @Basic
    @Column(name = "id_parents")
    public Long getIdParents() {
        return idParents;
    }

    public void setIdParents(Long idParents) {
        this.idParents = idParents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Eleve eleve = (Eleve) o;

        if (idEleve != eleve.idEleve) return false;
        if (email != null ? !email.equals(eleve.email) : eleve.email != null) return false;
        if (matricule != null ? !matricule.equals(eleve.matricule) : eleve.matricule != null) return false;
        if (nomEleve != null ? !nomEleve.equals(eleve.nomEleve) : eleve.nomEleve != null) return false;
        if (password != null ? !password.equals(eleve.password) : eleve.password != null) return false;
        if (prenomEleve != null ? !prenomEleve.equals(eleve.prenomEleve) : eleve.prenomEleve != null) return false;
        if (tel != null ? !tel.equals(eleve.tel) : eleve.tel != null) return false;
        if (type != null ? !type.equals(eleve.type) : eleve.type != null) return false;
        if (idClasse != null ? !idClasse.equals(eleve.idClasse) : eleve.idClasse != null) return false;
        if (idDeliberation != null ? !idDeliberation.equals(eleve.idDeliberation) : eleve.idDeliberation != null)
            return false;
        if (idParents != null ? !idParents.equals(eleve.idParents) : eleve.idParents != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEleve ^ (idEleve >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (matricule != null ? matricule.hashCode() : 0);
        result = 31 * result + (nomEleve != null ? nomEleve.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (prenomEleve != null ? prenomEleve.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (idClasse != null ? idClasse.hashCode() : 0);
        result = 31 * result + (idDeliberation != null ? idDeliberation.hashCode() : 0);
        result = 31 * result + (idParents != null ? idParents.hashCode() : 0);
        return result;
    }
}
