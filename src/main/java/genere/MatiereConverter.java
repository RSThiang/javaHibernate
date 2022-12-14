package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Matiere;

public class MatiereConverter implements Converter {

    public MatiereConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        MatiereManagedBean managedBean = (MatiereManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "matiere");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Matiere) {
            Matiere entity = (Matiere) object;

            final String pk = String.valueOf(entity.getIdMatiere());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Matiere");
        }
    }
}
