package shop.data;

import shop.command.RerunnableCommand;
import shop.command.UndoableCommand;

import java.util.HashMap;

/**
 * A static class for accessing data objects.
 */
public class Data {
  static HashMap<Integer,VideoObj> videoCollections = new HashMap();
  private Data() {
  }
  /**
   * Returns a new Inventory.
   */
  static public final Inventory newInventory() {
    return new InventorySet();
  }

  /**
   * Factory method for Video objects.
   * Title and director are "trimmed" to remove leading and final space.
   * @throws IllegalArgumentException if Video invariant violated.
   */
  static public Video newVideo(String title, int year, String director) {
    // TODO
    final String _title;
    final int _year;
    final String _director;


    if(title == null || director == null){
      throw new IllegalArgumentException();
    }

    _title = title.trim();

    if(_title == null || _title.length() == 0 ||_title.substring(0,1) == " " ||_title.substring(_title.length()-1)==" ")
    {
      throw new IllegalArgumentException("Illegal title!");
    }
    _year = year;
    if(_year <=1800 || year >= 5000){
      throw new IllegalArgumentException("Illegal year!");
    }

    _director = director.trim();
    if(_director == null ||_director.length() == 0|| _director.substring(0,1) == " " || _director.substring(_director.length()-1) == " ")
    {
      throw new IllegalArgumentException("Illegal director!");
    }

    VideoObj toReturn = new VideoObj(_title,_year,_director);
    int hash = toReturn.hashCode();
    if(videoCollections.containsKey(hash))
      return videoCollections.get(hash);

    videoCollections.put(hash,toReturn);
    return toReturn;
  }

  /**
   * Returns a command to add or remove copies of a video from the inventory.
   * <p>The returned command has the following behavior:</p>
   * <ul>
   * <li>If a video record is not already present (and change is
   * positive), a record is created.</li>
   * <li>If a record is already present, <code>numOwned</code> is
   * modified using <code>change</code>.</li>
   * <li>If <code>change</code> brings the number of copies to be less
   * than one, the record is removed from the inventory.</li>
   * </ul>
   * @param video the video to be added.
   * @param change the number of copies to add (or remove if negative).
   * @throws IllegalArgumentException if <code>inventory<code> not created by a call to <code>newInventory</code>.
   */
  static public UndoableCommand newAddCmd(Inventory inventory, Video video, int change) {
    if (!(inventory instanceof InventorySet))
      throw new IllegalArgumentException();
    return new CmdAdd((InventorySet) inventory, video, change);
  }

  /**
   * Returns a command to check out a video.
   * @param video the video to be checked out.
   */
  static public UndoableCommand newOutCmd(Inventory inventory, Video video) {
    // TODO
    if (!(inventory instanceof InventorySet))
      throw new IllegalArgumentException();
    return new CmdOut((InventorySet) inventory, video);
  }

  /**
   * Returns a command to check in a video.
   * @param video the video to be checked in.
   */
  static public UndoableCommand newInCmd(Inventory inventory, Video video) {
    // TODO  
    if (!(inventory instanceof InventorySet))
      throw new IllegalArgumentException();
    return new CmdIn((InventorySet) inventory, video);
  }
  
  /**
   * Returns a command to remove all records from the inventory.
   */
  static public UndoableCommand newClearCmd(Inventory inventory) {
    if (!(inventory instanceof InventorySet))
      throw new IllegalArgumentException();
    return new CmdClear((InventorySet) inventory);
  }

  /**
   * Returns a command to undo that will undo the last successful UndoableCommand. 
   */
  static public RerunnableCommand newUndoCmd(Inventory inventory) {
    // TODO
    if (!(inventory instanceof InventorySet))
      throw new IllegalArgumentException();
    return ((InventorySet) inventory).getHistory().getUndo();
  }

  /**
   * Returns a command to redo that last successfully undone command. 
   */
  static public RerunnableCommand newRedoCmd(Inventory inventory) {
    // TODO  
    if (!(inventory instanceof InventorySet))
      throw new IllegalArgumentException();
    return ((InventorySet) inventory).getHistory().getRedo();
  }
}  
