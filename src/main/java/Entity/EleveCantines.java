package Entity;

import javax.persistence.*;

@Entity
@Table(name = "eleve_cantines", schema = "public", catalog = "Gestionscolaire")
public class EleveCantines {
    private long id;
    private long idCantine;
    private long idEleve;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_cantine")
    public long getIdCantine() {
        return idCantine;
    }

    public void setIdCantine(long idCantine) {
        this.idCantine = idCantine;
    }

    @Basic
    @Column(name = "id_eleve")
    public long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(long idEleve) {
        this.idEleve = idEleve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EleveCantines that = (EleveCantines) o;

        if (id != that.id) return false;
        if (idCantine != that.idCantine) return false;
        if (idEleve != that.idEleve) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idCantine ^ (idCantine >>> 32));
        result = 31 * result + (int) (idEleve ^ (idEleve >>> 32));
        return result;
    }
}
