package Entity;

import javax.persistence.*;

@Entity
@Table(name = "personnel_matiere", schema = "public", catalog = "Gestionscolaire")
public class PersonnelMatiere {
    private long id;
    private Long matierebyidmatiereIdMatiere;
    private Long personnelbyidpersonnelIdPersonnel;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "matierebyidmatiere_id_matiere")
    public Long getMatierebyidmatiereIdMatiere() {
        return matierebyidmatiereIdMatiere;
    }

    public void setMatierebyidmatiereIdMatiere(Long matierebyidmatiereIdMatiere) {
        this.matierebyidmatiereIdMatiere = matierebyidmatiereIdMatiere;
    }

    @Basic
    @Column(name = "personnelbyidpersonnel_id_personnel")
    public Long getPersonnelbyidpersonnelIdPersonnel() {
        return personnelbyidpersonnelIdPersonnel;
    }

    public void setPersonnelbyidpersonnelIdPersonnel(Long personnelbyidpersonnelIdPersonnel) {
        this.personnelbyidpersonnelIdPersonnel = personnelbyidpersonnelIdPersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonnelMatiere that = (PersonnelMatiere) o;

        if (id != that.id) return false;
        if (matierebyidmatiereIdMatiere != null ? !matierebyidmatiereIdMatiere.equals(that.matierebyidmatiereIdMatiere) : that.matierebyidmatiereIdMatiere != null)
            return false;
        if (personnelbyidpersonnelIdPersonnel != null ? !personnelbyidpersonnelIdPersonnel.equals(that.personnelbyidpersonnelIdPersonnel) : that.personnelbyidpersonnelIdPersonnel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (matierebyidmatiereIdMatiere != null ? matierebyidmatiereIdMatiere.hashCode() : 0);
        result = 31 * result + (personnelbyidpersonnelIdPersonnel != null ? personnelbyidpersonnelIdPersonnel.hashCode() : 0);
        return result;
    }
}
