package shop.ui;

/**
 * @see UIFormBuilder
 */
final class UIForm extends UIAbstract {

  UIForm(String heading, Pair[] menu) {
      super(heading,menu);
  }

  public boolean checkInput(int i, String input) {
    if (null == _form[i])
      return true;
    return ((UIFormTest)_form[i].test).run(input);
  }
}
