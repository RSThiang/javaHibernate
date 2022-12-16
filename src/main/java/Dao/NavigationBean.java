package Dao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "NavigationBean")

@ViewScoped
public class NavigationBean implements Serializable {


    private static final long serialVersionUID = 1L;

    private String page ="pageinitial.xhtml";
    @PostConstruct
     public void Init(){
     }

    public String getPage() {
        return page;
    }

    public void setPage(String currentPage) {
        this.page=currentPage;
    }


}