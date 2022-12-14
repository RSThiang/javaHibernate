package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Serie {
    private int idSerie;
    private String nomSerie;

    @Id
    @Column(name = "id_serie")
    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    @Basic
    @Column(name = "nom_serie")
    public String getNomSerie() {
        return nomSerie;
    }

    public void setNomSerie(String nomSerie) {
        this.nomSerie = nomSerie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Serie serie = (Serie) o;

        if (idSerie != serie.idSerie) return false;
        if (nomSerie != null ? !nomSerie.equals(serie.nomSerie) : serie.nomSerie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSerie;
        result = 31 * result + (nomSerie != null ? nomSerie.hashCode() : 0);
        return result;
    }
}
