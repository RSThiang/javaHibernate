package Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "programme_reunion", schema = "public", catalog = "Gestionscolaire")
public class ProgrammeReunion {
    private long idProgramme;
    private Timestamp heure;
    private Timestamp jour;
    private Long idSalle;

    @Id
    @Column(name = "id_programme")
    public long getIdProgramme() {
        return idProgramme;
    }

    public void setIdProgramme(long idProgramme) {
        this.idProgramme = idProgramme;
    }

    @Basic
    @Column(name = "heure")
    public Timestamp getHeure() {
        return heure;
    }

    public void setHeure(Timestamp heure) {
        this.heure = heure;
    }

    @Basic
    @Column(name = "jour")
    public Timestamp getJour() {
        return jour;
    }

    public void setJour(Timestamp jour) {
        this.jour = jour;
    }

    @Basic
    @Column(name = "id_salle")
    public Long getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Long idSalle) {
        this.idSalle = idSalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgrammeReunion that = (ProgrammeReunion) o;

        if (idProgramme != that.idProgramme) return false;
        if (heure != null ? !heure.equals(that.heure) : that.heure != null) return false;
        if (jour != null ? !jour.equals(that.jour) : that.jour != null) return false;
        if (idSalle != null ? !idSalle.equals(that.idSalle) : that.idSalle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idProgramme ^ (idProgramme >>> 32));
        result = 31 * result + (heure != null ? heure.hashCode() : 0);
        result = 31 * result + (jour != null ? jour.hashCode() : 0);
        result = 31 * result + (idSalle != null ? idSalle.hashCode() : 0);
        return result;
    }
}
