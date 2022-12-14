package Entity;

import javax.persistence.*;

@Entity
public class Parents {
    private long idParents;
    private String attrAdresse;
    private String email;
    private String prenomMere;
    private String prenomPere;
    private String tel1;
    private String tel2;

    @Id
    @Column(name = "idparents")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdParents() {
        return idParents;
    }

    public void setIdParents(long idParents) {
        this.idParents = idParents;
    }

    @Basic
    @Column(name = "attradresse")
    public String getAttrAdresse() {
        return attrAdresse;
    }

    public void setAttrAdresse(String attrAdresse) {
        this.attrAdresse = attrAdresse;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "prenommere")
    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    @Basic
    @Column(name = "prenompere")
    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    @Basic
    @Column(name = "tel1")
    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    @Basic
    @Column(name = "tel2")
    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parents parents = (Parents) o;

        if (idParents != parents.idParents) return false;
        if (attrAdresse != null ? !attrAdresse.equals(parents.attrAdresse) : parents.attrAdresse != null) return false;
        if (email != null ? !email.equals(parents.email) : parents.email != null) return false;
        if (prenomMere != null ? !prenomMere.equals(parents.prenomMere) : parents.prenomMere != null) return false;
        if (prenomPere != null ? !prenomPere.equals(parents.prenomPere) : parents.prenomPere != null) return false;
        if (tel1 != null ? !tel1.equals(parents.tel1) : parents.tel1 != null) return false;
        if (tel2 != null ? !tel2.equals(parents.tel2) : parents.tel2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idParents ^ (idParents >>> 32));
        result = 31 * result + (attrAdresse != null ? attrAdresse.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (prenomMere != null ? prenomMere.hashCode() : 0);
        result = 31 * result + (prenomPere != null ? prenomPere.hashCode() : 0);
        result = 31 * result + (tel1 != null ? tel1.hashCode() : 0);
        result = 31 * result + (tel2 != null ? tel2.hashCode() : 0);
        return result;
    }
}
