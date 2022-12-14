package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cantine {
    private long idCantine;
    private double montant;
    private String nomDejeuner;

    @Id
    @Column(name = "id_cantine")
    public long getIdCantine() {
        return idCantine;
    }

    public void setIdCantine(long idCantine) {
        this.idCantine = idCantine;
    }

    @Basic
    @Column(name = "montant")
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Basic
    @Column(name = "nom_dejeuner")
    public String getNomDejeuner() {
        return nomDejeuner;
    }

    public void setNomDejeuner(String nomDejeuner) {
        this.nomDejeuner = nomDejeuner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cantine cantine = (Cantine) o;

        if (idCantine != cantine.idCantine) return false;
        if (Double.compare(cantine.montant, montant) != 0) return false;
        if (nomDejeuner != null ? !nomDejeuner.equals(cantine.nomDejeuner) : cantine.nomDejeuner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (idCantine ^ (idCantine >>> 32));
        temp = Double.doubleToLongBits(montant);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (nomDejeuner != null ? nomDejeuner.hashCode() : 0);
        return result;
    }
}
