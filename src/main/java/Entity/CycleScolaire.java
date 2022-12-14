package Entity;

import javax.persistence.*;

@Entity
@Table(name = "cycle_scolaire", schema = "public", catalog = "Gestionscolaire")
public class CycleScolaire {
    private long idCycle;
    private String description;
    private String nomCycle;
    private Long idEcole;

    @Id
    @Column(name = "id_cycle")
    public long getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(long idCycle) {
        this.idCycle = idCycle;
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
    @Column(name = "nom_cycle")
    public String getNomCycle() {
        return nomCycle;
    }

    public void setNomCycle(String nomCycle) {
        this.nomCycle = nomCycle;
    }

    @Basic
    @Column(name = "id_ecole")
    public Long getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(Long idEcole) {
        this.idEcole = idEcole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CycleScolaire that = (CycleScolaire) o;

        if (idCycle != that.idCycle) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (nomCycle != null ? !nomCycle.equals(that.nomCycle) : that.nomCycle != null) return false;
        if (idEcole != null ? !idEcole.equals(that.idEcole) : that.idEcole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCycle ^ (idCycle >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nomCycle != null ? nomCycle.hashCode() : 0);
        result = 31 * result + (idEcole != null ? idEcole.hashCode() : 0);
        return result;
    }
}
