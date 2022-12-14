package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Deliberation {
    private long idDeliberation;
    private Timestamp dateDeliberation;
    private String description;
    private Long idEvaluation;

    @Id
    @Column(name = "id_deliberation")
    public long getIdDeliberation() {
        return idDeliberation;
    }

    public void setIdDeliberation(long idDeliberation) {
        this.idDeliberation = idDeliberation;
    }

    @Basic
    @Column(name = "date_deliberation")
    public Timestamp getDateDeliberation() {
        return dateDeliberation;
    }

    public void setDateDeliberation(Timestamp dateDeliberation) {
        this.dateDeliberation = dateDeliberation;
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
    @Column(name = "id_evaluation")
    public Long getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Long idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Deliberation that = (Deliberation) o;

        if (idDeliberation != that.idDeliberation) return false;
        if (dateDeliberation != null ? !dateDeliberation.equals(that.dateDeliberation) : that.dateDeliberation != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (idEvaluation != null ? !idEvaluation.equals(that.idEvaluation) : that.idEvaluation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idDeliberation ^ (idDeliberation >>> 32));
        result = 31 * result + (dateDeliberation != null ? dateDeliberation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (idEvaluation != null ? idEvaluation.hashCode() : 0);
        return result;
    }
}
