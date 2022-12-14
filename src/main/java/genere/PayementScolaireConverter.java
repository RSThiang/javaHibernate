package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.PayementScolaire;

public class PayementScolaireConverter implements Converter {

    public PayementScolaireConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PayementScolaireManagedBean managedBean = (PayementScolaireManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "payementScolaire");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof PayementScolaire) {
            PayementScolaire entity = (PayementScolaire) object;

            final String pk = String.valueOf(entity.getIdPayement());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: PayementScolaire");
        }
    }
}
