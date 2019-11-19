package shop.ui;

import shop.main.Enumable;

import java.util.ArrayList;
import java.util.List;

class UIBuilder implements UIBuildable{
    final List _menu;
    public UIBuilder() {
        _menu = new ArrayList();
    }

    public void add(String prompt, Object action) {
        if (null == action)
            throw new IllegalArgumentException();
        _menu.add(new UIAbstract.Pair(prompt, action));
    }

    @Override
    public void addAll(Enumable[] enums) {

        for(int i = 0; i< enums.length; i++){

            _menu.add(new UIAbstract.Pair(enums[i].getPrompt(),enums[i].getAction()));
//            _menu.add(Enum.valueOf(enums[i].getDeclaringClass(),enums[i].name()));

        }

    }

    public UIForm toUIForm(String heading) {
        return new UIForm(heading, getArray(heading));
    }

    public UIMenu toUIMenu(String heading) {
        return new UIMenu(heading, getArray(heading));
    }

    UIAbstract.Pair[] getArray(String heading){
        if (null == heading)
            throw new IllegalArgumentException();
        if (_menu.size() < 1)
            throw new IllegalStateException();
        UIAbstract.Pair[] array = new UIAbstract.Pair[_menu.size()];
        for (int i = 0; i < _menu.size(); i++)
            array[i] = (UIAbstract.Pair) (_menu.get(i));

        return array;
    }




}
