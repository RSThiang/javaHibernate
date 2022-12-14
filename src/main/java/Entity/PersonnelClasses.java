package Entity;

import javax.persistence.*;

@Entity
@Table(name = "personnel_classes", schema = "public", catalog = "Gestionscolaire")
public class PersonnelClasses {
    private long id;
    private long personnel;
    private long idClasse;
    private Long personnelbypersonnelIdPersonnel;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "personnel")
    public long getPersonnel() {
        return personnel;
    }

    public void setPersonnel(long personnel) {
        this.personnel = personnel;
    }

    @Basic
    @Column(name = "id_classe")
    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    @Basic
    @Column(name = "personnelbypersonnel_id_personnel")
    public Long getPersonnelbypersonnelIdPersonnel() {
        return personnelbypersonnelIdPersonnel;
    }

    public void setPersonnelbypersonnelIdPersonnel(Long personnelbypersonnelIdPersonnel) {
        this.personnelbypersonnelIdPersonnel = personnelbypersonnelIdPersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnelClasses that = (PersonnelClasses) o;

        if (id != that.id) return false;
        if (personnel != that.personnel) return false;
        if (idClasse != that.idClasse) return false;
        if (personnelbypersonnelIdPersonnel != null ? !personnelbypersonnelIdPersonnel.equals(that.personnelbypersonnelIdPersonnel) : that.personnelbypersonnelIdPersonnel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (personnel ^ (personnel >>> 32));
        result = 31 * result + (int) (idClasse ^ (idClasse >>> 32));
        result = 31 * result + (personnelbypersonnelIdPersonnel != null ? personnelbypersonnelIdPersonnel.hashCode() : 0);
        return result;
    }
}
