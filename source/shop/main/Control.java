package shop.main;

import shop.ui.UI;
import shop.data.Inventory;
import shop.ui.UIError;

class Control {
  private static State EXITED;
  private static State EXIT;
  private static State START;
  private State _state;

  private Inventory _inventory;
  private UI _ui;

  Control(Inventory inventory, UI ui) {
    _inventory = inventory;
    _ui = ui;

    START = new Startstate(this);
    EXIT = new Exitstate(this);
    _state = START;
  }
  
  void run() {
    try {
      while (_state != EXITED) {
        _ui.processMenu(_state.get_menus());
      }
    } catch (UIError e) {
      _ui.displayError("UI closed");
    }
  }

  void setState(State state){
    this._state = state;
  }

  State getStart(){
    return this.START;
  }

  State getExit(){
    return this.EXIT;
  }

  State getExited(){
    return this.EXITED;
  }

  UI getUi(){
    return this._ui;
  }

  Inventory getInventory(){
    return this._inventory;
  }

}
