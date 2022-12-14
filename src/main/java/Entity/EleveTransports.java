package Entity;

import javax.persistence.*;

@Entity
@Table(name = "eleve_transports", schema = "public", catalog = "Gestionscolaire")
public class EleveTransports {
    private long id;
    private Long elevebyideleveIdEleve;
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
    @Column(name = "elevebyideleve_id_eleve")
    public Long getElevebyideleveIdEleve() {
        return elevebyideleveIdEleve;
    }

    public void setElevebyideleveIdEleve(Long elevebyideleveIdEleve) {
        this.elevebyideleveIdEleve = elevebyideleveIdEleve;
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

        EleveTransports that = (EleveTransports) o;

        if (id != that.id) return false;
        if (elevebyideleveIdEleve != null ? !elevebyideleveIdEleve.equals(that.elevebyideleveIdEleve) : that.elevebyideleveIdEleve != null)
            return false;
        if (transportbyidtransportIdTransport != null ? !transportbyidtransportIdTransport.equals(that.transportbyidtransportIdTransport) : that.transportbyidtransportIdTransport != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (elevebyideleveIdEleve != null ? elevebyideleveIdEleve.hashCode() : 0);
        result = 31 * result + (transportbyidtransportIdTransport != null ? transportbyidtransportIdTransport.hashCode() : 0);
        return result;
    }
}
