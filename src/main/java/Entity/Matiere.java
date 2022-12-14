package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Matiere {
    private long idMatiere;
    private String description;
    private String nomMatiere;

    @Id
    @Column(name = "id_matiere")
    public long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(long idMatiere) {
        this.idMatiere = idMatiere;
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
    @Column(name = "nom_matiere")
    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Matiere matiere = (Matiere) o;

        if (idMatiere != matiere.idMatiere) return false;
        if (description != null ? !description.equals(matiere.description) : matiere.description != null) return false;
        if (nomMatiere != null ? !nomMatiere.equals(matiere.nomMatiere) : matiere.nomMatiere != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idMatiere ^ (idMatiere >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nomMatiere != null ? nomMatiere.hashCode() : 0);
        return result;
    }
}
