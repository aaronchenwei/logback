package ch.qos.logback.core.joran.action;

import org.xml.sax.Attributes;

import ch.qos.logback.core.joran.model.Model;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.ElementPath;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.OptionHelper;

public class ModelImplicitAction extends ImplicitAction {
    Model model = new Model();
    
    @Override
    public boolean isApplicable(ElementPath currentElementPath, Attributes attributes, InterpretationContext ec) {
        Object o = ec.peekObject();
        if (o instanceof Model) {
            return true;
        } else
            return false;
    }

    @Override
    public void begin(InterpretationContext interpretationContext, String name, Attributes attributes) throws ActionException {
        String className = attributes.getValue(CLASS_ATTRIBUTE);
        if (!OptionHelper.isEmpty(className)) {
            model.setClassName(className);
        }

        interpretationContext.pushObject(model);
    }

    @Override
    public void body(InterpretationContext ec, String body) {
        model.addText(body);
    }

    @Override
    public void end(InterpretationContext ic, String name) throws ActionException {
        if(!OptionHelper.isEmpty(model.getClassName())) {
            
        }
    }

}
