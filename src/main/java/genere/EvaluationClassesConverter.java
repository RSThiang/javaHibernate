package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.EvaluationClasses;

public class EvaluationClassesConverter implements Converter {

    public EvaluationClassesConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        EvaluationClassesManagedBean managedBean = (EvaluationClassesManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "evaluationClasses");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof EvaluationClasses) {
            EvaluationClasses entity = (EvaluationClasses) object;

            final String pk = String.valueOf(entity.getId());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: EvaluationClasses");
        }
    }
}
