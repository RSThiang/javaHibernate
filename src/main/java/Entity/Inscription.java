package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Inscription {
    private long idInscription;
    private Timestamp dateInscription;
    private String description;
    private Long ideleve;
    private Long classebyidclasseIdClasse;
    private Long idEleve;
    private Long idPromotion;

    @Id
    @Column(name = "id_inscription")
    public long getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(long idInscription) {
        this.idInscription = idInscription;
    }

    @Basic
    @Column(name = "date_inscription")
    public Timestamp getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Timestamp dateInscription) {
        this.dateInscription = dateInscription;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ideleve")
    public Long getIdeleve() {
        return ideleve;
    }

    public void setIdeleve(Long ideleve) {
        this.ideleve = ideleve;
    }

    @Basic
    @Column(name = "classebyidclasse_id_classe")
    public Long getClassebyidclasseIdClasse() {
        return classebyidclasseIdClasse;
    }

    public void setClassebyidclasseIdClasse(Long classebyidclasseIdClasse) {
        this.classebyidclasseIdClasse = classebyidclasseIdClasse;
    }

    @Basic
    @Column(name = "id_eleve")
    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    @Basic
    @Column(name = "id_promotion")
    public Long getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Long idPromotion) {
        this.idPromotion = idPromotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscription that = (Inscription) o;

        if (idInscription != that.idInscription) return false;
        if (dateInscription != null ? !dateInscription.equals(that.dateInscription) : that.dateInscription != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (ideleve != null ? !ideleve.equals(that.ideleve) : that.ideleve != null) return false;
        if (classebyidclasseIdClasse != null ? !classebyidclasseIdClasse.equals(that.classebyidclasseIdClasse) : that.classebyidclasseIdClasse != null)
            return false;
        if (idEleve != null ? !idEleve.equals(that.idEleve) : that.idEleve != null) return false;
        if (idPromotion != null ? !idPromotion.equals(that.idPromotion) : that.idPromotion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idInscription ^ (idInscription >>> 32));
        result = 31 * result + (dateInscription != null ? dateInscription.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (ideleve != null ? ideleve.hashCode() : 0);
        result = 31 * result + (classebyidclasseIdClasse != null ? classebyidclasseIdClasse.hashCode() : 0);
        result = 31 * result + (idEleve != null ? idEleve.hashCode() : 0);
        result = 31 * result + (idPromotion != null ? idPromotion.hashCode() : 0);
        return result;
    }
}
