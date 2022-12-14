package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Presence {
    private long idPresence;
    private String situationPresence;
    private Long idEleve;
    private Long idEmploiDuTemps;

    @Id
    @Column(name = "id_presence")
    public long getIdPresence() {
        return idPresence;
    }

    public void setIdPresence(long idPresence) {
        this.idPresence = idPresence;
    }

    @Basic
    @Column(name = "situation_presence")
    public String getSituationPresence() {
        return situationPresence;
    }

    public void setSituationPresence(String situationPresence) {
        this.situationPresence = situationPresence;
    }

    @Basic
    @Column(name = "id_eleve")
    public Long getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(Long idEleve) {
        this.idEleve = idEleve;
    }

    @Basic
    @Column(name = "id_emploi_du_temps")
    public Long getIdEmploiDuTemps() {
        return idEmploiDuTemps;
    }

    public void setIdEmploiDuTemps(Long idEmploiDuTemps) {
        this.idEmploiDuTemps = idEmploiDuTemps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Presence presence = (Presence) o;

        if (idPresence != presence.idPresence) return false;
        if (situationPresence != null ? !situationPresence.equals(presence.situationPresence) : presence.situationPresence != null)
            return false;
        if (idEleve != null ? !idEleve.equals(presence.idEleve) : presence.idEleve != null) return false;
        if (idEmploiDuTemps != null ? !idEmploiDuTemps.equals(presence.idEmploiDuTemps) : presence.idEmploiDuTemps != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPresence ^ (idPresence >>> 32));
        result = 31 * result + (situationPresence != null ? situationPresence.hashCode() : 0);
        result = 31 * result + (idEleve != null ? idEleve.hashCode() : 0);
        result = 31 * result + (idEmploiDuTemps != null ? idEmploiDuTemps.hashCode() : 0);
        return result;
    }
}
