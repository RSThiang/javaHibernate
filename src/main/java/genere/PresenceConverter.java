package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Presence;

public class PresenceConverter implements Converter {

    public PresenceConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PresenceManagedBean managedBean = (PresenceManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "presence");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Presence) {
            Presence entity = (Presence) object;

            final String pk = String.valueOf(entity.getIdPresence());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Presence");
        }
    }
}
