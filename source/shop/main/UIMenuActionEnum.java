package shop.main;

import shop.command.Command;
import shop.data.Data;
import shop.data.Inventory;
import shop.data.Record;
import shop.data.Video;
import shop.ui.*;

import java.util.ArrayList;

enum UIMenuActionEnum implements Enumable{

    DEFAULT
    ("Default",new UIMenuAction() {
        public void run() {
            _ui.displayError("doh!");
        }
    }),
    ADDREMOVE(
            "Add/Remove copies of a video", new UIMenuAction() {
        public void run() {
            String[] result1 = _ui.processForm(_getVideoForm);
            Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);

            UIBuildable f = UIBuildfactory.getUIBuilder();
            f.add("Number of copies to add/remove", TestEnum.NUMBER.getUiFormTest());
            String[] result2 = _ui.processForm(f.toUIForm(""));

            Command c = Data.newAddCmd(_inventory, v, Integer.parseInt(result2[0]));
            if (! c.run()) {
                _ui.displayError("Command failed");
            }
        }
    }),
    CHECKIN(
            "Check in a video", new UIMenuAction() {
        public void run() {
            // TODO
            String[] result1 = _ui.processForm(_getVideoForm);
            Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);
            Command c = Data.newInCmd(_inventory,v);
            if(! c.run()){
                _ui.displayError("Command failed");
            }
        }
    }),
    CHECKOUT(
            "Check out a video", new UIMenuAction() {
        public void run() {
            // TODO
            String[] result1 = _ui.processForm(_getVideoForm);
            Video v = Data.newVideo(result1[0], Integer.parseInt(result1[1]), result1[2]);

            Command c = Data.newOutCmd(_inventory,v);
            if(! c.run()){
                _ui.displayError("Command failed");
            }
        }
    }),
    PRINT(
            "Print the inventory", new UIMenuAction() {
        public void run() {
            _ui.displayMessage(_inventory.toString());
        }
    }),
    CLEAR(
            "Clear the inventory", new UIMenuAction() {
        public void run() {
            if (!Data.newClearCmd(_inventory).run()) {
                _ui.displayError("Command failed");
            }
        }
    }),
    UNDO(
            "Undo", new UIMenuAction() {
        public void run() {
            if (!Data.newUndoCmd(_inventory).run()) {
                _ui.displayError("Command failed");
            }
        }
    }),
    REDO(
            "Redo", new UIMenuAction() {
        public void run() {
            if (!Data.newRedoCmd(_inventory).run()) {
                _ui.displayError("Command failed");
            }
        }
    }),
    TOPTEN(
            "Print top ten all time rentals in order", new UIMenuAction() {
        public void run() {
            // TODO
            ArrayList<Record> topten = new ArrayList<>();
            for(Record v: _inventory){
                if(topten.size() < 10){
                    topten.add(v);
                    for (int i = 0; i < topten.size(); i++)
                    {
                        for (int j = 0; j < topten.size()-1 -i; j ++){
                            if(topten.get(j+1).numRentals() > topten.get(j).numRentals()){
                                Record temp = topten.get(j+1);
                                topten.set(j+1,topten.get(j));
                                topten.set(j,temp);
                            }
                        }
                    }
                    continue;
                }

                if(v.numRentals() > topten.get(9).numRentals()){
                    topten.set(topten.size()-1,v);
                }
                for (int i = 0; i < topten.size(); i++)
                {
                    for (int j = 0; j < topten.size()-1 -i; j ++){
                        if(topten.get(j+1).numRentals() > topten.get(j).numRentals()){
                            Record temp = topten.get(j+1);
                            topten.set(j+1,topten.get(j));
                            topten.set(j,temp);
                        }
                    }
                }
            }
            String toReturn = "";
            for(int i = 0; i< topten.size(); i++){
                toReturn += i+1+"th: "+ topten.get(i).toString()+"\n";
            }
            _ui.displayMessage(toReturn);

        }
    }),
    EXIT(
            "Exit", new UIMenuAction() {
        public void run() {
            _control.setState(_control.getExit());
        }
    }),
    INITIALIZE(
            "Initialize with bogus contents", new UIMenuAction() {
        public void run() {
            Data.newAddCmd(_inventory, Data.newVideo("a", 2000, "m"), 1).run();
            Data.newAddCmd(_inventory, Data.newVideo("b", 2000, "m"), 2).run();
            Data.newAddCmd(_inventory, Data.newVideo("c", 2000, "m"), 3).run();
            Data.newAddCmd(_inventory, Data.newVideo("d", 2000, "m"), 4).run();
            Data.newAddCmd(_inventory, Data.newVideo("e", 2000, "m"), 5).run();
            Data.newAddCmd(_inventory, Data.newVideo("f", 2000, "m"), 6).run();
            Data.newAddCmd(_inventory, Data.newVideo("g", 2000, "m"), 7).run();
            Data.newAddCmd(_inventory, Data.newVideo("h", 2000, "m"), 8).run();
            Data.newAddCmd(_inventory, Data.newVideo("i", 2000, "m"), 9).run();
            Data.newAddCmd(_inventory, Data.newVideo("j", 2000, "m"), 10).run();
            Data.newAddCmd(_inventory, Data.newVideo("k", 2000, "m"), 11).run();
            Data.newAddCmd(_inventory, Data.newVideo("l", 2000, "m"), 12).run();
            Data.newAddCmd(_inventory, Data.newVideo("m", 2000, "m"), 13).run();
            Data.newAddCmd(_inventory, Data.newVideo("n", 2000, "m"), 14).run();
            Data.newAddCmd(_inventory, Data.newVideo("o", 2000, "m"), 15).run();
            Data.newAddCmd(_inventory, Data.newVideo("p", 2000, "m"), 16).run();
            Data.newAddCmd(_inventory, Data.newVideo("q", 2000, "m"), 17).run();
            Data.newAddCmd(_inventory, Data.newVideo("r", 2000, "m"), 18).run();
            Data.newAddCmd(_inventory, Data.newVideo("s", 2000, "m"), 19).run();
            Data.newAddCmd(_inventory, Data.newVideo("t", 2000, "m"), 20).run();
            Data.newAddCmd(_inventory, Data.newVideo("u", 2000, "m"), 21).run();
            Data.newAddCmd(_inventory, Data.newVideo("v", 2000, "m"), 22).run();
            Data.newAddCmd(_inventory, Data.newVideo("w", 2000, "m"), 23).run();
            Data.newAddCmd(_inventory, Data.newVideo("x", 2000, "m"), 24).run();
            Data.newAddCmd(_inventory, Data.newVideo("y", 2000, "m"), 25).run();
            Data.newAddCmd(_inventory, Data.newVideo("z", 2000, "m"), 26).run();
        }
    });
    private static Inventory _inventory;
    private static UIFormable _getVideoForm;
    private static UI _ui;
    private static Control _control;
    private UIMenuAction uiMenuAction;
    private String prompt;

    static class prepare{
        prepare(Control control){
            _control = control;
            _ui = control.getUi();
            _inventory = control.getInventory();


            UIBuildable f = UIBuildfactory.getUIBuilder();
            f.add("Title", TestEnum.STRING.getUiFormTest());
            f.add("Year", TestEnum.YEAR.getUiFormTest());
            f.add("Director", TestEnum.STRING.getUiFormTest());
            _getVideoForm = f.toUIForm("Enter Video");
        }
    }



    UIMenuActionEnum(String aDefault, UIMenuAction uiMenuAction) {
        this.uiMenuAction = uiMenuAction;
        this.prompt = aDefault;
    }

    public String getPrompt() {
        return prompt;
    }

    public Object getAction(){
        return this.uiMenuAction;
    }

    public UIMenuAction getUiMenuAction(){
        return this.uiMenuAction;
    }
}
