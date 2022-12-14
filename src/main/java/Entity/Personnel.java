package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Personnel {
    private long idPersonnel;
    private String email;
    private String login;
    private String nom;
    private String password;
    private String prenom;
    private String roles;
    private Long tel;
    private String type;
    private Long idEcole;

    @Id
    @Column(name = "id_personnel")
    public long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(long idPersonnel) {
        this.idPersonnel = idPersonnel;
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
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "tel")
    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "id_ecole")
    public Long getIdEcole() {
        return idEcole;
    }

    public void setIdEcole(Long idEcole) {
        this.idEcole = idEcole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personnel personnel = (Personnel) o;

        if (idPersonnel != personnel.idPersonnel) return false;
        if (email != null ? !email.equals(personnel.email) : personnel.email != null) return false;
        if (login != null ? !login.equals(personnel.login) : personnel.login != null) return false;
        if (nom != null ? !nom.equals(personnel.nom) : personnel.nom != null) return false;
        if (password != null ? !password.equals(personnel.password) : personnel.password != null) return false;
        if (prenom != null ? !prenom.equals(personnel.prenom) : personnel.prenom != null) return false;
        if (roles != null ? !roles.equals(personnel.roles) : personnel.roles != null) return false;
        if (tel != null ? !tel.equals(personnel.tel) : personnel.tel != null) return false;
        if (type != null ? !type.equals(personnel.type) : personnel.type != null) return false;
        if (idEcole != null ? !idEcole.equals(personnel.idEcole) : personnel.idEcole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPersonnel ^ (idPersonnel >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (idEcole != null ? idEcole.hashCode() : 0);
        return result;
    }
}
