package peddi.adftutorial.demo.view;

import oracle.binding.BindingContainer;
import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.event.DisclosureEvent;

public class CriteriaTabHandle {
    public CriteriaTabHandle() {
    }

    public void Shipping(DisclosureEvent disclosureEvent) {
        boolean disclosedBoolean = disclosureEvent.isExpanded();
        if (disclosedBoolean){
            BindingContext bindingContext = BindingContext.getCurrent();
            BindingContainer bindings = bindingContext.getCurrent().getCurrentBindingsEntry();
            oracle.binding.OperationBinding operationBinding =  bindings.getOperationBinding("showEmpFromDeptShipping");
            operationBinding.execute();
        }
        DCBindingContainer bdContainer = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        Boolean startup = (Boolean)bdContainer.getVariableManager().getVariableValue("CallAtStart");
        if (startup.booleanValue()==true){
            bdContainer.getVariableManager().setVariableValue("CallAtStart.", false);
        }
        
        
    }

    public void IT(DisclosureEvent disclosureEvent) {
        boolean disclosedBoolean = disclosureEvent.isExpanded();
        if (disclosedBoolean){
            BindingContext bindingContext = BindingContext.getCurrent();
            BindingContainer bindings = bindingContext.getCurrentBindingsEntry();
            OperationBinding operationBinding =  (OperationBinding)bindings.getOperationBinding("showEmpFromDeptIT");
            operationBinding.execute();
        }
    }

    public void fg(DisclosureEvent disclosureEvent) {
        // Add event code here...
    }
}
