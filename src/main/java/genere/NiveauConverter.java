package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Niveau;

public class NiveauConverter implements Converter {

    public NiveauConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        NiveauManagedBean managedBean = (NiveauManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "niveau");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Niveau) {
            Niveau entity = (Niveau) object;

            final String pk = String.valueOf(entity.getIdNiveau());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Niveau");
        }
    }
}
