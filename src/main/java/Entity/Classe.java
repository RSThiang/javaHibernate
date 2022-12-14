package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classe {
    private long idClasse;
    private String indiceClasse;
    private Long idNiveau;
    private Integer idSerie;

    @Id
    @Column(name = "id_classe")
    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    @Basic
    @Column(name = "indice_classe")
    public String getIndiceClasse() {
        return indiceClasse;
    }

    public void setIndiceClasse(String indiceClasse) {
        this.indiceClasse = indiceClasse;
    }

    @Basic
    @Column(name = "id_niveau")
    public Long getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Long idNiveau) {
        this.idNiveau = idNiveau;
    }

    @Basic
    @Column(name = "id_serie")
    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classe classe = (Classe) o;

        if (idClasse != classe.idClasse) return false;
        if (indiceClasse != null ? !indiceClasse.equals(classe.indiceClasse) : classe.indiceClasse != null)
            return false;
        if (idNiveau != null ? !idNiveau.equals(classe.idNiveau) : classe.idNiveau != null) return false;
        if (idSerie != null ? !idSerie.equals(classe.idSerie) : classe.idSerie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idClasse ^ (idClasse >>> 32));
        result = 31 * result + (indiceClasse != null ? indiceClasse.hashCode() : 0);
        result = 31 * result + (idNiveau != null ? idNiveau.hashCode() : 0);
        result = 31 * result + (idSerie != null ? idSerie.hashCode() : 0);
        return result;
    }
}
