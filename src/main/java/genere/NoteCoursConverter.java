package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.NoteCours;

public class NoteCoursConverter implements Converter {

    public NoteCoursConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        NoteCoursManagedBean managedBean = (NoteCoursManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "noteCours");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof NoteCours) {
            NoteCours entity = (NoteCours) object;

            final String pk = String.valueOf(entity.getIdNoteCours());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: NoteCours");
        }
    }
}
