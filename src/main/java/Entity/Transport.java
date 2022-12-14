package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Transport {
    private long idTransport;
    private String description;
    private Timestamp heureTransport;
    private String zoneTransport;

    @Id
    @Column(name = "id_transport")
    public long getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(long idTransport) {
        this.idTransport = idTransport;
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
    @Column(name = "heure_transport")
    public Timestamp getHeureTransport() {
        return heureTransport;
    }

    public void setHeureTransport(Timestamp heureTransport) {
        this.heureTransport = heureTransport;
    }

    @Basic
    @Column(name = "zone_transport")
    public String getZoneTransport() {
        return zoneTransport;
    }

    public void setZoneTransport(String zoneTransport) {
        this.zoneTransport = zoneTransport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transport transport = (Transport) o;

        if (idTransport != transport.idTransport) return false;
        if (description != null ? !description.equals(transport.description) : transport.description != null)
            return false;
        if (heureTransport != null ? !heureTransport.equals(transport.heureTransport) : transport.heureTransport != null)
            return false;
        if (zoneTransport != null ? !zoneTransport.equals(transport.zoneTransport) : transport.zoneTransport != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idTransport ^ (idTransport >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (heureTransport != null ? heureTransport.hashCode() : 0);
        result = 31 * result + (zoneTransport != null ? zoneTransport.hashCode() : 0);
        return result;
    }
}
