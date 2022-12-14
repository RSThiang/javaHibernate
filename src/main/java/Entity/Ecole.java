package Entity;

import javax.persistence.*;

@Entity
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idecole")
    private int idEcole;
    private String addresseecole;
    private String nomecole;


    public int getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(int idEcole) {
        this.idEcole = idEcole;
    }

    public String getAddresseecole() {
        return addresseecole;
    }

    public void setAddresseecole(String addresseecole) {
        this.addresseecole = addresseecole;
    }


    public String getNomecole() {
        return nomecole;
    }

    public void setNomecole(String nomecole) {
        this.nomecole = nomecole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ecole ecole = (Ecole) o;

        if (idEcole != ecole.idEcole) return false;
        if (addresseecole != null ? !addresseecole.equals(ecole.addresseecole) : ecole.addresseecole != null)
            return false;
        if (nomecole != null ? !nomecole.equals(ecole.nomecole) : ecole.nomecole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEcole;
        result = 31 * result + (addresseecole != null ? addresseecole.hashCode() : 0);
        result = 31 * result + (nomecole != null ? nomecole.hashCode() : 0);
        return result;
    }
}
