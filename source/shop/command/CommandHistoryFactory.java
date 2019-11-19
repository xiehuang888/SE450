package shop.command;

public class CommandHistoryFactory {
  private CommandHistoryFactory() {}
  static public CommandHistory newCommandHistory() {
    // TODO
      CommandHistory commandHistory = new CommandHistoryObj();
    return commandHistory;
  }
}
