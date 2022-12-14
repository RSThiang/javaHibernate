package Dao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped

public class NavigationBean implements Serializable {
    private static final long serialVersionUID = 1L;
     private String page="template.xhtml";
    @PostConstruct
    public void init() {}
public NavigationBean(String page){
        this.page = page;
 }

    public String getPage() {
        return page;
    }


    public void setPage(String currentPage) {
        this.page=currentPage;
    }
}