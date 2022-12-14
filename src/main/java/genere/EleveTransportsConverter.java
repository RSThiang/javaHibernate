package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.EleveTransports;

public class EleveTransportsConverter implements Converter {

    public EleveTransportsConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        EleveTransportsManagedBean managedBean = (EleveTransportsManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "eleveTransports");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof EleveTransports) {
            EleveTransports entity = (EleveTransports) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: EleveTransports");
        }
    }
}
