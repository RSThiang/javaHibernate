package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Classe;

public class ClasseConverter implements Converter {

    public ClasseConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        ClasseManagedBean managedBean = (ClasseManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "classe");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Classe) {
            Classe entity = (Classe) object;

            final String pk = String.valueOf(entity.getIdClasse());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Classe");
        }
    }
}
