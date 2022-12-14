package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Deliberation;

public class DeliberationConverter implements Converter {

    public DeliberationConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        DeliberationManagedBean managedBean = (DeliberationManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "deliberation");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Deliberation) {
            Deliberation entity = (Deliberation) object;

            final String pk = String.valueOf(entity.getIdDeliberation());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Deliberation");
        }
    }
}
