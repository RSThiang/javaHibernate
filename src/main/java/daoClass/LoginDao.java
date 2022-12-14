package daoClass;


import Dao.LogiImplement;
import Entity.Login;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

@Named
@RequestScoped
public class LoginDao {

    private String username;
    private String password;
    private Login login;
    private List<Entity.Login> users;
    private static String message  ;
    private Login l;
    private String m ;
    private EntityManager emf = Persistence.createEntityManagerFactory("persistenceUniName").createEntityManager();


    @PostConstruct
    public void init(){
        login = new Login();

    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Entity.Login> getUsers() {
        List<Login> users = emf.createQuery("Select t from  Login  t",Login.class).getResultList();

        return users;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public static String getMessage() {
        return message;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public static void setMessage(String message) {
        LoginDao.message = message;
    }

    public void setUsers(List<Entity.Login> users) {
        this.users = users;
    }
    public String vali() {
        // String m = new LogiImplement().validation(users);
       // List<Login> login = emf.createQuery("Select t from  Login  t", Login.class).getResultList();

        for (Login l : new LogiImplement().listeusers())
            if (l.getUsername().equals(username) && l.getPassword().equals(password)) {
                m = "pageinitiale?faces-redirect=true";
            }
        else {
                m = "template?faces-redirect=true";
            }
        return m;

    }
}
