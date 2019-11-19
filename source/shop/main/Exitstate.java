package shop.main;


class Exitstate extends State{

    Exitstate(Control control){
        super(control);
        new ExitMenuEnum.prepare(control);
        m.addAll(ExitMenuEnum.values());
        _menus = m.toUIMenu("Are you sure you want to exit?");
    }

}
