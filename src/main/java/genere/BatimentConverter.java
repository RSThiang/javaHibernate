package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Batiment;

public class BatimentConverter implements Converter {

    public BatimentConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        BatimentManagedBean managedBean = (BatimentManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "batiment");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Batiment) {
            Batiment entity = (Batiment) object;

            final String pk = String.valueOf(entity.getIdBatiment());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Batiment");
        }
    }
}
