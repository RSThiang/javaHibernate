package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Evaluation {
    private long idEvaluation;
    private Timestamp dateEvaluation;
    private String description;
    private String titreEvaluation;
    private String typeEvaluation;
    private Long idPersonnel;

    @Id
    @Column(name = "id_evaluation")
    public long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    @Basic
    @Column(name = "date_evaluation")
    public Timestamp getDateEvaluation() {
        return dateEvaluation;
    }

    public void setDateEvaluation(Timestamp dateEvaluation) {
        this.dateEvaluation = dateEvaluation;
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
    @Column(name = "titre_evaluation")
    public String getTitreEvaluation() {
        return titreEvaluation;
    }

    public void setTitreEvaluation(String titreEvaluation) {
        this.titreEvaluation = titreEvaluation;
    }

    @Basic
    @Column(name = "type_evaluation")
    public String getTypeEvaluation() {
        return typeEvaluation;
    }

    public void setTypeEvaluation(String typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    @Basic
    @Column(name = "id_personnel")
    public Long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evaluation that = (Evaluation) o;

        if (idEvaluation != that.idEvaluation) return false;
        if (dateEvaluation != null ? !dateEvaluation.equals(that.dateEvaluation) : that.dateEvaluation != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (titreEvaluation != null ? !titreEvaluation.equals(that.titreEvaluation) : that.titreEvaluation != null)
            return false;
        if (typeEvaluation != null ? !typeEvaluation.equals(that.typeEvaluation) : that.typeEvaluation != null)
            return false;
        if (idPersonnel != null ? !idPersonnel.equals(that.idPersonnel) : that.idPersonnel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEvaluation ^ (idEvaluation >>> 32));
        result = 31 * result + (dateEvaluation != null ? dateEvaluation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (titreEvaluation != null ? titreEvaluation.hashCode() : 0);
        result = 31 * result + (typeEvaluation != null ? typeEvaluation.hashCode() : 0);
        result = 31 * result + (idPersonnel != null ? idPersonnel.hashCode() : 0);
        return result;
    }
}
