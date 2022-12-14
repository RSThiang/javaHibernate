package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Transport;

public class TransportConverter implements Converter {

    public TransportConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        TransportManagedBean managedBean = (TransportManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "transport");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Transport) {
            Transport entity = (Transport) object;

            final String pk = String.valueOf(entity.getIdTransport());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Transport");
        }
    }
}
