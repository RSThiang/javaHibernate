package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Evaluation;

public class EvaluationConverter implements Converter {

    public EvaluationConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        EvaluationManagedBean managedBean = (EvaluationManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "evaluation");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Evaluation) {
            Evaluation entity = (Evaluation) object;

            final String pk = String.valueOf(entity.getIdEvaluation());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Evaluation");
        }
    }
}
