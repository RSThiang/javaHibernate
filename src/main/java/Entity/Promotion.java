package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Promotion {
    private long idPromotion;
    private String anneeScolaire;

    @Id
    @Column(name = "id_promotion")
    public long getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(long idPromotion) {
        this.idPromotion = idPromotion;
    }

    @Basic
    @Column(name = "annee_scolaire")
    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (idPromotion != promotion.idPromotion) return false;
        if (anneeScolaire != null ? !anneeScolaire.equals(promotion.anneeScolaire) : promotion.anneeScolaire != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPromotion ^ (idPromotion >>> 32));
        result = 31 * result + (anneeScolaire != null ? anneeScolaire.hashCode() : 0);
        return result;
    }
}
