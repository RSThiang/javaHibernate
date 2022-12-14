package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Promotion;

public class PromotionConverter implements Converter {

    public PromotionConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        PromotionManagedBean managedBean = (PromotionManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "promotion");

        final long id = Long.parseLong(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Promotion) {
            Promotion entity = (Promotion) object;

            final String pk = String.valueOf(entity.getIdPromotion());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Promotion");
        }
    }
}
