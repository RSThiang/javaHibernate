package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.PersonnelMatiere;

public class PersonnelMatiereConverter implements Converter {

    public PersonnelMatiereConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PersonnelMatiereManagedBean managedBean = (PersonnelMatiereManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "personnelMatiere");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof PersonnelMatiere) {
            PersonnelMatiere entity = (PersonnelMatiere) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: PersonnelMatiere");
        }
    }
}
