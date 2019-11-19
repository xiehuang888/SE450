package shop.main;

import shop.ui.UIFormTest;

enum TestEnum {
    NUMBER(new UIFormTest(){
        public boolean run(String input) {
            try {
                Integer.parseInt(input);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }),
    YEAR( new UIFormTest() {
        public boolean run(String input) {
            try {
                int i = Integer.parseInt(input);
                return i > 1800 && i < 5000;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    }),
    STRING(new UIFormTest(){
        public boolean run(String input) {
            if(input == null)
                return false;
            return ! "".equals(input.trim());
        }
    });

    private final UIFormTest uiFormTest;

    TestEnum(UIFormTest uiFormTest) {
        this.uiFormTest = uiFormTest;
    }

    public UIFormTest getUiFormTest(){
        return this.uiFormTest;
    }

}

