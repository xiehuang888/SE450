package shop.ui;

import shop.main.Enumable;

public interface UIBuildable {
    void add(String prompt, Object action);
    void addAll(Enumable[] enums);

    public UIForm toUIForm(String heading);
    public UIMenu toUIMenu(String heading);

}
