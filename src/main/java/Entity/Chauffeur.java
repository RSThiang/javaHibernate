package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Chauffeur {
    private long idChauffeur;
    private String email;
    private String nomChauffeur;
    private String prenomChauffeur;
    private String tel;

    @Id
    @Column(name = "id_chauffeur")
    public long getIdChauffeur() {
        return idChauffeur;
    }

    public void setIdChauffeur(long idChauffeur) {
        this.idChauffeur = idChauffeur;
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
    @Column(name = "nom_chauffeur")
    public String getNomChauffeur() {
        return nomChauffeur;
    }

    public void setNomChauffeur(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }

    @Basic
    @Column(name = "prenom_chauffeur")
    public String getPrenomChauffeur() {
        return prenomChauffeur;
    }

    public void setPrenomChauffeur(String prenomChauffeur) {
        this.prenomChauffeur = prenomChauffeur;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chauffeur chauffeur = (Chauffeur) o;

        if (idChauffeur != chauffeur.idChauffeur) return false;
        if (email != null ? !email.equals(chauffeur.email) : chauffeur.email != null) return false;
        if (nomChauffeur != null ? !nomChauffeur.equals(chauffeur.nomChauffeur) : chauffeur.nomChauffeur != null)
            return false;
        if (prenomChauffeur != null ? !prenomChauffeur.equals(chauffeur.prenomChauffeur) : chauffeur.prenomChauffeur != null)
            return false;
        if (tel != null ? !tel.equals(chauffeur.tel) : chauffeur.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idChauffeur ^ (idChauffeur >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nomChauffeur != null ? nomChauffeur.hashCode() : 0);
        result = 31 * result + (prenomChauffeur != null ? prenomChauffeur.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        return result;
    }
}
