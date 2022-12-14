package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Salle;

public class SalleConverter implements Converter {

    public SalleConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        SalleManagedBean managedBean = (SalleManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "salle");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Salle) {
            Salle entity = (Salle) object;

            final String pk = String.valueOf(entity.getIdSalle());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Salle");
        }
    }
}
