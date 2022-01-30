import java.util.ArrayList;
import java.util.HashMap;

/** Class for traversable rooms */
public class Room {
  /** The name of the room */
  String name = "";

  /** A description of the room */
  String desc = "";

  /** A list of all the items in the room */ 
  ArrayList<Item> inventory;

  /** A map from String directions to the rooms they would lead to */
  HashMap<String, Room> map;

  /** Constructor for the Room class
   *
   *  @param name  the name of the room
   *  @param desc  the description of the room
   *  @param inventory  the contents the room
   */
  public Room(String name, String desc, ArrayList<Item> inventory) {
    this.name = name;
    this.desc = desc;
    this.inventory = new ArrayList<Item>();
    for (Item item : inventory) {
      this.inventory.add(item);
    }
    this.map = new HashMap<String, Room>();
  }

  /** Method to determine whether an item is in the room
   *
   *  @param item  the item to check for
   *  @return boolean  whether the room has the item
   */
  public boolean has(Item item) {
    return inventory.contains(item);
  }

  /** Method to take an item from the room's inventory
   * 
   *  @param item  the item to remove
   */
  public void removeFromInventory(Item item) {
    this.inventory.remove(item);
  }

  /** Method to add an item to the room's inventory
   * 
   *  @param item  the item to add
   */
  public void addToInventory(Item item) {
    this.inventory.add(item);
  }

  /** Getter method for inventory
   * 
   *  @return ArrayList<Item>  this room's inventory
   */
  public ArrayList<Item> getInventory() {
    return this.inventory;
  }

  /** Getter method for this room's description
   *
   *  @return String  the description of the room
   */
  public String getDesc() {
    return this.desc;
  }

  /** Setter method for the description
   *
   *  @param new_desc  the new description
   */
  public void setDesc(String new_desc) {
    this.desc = new_desc;
  } 

  /** Method to add a path out of the room
   * 
   *  @param direction  the direction the path goes
   *  @param room  the room the path leads to
   */
  public void addExit(String direction, Room room) {
    if (this.map.containsKey(direction.toLowerCase())) {
      System.out.println("Warning: Could not add a second room " + direction + " from " + this.name);
    } else {
      this.map.put(direction.toLowerCase(), room);
    }
  }

  /** Find a room in a specified direction
   *  
   *  @param direction  the direction to look
   *  @return Room  the room in that direction or null if no room was found
   */
  public Room getRoom(String direction) {
    if (this.map.containsKey(direction)) {
      return this.map.get(direction);
    } else {
      return null;
    }
  }

  /** Getter method for name/what is printed
   * 
   *  @return String  this room's name
   */
  public String toString() {
    return this.name;
  }
}