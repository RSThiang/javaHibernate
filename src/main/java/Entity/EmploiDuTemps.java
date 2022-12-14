package Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "emploi_du_temps", schema = "public", catalog = "Gestionscolaire")
public class EmploiDuTemps {
    private long idEmploiDuTemps;
    private int dureCours;
    private Timestamp heure;
    private Timestamp jour;
    private String matiere;
    private String prof;
    private Long classebyidclasseIdClasse;
    private Long promotionbyidpromotionIdPromotion;
    private Long sallebyidsalleIdSalle;

    @Id
    @Column(name = "id_emploi_du_temps")
    public long getIdEmploiDuTemps() {
        return idEmploiDuTemps;
    }

    public void setIdEmploiDuTemps(long idEmploiDuTemps) {
        this.idEmploiDuTemps = idEmploiDuTemps;
    }

    @Basic
    @Column(name = "dure_cours")
    public int getDureCours() {
        return dureCours;
    }

    public void setDureCours(int dureCours) {
        this.dureCours = dureCours;
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
    @Column(name = "matiere")
    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    @Basic
    @Column(name = "prof")
    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    @Basic
    @Column(name = "classebyidclasse_id_classe")
    public Long getClassebyidclasseIdClasse() {
        return classebyidclasseIdClasse;
    }

    public void setClassebyidclasseIdClasse(Long classebyidclasseIdClasse) {
        this.classebyidclasseIdClasse = classebyidclasseIdClasse;
    }

    @Basic
    @Column(name = "promotionbyidpromotion_id_promotion")
    public Long getPromotionbyidpromotionIdPromotion() {
        return promotionbyidpromotionIdPromotion;
    }

    public void setPromotionbyidpromotionIdPromotion(Long promotionbyidpromotionIdPromotion) {
        this.promotionbyidpromotionIdPromotion = promotionbyidpromotionIdPromotion;
    }

    @Basic
    @Column(name = "sallebyidsalle_id_salle")
    public Long getSallebyidsalleIdSalle() {
        return sallebyidsalleIdSalle;
    }

    public void setSallebyidsalleIdSalle(Long sallebyidsalleIdSalle) {
        this.sallebyidsalleIdSalle = sallebyidsalleIdSalle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmploiDuTemps that = (EmploiDuTemps) o;

        if (idEmploiDuTemps != that.idEmploiDuTemps) return false;
        if (dureCours != that.dureCours) return false;
        if (heure != null ? !heure.equals(that.heure) : that.heure != null) return false;
        if (jour != null ? !jour.equals(that.jour) : that.jour != null) return false;
        if (matiere != null ? !matiere.equals(that.matiere) : that.matiere != null) return false;
        if (prof != null ? !prof.equals(that.prof) : that.prof != null) return false;
        if (classebyidclasseIdClasse != null ? !classebyidclasseIdClasse.equals(that.classebyidclasseIdClasse) : that.classebyidclasseIdClasse != null)
            return false;
        if (promotionbyidpromotionIdPromotion != null ? !promotionbyidpromotionIdPromotion.equals(that.promotionbyidpromotionIdPromotion) : that.promotionbyidpromotionIdPromotion != null)
            return false;
        if (sallebyidsalleIdSalle != null ? !sallebyidsalleIdSalle.equals(that.sallebyidsalleIdSalle) : that.sallebyidsalleIdSalle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEmploiDuTemps ^ (idEmploiDuTemps >>> 32));
        result = 31 * result + dureCours;
        result = 31 * result + (heure != null ? heure.hashCode() : 0);
        result = 31 * result + (jour != null ? jour.hashCode() : 0);
        result = 31 * result + (matiere != null ? matiere.hashCode() : 0);
        result = 31 * result + (prof != null ? prof.hashCode() : 0);
        result = 31 * result + (classebyidclasseIdClasse != null ? classebyidclasseIdClasse.hashCode() : 0);
        result = 31 * result + (promotionbyidpromotionIdPromotion != null ? promotionbyidpromotionIdPromotion.hashCode() : 0);
        result = 31 * result + (sallebyidsalleIdSalle != null ? sallebyidsalleIdSalle.hashCode() : 0);
        return result;
    }
}
