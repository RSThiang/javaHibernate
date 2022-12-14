package Entity;

import javax.persistence.*;

@Entity
@Table(name = "note_cours", schema = "public", catalog = "Gestionscolaire")
public class NoteCours {
    private long idNoteCours;
    private String description;
    private Long personnel;
    private String titreCours;
    private Long personnelbypersonnelIdPersonnel;

    @Id
    @Column(name = "id_note_cours")
    public long getIdNoteCours() {
        return idNoteCours;
    }

    public void setIdNoteCours(long idNoteCours) {
        this.idNoteCours = idNoteCours;
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
    @Column(name = "personnel")
    public Long getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Long personnel) {
        this.personnel = personnel;
    }

    @Basic
    @Column(name = "titre_cours")
    public String getTitreCours() {
        return titreCours;
    }

    public void setTitreCours(String titreCours) {
        this.titreCours = titreCours;
    }

    @Basic
    @Column(name = "personnelbypersonnel_id_personnel")
    public Long getPersonnelbypersonnelIdPersonnel() {
        return personnelbypersonnelIdPersonnel;
    }

    public void setPersonnelbypersonnelIdPersonnel(Long personnelbypersonnelIdPersonnel) {
        this.personnelbypersonnelIdPersonnel = personnelbypersonnelIdPersonnel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteCours noteCours = (NoteCours) o;

        if (idNoteCours != noteCours.idNoteCours) return false;
        if (description != null ? !description.equals(noteCours.description) : noteCours.description != null)
            return false;
        if (personnel != null ? !personnel.equals(noteCours.personnel) : noteCours.personnel != null) return false;
        if (titreCours != null ? !titreCours.equals(noteCours.titreCours) : noteCours.titreCours != null) return false;
        if (personnelbypersonnelIdPersonnel != null ? !personnelbypersonnelIdPersonnel.equals(noteCours.personnelbypersonnelIdPersonnel) : noteCours.personnelbypersonnelIdPersonnel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idNoteCours ^ (idNoteCours >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (personnel != null ? personnel.hashCode() : 0);
        result = 31 * result + (titreCours != null ? titreCours.hashCode() : 0);
        result = 31 * result + (personnelbypersonnelIdPersonnel != null ? personnelbypersonnelIdPersonnel.hashCode() : 0);
        return result;
    }
}
