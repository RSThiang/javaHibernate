package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Cantine;

public class CantineConverter implements Converter {

    public CantineConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        CantineManagedBean managedBean = (CantineManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "cantine");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Cantine) {
            Cantine entity = (Cantine) object;

            final String pk = String.valueOf(entity.getIdCantine());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Cantine");
        }
    }
}
