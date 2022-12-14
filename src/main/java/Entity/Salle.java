package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Salle {
    private long idSalle;
    private int nbrePlace;
    private String nomSalle;
    private int numeroSalle;
    private String type;
    private Long idBatiment;

    @Id
    @Column(name = "id_salle")
    public long getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(long idSalle) {
        this.idSalle = idSalle;
    }

    @Basic
    @Column(name = "nbre_place")
    public int getNbrePlace() {
        return nbrePlace;
    }

    public void setNbrePlace(int nbrePlace) {
        this.nbrePlace = nbrePlace;
    }

    @Basic
    @Column(name = "nom_salle")
    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    @Basic
    @Column(name = "numero_salle")
    public int getNumeroSalle() {
        return numeroSalle;
    }

    public void setNumeroSalle(int numeroSalle) {
        this.numeroSalle = numeroSalle;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "id_batiment")
    public Long getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(Long idBatiment) {
        this.idBatiment = idBatiment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salle salle = (Salle) o;

        if (idSalle != salle.idSalle) return false;
        if (nbrePlace != salle.nbrePlace) return false;
        if (numeroSalle != salle.numeroSalle) return false;
        if (nomSalle != null ? !nomSalle.equals(salle.nomSalle) : salle.nomSalle != null) return false;
        if (type != null ? !type.equals(salle.type) : salle.type != null) return false;
        if (idBatiment != null ? !idBatiment.equals(salle.idBatiment) : salle.idBatiment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSalle ^ (idSalle >>> 32));
        result = 31 * result + nbrePlace;
        result = 31 * result + (nomSalle != null ? nomSalle.hashCode() : 0);
        result = 31 * result + numeroSalle;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (idBatiment != null ? idBatiment.hashCode() : 0);
        return result;
    }
}
