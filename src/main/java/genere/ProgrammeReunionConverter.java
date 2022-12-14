package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.ProgrammeReunion;

public class ProgrammeReunionConverter implements Converter {

    public ProgrammeReunionConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        ProgrammeReunionManagedBean managedBean = (ProgrammeReunionManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "programmeReunion");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof ProgrammeReunion) {
            ProgrammeReunion entity = (ProgrammeReunion) object;

            final String pk = String.valueOf(entity.getIdProgramme());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: ProgrammeReunion");
        }
    }
}
