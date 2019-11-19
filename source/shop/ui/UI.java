package shop.ui;

public interface UI {
  public void processMenu(UIFormable menu);
  public String[] processForm(UIFormable form);
  public void displayMessage(String message);
  public void displayError(String message);
}
