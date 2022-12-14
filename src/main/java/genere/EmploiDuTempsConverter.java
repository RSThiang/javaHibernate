package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.EmploiDuTemps;

public class EmploiDuTempsConverter implements Converter {

    public EmploiDuTempsConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        EmploiDuTempsManagedBean managedBean = (EmploiDuTempsManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "emploiDuTemps");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof EmploiDuTemps) {
            EmploiDuTemps entity = (EmploiDuTemps) object;

            final String pk = String.valueOf(entity.getIdEmploiDuTemps());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: EmploiDuTemps");
        }
    }
}
