package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Ecole;

public class EcoleConverter implements Converter {

    public EcoleConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        EcoleManagedBean managedBean = (EcoleManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "ecole");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Ecole) {
            Ecole entity = (Ecole) object;

            final String pk = String.valueOf(entity.getIdEcole());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Ecole");
        }
    }
}
