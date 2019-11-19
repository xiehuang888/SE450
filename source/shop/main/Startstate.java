package shop.main;

class Startstate extends State{

    Startstate(Control control){
        super(control);
        new UIMenuActionEnum.prepare(control);
        m.addAll(UIMenuActionEnum.values());
        _menus = m.toUIMenu("Bob's Video");
    }

}
