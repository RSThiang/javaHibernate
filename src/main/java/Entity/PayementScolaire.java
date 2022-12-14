package Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payement_scolaire", schema = "public", catalog = "Gestionscolaire")
public class PayementScolaire {
    private long idPayement;
    private Timestamp datePayement;
    private String description;
    private Double montantPayement;
    private Long idEleve;

    @Id
    @Column(name = "id_payement")
    public long getIdPayement() {
        return idPayement;
    }

    public void setIdPayement(long idPayement) {
        this.idPayement = idPayement;
    }

    @Basic
    @Column(name = "date_payement")
    public Timestamp getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Timestamp datePayement) {
        this.datePayement = datePayement;
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
    @Column(name = "montant_payement")
    public Double getMontantPayement() {
        return montantPayement;
    }

    public void setMontantPayement(Double montantPayement) {
        this.montantPayement = montantPayement;
    }

    @Basic
    @Column(name = "id_eleve")
    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PayementScolaire that = (PayementScolaire) o;

        if (idPayement != that.idPayement) return false;
        if (datePayement != null ? !datePayement.equals(that.datePayement) : that.datePayement != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (montantPayement != null ? !montantPayement.equals(that.montantPayement) : that.montantPayement != null)
            return false;
        if (idEleve != null ? !idEleve.equals(that.idEleve) : that.idEleve != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPayement ^ (idPayement >>> 32));
        result = 31 * result + (datePayement != null ? datePayement.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (montantPayement != null ? montantPayement.hashCode() : 0);
        result = 31 * result + (idEleve != null ? idEleve.hashCode() : 0);
        return result;
    }
}
