package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Inscription;

public class InscriptionConverter implements Converter {

    public InscriptionConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        InscriptionManagedBean managedBean = (InscriptionManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "inscription");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Inscription) {
            Inscription entity = (Inscription) object;

            final String pk = String.valueOf(entity.getIdInscription());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Inscription");
        }
    }
}
