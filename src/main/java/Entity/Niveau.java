package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Niveau {
    private long idNiveau;
    private String description;
    private String nomNiveau;
    private Long idCycle;

    @Id
    @Column(name = "id_niveau")
    public long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(long idNiveau) {
        this.idNiveau = idNiveau;
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
    @Column(name = "nom_niveau")
    public String getNomNiveau() {
        return nomNiveau;
    }

    public void setNomNiveau(String nomNiveau) {
        this.nomNiveau = nomNiveau;
    }

    @Basic
    @Column(name = "id_cycle")
    public Long getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(Long idCycle) {
        this.idCycle = idCycle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Niveau niveau = (Niveau) o;

        if (idNiveau != niveau.idNiveau) return false;
        if (description != null ? !description.equals(niveau.description) : niveau.description != null) return false;
        if (nomNiveau != null ? !nomNiveau.equals(niveau.nomNiveau) : niveau.nomNiveau != null) return false;
        if (idCycle != null ? !idCycle.equals(niveau.idCycle) : niveau.idCycle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idNiveau ^ (idNiveau >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nomNiveau != null ? nomNiveau.hashCode() : 0);
        result = 31 * result + (idCycle != null ? idCycle.hashCode() : 0);
        return result;
    }
}
