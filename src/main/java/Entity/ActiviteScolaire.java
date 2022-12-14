package Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activite_scolaire", schema = "public", catalog = "Gestionscolaire")
public class ActiviteScolaire {
    private long idActivite;
    private Timestamp date;
    private String description;
    private String lieu;
    private String nomActivite;

    @Id
    @Column(name = "id_activite")
    public long getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(long idActivite) {
        this.idActivite = idActivite;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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
    @Column(name = "lieu")
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @Basic
    @Column(name = "nom_activite")
    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActiviteScolaire that = (ActiviteScolaire) o;

        if (idActivite != that.idActivite) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (lieu != null ? !lieu.equals(that.lieu) : that.lieu != null) return false;
        if (nomActivite != null ? !nomActivite.equals(that.nomActivite) : that.nomActivite != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idActivite ^ (idActivite >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lieu != null ? lieu.hashCode() : 0);
        result = 31 * result + (nomActivite != null ? nomActivite.hashCode() : 0);
        return result;
    }
}
