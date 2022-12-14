package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Personnel;

public class PersonnelConverter implements Converter {

    public PersonnelConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PersonnelManagedBean managedBean = (PersonnelManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "personnel");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Personnel) {
            Personnel entity = (Personnel) object;

            final String pk = String.valueOf(entity.getIdPersonnel());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Personnel");
        }
    }
}
