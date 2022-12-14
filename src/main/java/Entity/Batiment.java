package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Batiment {
    private long idBatiment;
    private String nomBatiment;
    private Long ecolebyidecoleIdEcole;

    @Id
    @Column(name = "id_batiment")
    public long getIdBatiment() {
        return idBatiment;
    }

    public void setIdBatiment(long idBatiment) {
        this.idBatiment = idBatiment;
    }

    @Basic
    @Column(name = "nom_batiment")
    public String getNomBatiment() {
        return nomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        this.nomBatiment = nomBatiment;
    }

    @Basic
    @Column(name = "ecolebyidecole_id_ecole")
    public Long getEcolebyidecoleIdEcole() {
        return ecolebyidecoleIdEcole;
    }

    public void setEcolebyidecoleIdEcole(Long ecolebyidecoleIdEcole) {
        this.ecolebyidecoleIdEcole = ecolebyidecoleIdEcole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Batiment batiment = (Batiment) o;

        if (idBatiment != batiment.idBatiment) return false;
        if (nomBatiment != null ? !nomBatiment.equals(batiment.nomBatiment) : batiment.nomBatiment != null)
            return false;
        if (ecolebyidecoleIdEcole != null ? !ecolebyidecoleIdEcole.equals(batiment.ecolebyidecoleIdEcole) : batiment.ecolebyidecoleIdEcole != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idBatiment ^ (idBatiment >>> 32));
        result = 31 * result + (nomBatiment != null ? nomBatiment.hashCode() : 0);
        result = 31 * result + (ecolebyidecoleIdEcole != null ? ecolebyidecoleIdEcole.hashCode() : 0);
        return result;
    }
}
