package shop.main;

import shop.ui.UIBuildable;
import shop.ui.UIBuildfactory;
import shop.ui.UIFormable;

abstract class State {
    Control control;
    protected UIBuildable m;
    UIFormable _menus;

    State(Control control){
        this.control = control;
        m = UIBuildfactory.getUIBuilder();
    }
    public UIFormable get_menus() {
        return _menus;
    }

}
