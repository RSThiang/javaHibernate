package genere;

import javax.faces.convert.Converter;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;

import Entity.Serie;

public class SerieConverter implements Converter {

    public SerieConverter() {
    }

    public Object getAsObject(FacesContext facesContext, UIComponent uIComponent, String string) {
        if (string == null || string.trim().length() == 0) {
            return null;
        }

        SerieManagedBean managedBean = (SerieManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "serie");

        final int id = Integer.parseInt(string);

        return managedBean.findEntity(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if (object == null) return null;

        if (object instanceof Serie) {
            Serie entity = (Serie) object;

            final String pk = String.valueOf(entity.getIdSerie());

            return pk;
        } else {
            throw new IllegalArgumentException("Incorrect object type: " + object.getClass().getName() + "; must be: Serie");
        }
    }
}
