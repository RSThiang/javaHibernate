package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Login;

public class LoginConverter implements Converter {

    public LoginConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        LoginManagedBean managedBean = (LoginManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "login");

        final String id = string;

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Login) {
            Login entity = (Login) object;

            final String pk = String.valueOf(entity.getUsername());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Login");
        }
    }
}
