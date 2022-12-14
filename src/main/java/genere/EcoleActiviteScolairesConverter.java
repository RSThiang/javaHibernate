package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.EcoleActiviteScolaires;

public class EcoleActiviteScolairesConverter implements Converter {

    public EcoleActiviteScolairesConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        EcoleActiviteScolairesManagedBean managedBean = (EcoleActiviteScolairesManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "ecoleActiviteScolaires");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof EcoleActiviteScolaires) {
            EcoleActiviteScolaires entity = (EcoleActiviteScolaires) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: EcoleActiviteScolaires");
        }
    }
}
