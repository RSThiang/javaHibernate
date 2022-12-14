package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.CycleScolaire;

public class CycleScolaireConverter implements Converter {

    public CycleScolaireConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        CycleScolaireManagedBean managedBean = (CycleScolaireManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "cycleScolaire");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof CycleScolaire) {
            CycleScolaire entity = (CycleScolaire) object;

            final String pk = String.valueOf(entity.getIdCycle());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: CycleScolaire");
        }
    }
}
