package Entity;

import javax.persistence.*;

@Entity
@Table(name = "personnel_ecoles", schema = "public", catalog = "Gestionscolaire")
public class PersonnelEcoles {
    private long id;
    private long idEcole;
    private long idPersonnel;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_ecole")
    public long getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(long idEcole) {
        this.idEcole = idEcole;
    }

    @Basic
    @Column(name = "id_personnel")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnelEcoles that = (PersonnelEcoles) o;

        if (id != that.id) return false;
        if (idEcole != that.idEcole) return false;
        if (idPersonnel != that.idPersonnel) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (idEcole ^ (idEcole >>> 32));
        result = 31 * result + (int) (idPersonnel ^ (idPersonnel >>> 32));
        return result;
    }
}
