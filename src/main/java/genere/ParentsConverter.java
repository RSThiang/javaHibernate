package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Parents;

public class ParentsConverter implements Converter {

    public ParentsConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        ParentsManagedBean managedBean = (ParentsManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "parents");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Parents) {
            Parents entity = (Parents) object;

            final String pk = String.valueOf(entity.getIdParents());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Parents");
        }
    }
}
