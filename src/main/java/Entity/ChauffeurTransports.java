package Entity;

import javax.persistence.*;

@Entity
@Table(name = "chauffeur_transports", schema = "public", catalog = "Gestionscolaire")
public class ChauffeurTransports {
    private long id;
    private Long chauffeurbyidchauffeurIdChauffeur;
    private Long transportbyidtransportIdTransport;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chauffeurbyidchauffeur_id_chauffeur")
    public Long getChauffeurbyidchauffeurIdChauffeur() {
        return chauffeurbyidchauffeurIdChauffeur;
    }

    public void setChauffeurbyidchauffeurIdChauffeur(Long chauffeurbyidchauffeurIdChauffeur) {
        this.chauffeurbyidchauffeurIdChauffeur = chauffeurbyidchauffeurIdChauffeur;
    }

    @Basic
    @Column(name = "transportbyidtransport_id_transport")
    public Long getTransportbyidtransportIdTransport() {
        return transportbyidtransportIdTransport;
    }

    public void setTransportbyidtransportIdTransport(Long transportbyidtransportIdTransport) {
        this.transportbyidtransportIdTransport = transportbyidtransportIdTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChauffeurTransports that = (ChauffeurTransports) o;

        if (id != that.id) return false;
        if (chauffeurbyidchauffeurIdChauffeur != null ? !chauffeurbyidchauffeurIdChauffeur.equals(that.chauffeurbyidchauffeurIdChauffeur) : that.chauffeurbyidchauffeurIdChauffeur != null)
            return false;
        if (transportbyidtransportIdTransport != null ? !transportbyidtransportIdTransport.equals(that.transportbyidtransportIdTransport) : that.transportbyidtransportIdTransport != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (chauffeurbyidchauffeurIdChauffeur != null ? chauffeurbyidchauffeurIdChauffeur.hashCode() : 0);
        result = 31 * result + (transportbyidtransportIdTransport != null ? transportbyidtransportIdTransport.hashCode() : 0);
        return result;
    }
}
