package Entity;

import javax.persistence.*;

@Entity
@Table(name = "ecole_activite_scolaires", schema = "public", catalog = "Gestionscolaire")
public class EcoleActiviteScolaires {
    private long id;
    private long idActivite;
    private long idEcole;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_activite")
    public long getIdActivite() {
        return idActivite;
    }

    public void setIdActivite(long idActivite) {
        this.idActivite = idActivite;
    }

    @Basic
    @Column(name = "id_ecole")
    public long getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(long idEcole) {
        this.idEcole = idEcole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EcoleActiviteScolaires that = (EcoleActiviteScolaires) o;

        if (id != that.id) return false;
        if (idActivite != that.idActivite) return false;
        if (idEcole != that.idEcole) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idActivite ^ (idActivite >>> 32));
        result = 31 * result + (int) (idEcole ^ (idEcole >>> 32));
        return result;
    }
}
