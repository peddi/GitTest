package peddi.adftutorial.demo.view;

import java.util.HashMap;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

//import oracle.adf.model.BindingContainer;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.input.RichSelectManyCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectManyChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectManyListbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.adf.view.rich.component.rich.input.RichSelectOneListbox;

import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;

import oracle.binding.BindingContainer;
import java.util.HashMap;

import java.util.List;

import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;

public class PopulatePopup {
    private RichSelectBooleanCheckbox selectBooleanCheckBox;
    private RichSelectOneChoice selectOneChoice;
    private RichSelectManyChoice selectManyChoice;
    private RichSelectManyCheckbox selectManyCheckBox;
    private RichSelectOneListbox selectOneListBox;
    private RichSelectManyListbox selectManyListBox;
    private RichSelectOneRadio selectOneRadio;
    private RichSelectBooleanRadio selectBooleanRadio;

    public PopulatePopup() {
    }

    public void populatePopupVO(ActionEvent actionEvent) {
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        oracle.binding.OperationBinding operationBinding = bindingContainer.getOperationBinding("populateCheckNListVO1");
        
        HashMap selectedValues = new HashMap();
        
        selectedValues.put("SelectOneChoice", "SelectOneChoice");
        selectedValues.put("SelectManyChoice", "SelectManyChoice");
        
        selectedValues.put("SelectManyChkBox", "SelectManyChkBox");
        selectedValues.put("SelectOneListBox", "SelectOneListBox");
        selectedValues.put("SelectManyListBox", "SelectManyListBox");
        selectedValues.put("SelectOneRadio", "SelectOneRadio");
        selectedValues.put("SelectBoolRadio", "SelectBoolRadio");
        
        if (getSelectOneChoice().getValue()!= null){
            List childList = getSelectOneChoice().getChildren();
            //getSelectOneChoice().g
            String selectedOneChoiceValue = new String();
            for (int i = 0; i < childList.size(); i++){
                if (childList.get(i) instanceof RichSelectItem){
                    RichSelectItem selectedItem = (RichSelectItem)childList.get(i);
                    selectedOneChoiceValue = selectedOneChoiceValue.concat((String)selectedItem.getValue());
                }
            }
            selectedValues.put("SelectOneChoice", selectedOneChoiceValue);
        }
        if (getSelectManyChoice().getValue()!= null){
            selectedValues.put("SelectManyChoice", this.getSelectManyChoice().getValue().toString());
        }
        Object selectBooleanChkBox = getSelectBooleanCheckBox().getValue();
        if (selectBooleanChkBox!= null){
            boolean selectBooleanChkBox1 = (Boolean)selectBooleanChkBox;
            if (selectBooleanChkBox1 == true){
                System.out.println("SelectBoolChkBox => true");
                selectedValues.put("SelectBoolChkBox", "true");
            }
            else{
                System.out.println("SelectBoolChkBox => false");
                selectedValues.put("SelectBoolChkBox", "false");
            }
        }
        
        if (this.getSelectManyCheckBox()!= null){
            selectedValues.put("SelectManyChkBox", getSelectManyCheckBox().getValue());
        }
        
        if (this.getSelectOneListBox()!=null){
            selectedValues.put("SelectOneListBox", getSelectOneListBox().getValue());
        }
        
        if (this.getSelectManyListBox()!=null){
            selectedValues.put("SelectManyListBox", getSelectManyListBox().getValue());
        }
        
        if (this.getSelectOneRadio()!=null){
            selectedValues.put("SelectOneRadio", getSelectOneRadio().getValue());
        }
        
        if(this.getSelectBooleanRadio()!=null){
            selectedValues.put("SelectBoolRadio", this.getSelectBooleanRadio().getValue());
        }
        
        
        DCBindingContainer bdContainer = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        bdContainer.getVariableManager().setVariableValue("selectedValuesVar", selectedValues);
                
        operationBinding.execute();
        
    }

    public void setSelectBooleanCheckBox(RichSelectBooleanCheckbox selectBooleanCheckBox) {
        this.selectBooleanCheckBox = selectBooleanCheckBox;
    }

    public RichSelectBooleanCheckbox getSelectBooleanCheckBox() {
        return selectBooleanCheckBox;
    }

    public void setSelectOneChoice(RichSelectOneChoice selectOneChoice) {
        this.selectOneChoice = selectOneChoice;
    }

    public RichSelectOneChoice getSelectOneChoice() {
        return selectOneChoice;
    }

    public void setSelectManyChoice(RichSelectManyChoice selectManyChoice) {
        this.selectManyChoice = selectManyChoice;
    }

    public RichSelectManyChoice getSelectManyChoice() {
        return selectManyChoice;
    }

    public void setSelectManyCheckBox(RichSelectManyCheckbox selectManyCheckBox) {
        this.selectManyCheckBox = selectManyCheckBox;
    }

    public RichSelectManyCheckbox getSelectManyCheckBox() {
        return selectManyCheckBox;
    }

    public void setSelectOneListBox(RichSelectOneListbox selectOneListBox) {
        this.selectOneListBox = selectOneListBox;
    }

    public RichSelectOneListbox getSelectOneListBox() {
        return selectOneListBox;
    }

    public void setSelectManyListBox(RichSelectManyListbox selectManyListBox) {
        this.selectManyListBox = selectManyListBox;
    }

    public RichSelectManyListbox getSelectManyListBox() {
        return selectManyListBox;
    }

    public void setSelectOneRadio(RichSelectOneRadio selectOneRadio) {
        this.selectOneRadio = selectOneRadio;
    }

    public RichSelectOneRadio getSelectOneRadio() {
        return selectOneRadio;
    }

    public void setSelectBooleanRadio(RichSelectBooleanRadio selectBooleanRadio) {
        this.selectBooleanRadio = selectBooleanRadio;
    }

    public RichSelectBooleanRadio getSelectBooleanRadio() {
        return selectBooleanRadio;
    }
}
