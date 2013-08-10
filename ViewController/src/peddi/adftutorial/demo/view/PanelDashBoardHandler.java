package peddi.adftutorial.demo.view;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import oracle.adf.view.rich.component.rich.layout.RichPanelDashboard;

import org.apache.myfaces.trinidad.context.RequestContext;

public class PanelDashBoardHandler {
    public PanelDashBoardHandler() {
    }

    public void insertPanelBox(ActionEvent actionEvent) {
        // Add event code here...
        UIComponent eventComponent = actionEvent.getComponent();
        String panelBoxId = eventComponent.getAttributes().get("pb9").toString();
        //UIComponent panelBox = _dashboard.findComponent(panelBoxId);
        UIComponent panelBox = eventComponent.findComponent(panelBoxId);
        
        // Make this panelBox rendered:
        panelBox.setRendered(true);
        // Becaue the dashboard is already shown, perform an optimized
        // render so the whole dashboard does not have to be re-encoded:
        int insertIndex = 0;
        List<UIComponent> children = eventComponent.getChildren();
        for (UIComponent child : children)
        {
        if (child.equals(panelBox))
        {
        // Let the dashboard know that only the one child component should be
        // encoded during the render phase:
        ((RichPanelDashboard)eventComponent).prepareOptimizedEncodingOfInsertedChild(
        FacesContext.getCurrentInstance(),
        insertIndex);
        break;
        }
        if (child.isRendered())
        {
        // Count only rendered children because that is all that the
        // panelDashboard can see:
        insertIndex++;
        }
        }
        // Add the side bar as a partial target because we need to
        // redraw the state of the side bar item that corresponds to the inserted item:
        //RequestContext rc = RequestContext.getCurrentInstance();
        //rc.addPartialTarget(_sideBar);
    }
}
