package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Eleve;

public class EleveConverter implements Converter {

    public EleveConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        EleveManagedBean managedBean = (EleveManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "eleve");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Eleve) {
            Eleve entity = (Eleve) object;

            final String pk = String.valueOf(entity.getIdEleve());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Eleve");
        }
    }
}
