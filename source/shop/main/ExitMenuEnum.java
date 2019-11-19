package shop.main;

import shop.ui.UIMenuAction;

public enum ExitMenuEnum implements Enumable{
    DEFAULT("Default", new UIMenuAction() { public void run() {} }),
    YES("Yes",
                new UIMenuAction() {
        public void run() {
            _control.setState(_control.getExited());
        }
    }),
    NO("No",
                new UIMenuAction() {
        public void run() {
            _control.setState(_control.getStart());
        }
    });

    String prompt;
    UIMenuAction uiMenuAction;
    static Control _control;

    @Override
    public String getPrompt() {
        return prompt;
    }

    @Override
    public Object getAction() {
        return uiMenuAction;
    }

    static class prepare{
        prepare(Control control){
            _control = control;

        }
    }
    ExitMenuEnum(String prompt, UIMenuAction uiMenuAction) {
        this.prompt = prompt;
        this.uiMenuAction = uiMenuAction;

    }
}
