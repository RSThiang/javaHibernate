package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.PersonnelEcoles;

public class PersonnelEcolesConverter implements Converter {

    public PersonnelEcolesConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PersonnelEcolesManagedBean managedBean = (PersonnelEcolesManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "personnelEcoles");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof PersonnelEcoles) {
            PersonnelEcoles entity = (PersonnelEcoles) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: PersonnelEcoles");
        }
    }
}
