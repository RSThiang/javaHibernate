package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Chauffeur;

public class ChauffeurConverter implements Converter {

    public ChauffeurConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        ChauffeurManagedBean managedBean = (ChauffeurManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "chauffeur");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Chauffeur) {
            Chauffeur entity = (Chauffeur) object;

            final String pk = String.valueOf(entity.getIdChauffeur());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Chauffeur");
        }
    }
}
