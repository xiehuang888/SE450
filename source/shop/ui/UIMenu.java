package shop.ui;

/**
 * @see UIMenuBuilder
 */
final class UIMenu extends UIAbstract {

  UIMenu(String heading, Pair[] menu) {
      super(heading,menu);
  }

  public void runAction(int i) {
    ((UIMenuAction)_form[i].test).run();
  }
}
