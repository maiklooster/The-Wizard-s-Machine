import java.util.ArrayList;

/** A class for the player */
public class Player {
  /** A list of all the items the player is carrying */
  ArrayList<Item> inventory = new ArrayList<>();

  /** The max number of things the player can carry */
  int invCap = 5;

  /** If this is true, some descriptions of rooms/objects may change */
  boolean sight = false;

  /** The room the player is in */
  Room room = null;

  /** Constructor for the Player class
   * 
   *  @param room  the room the player starts in
   */
  public Player(Room room) {
    this.room = room;
  }

  /** Getter method for the player's room
   *
   *  @return Room  the room the player is in
   */
  public Room getRoom() {
    return this.room;
  }

  /** Getter method for invCap
   *  
   *  @return int  the invCap
   */
  public int getCap() {
    return this.invCap;
  }

  /** Setter method for invCap
   *
   *  @param val  the new inventory cap
   */
  public void setCap(int val) {
    this.invCap = val;
  }

  /** Setter method for sight
   *
   *  @param bool  what to set sight to
   */
  public void setSight(boolean bool) {
    this.sight = bool;
  }

  /** Getter method for the inventory
   *  
   *  @return ArrayList<Item>  the player's inventory list
   */
  public ArrayList<Item> getInventory() {
    return this.inventory;
  }

  /** Method to examine an item
   *
   *  @param item  the item to examine
   */
  public void examine(Item item) {
    if (item.isVisible()) {
      System.out.println(item);
      System.out.println(item.getDesc());
    } else {
      System.out.println("You don't see that here");
    }
    if (item.toString().equals("Machine")) {
      System.out.println("The machine contains: ");
      Container machine = (Container)item;
      for (Item machineItem : machine.getInventory()) {
        System.out.println(machineItem.toString());
      }
    }
  }

  /** Method to examine a room
   *
   *  @param room  the room to examine
   */
  public void examine(Room room) {
    if (this.room == room) {
      System.out.println(room.getDesc());
      this.printRoomItems();
    } else {
      System.out.println("You can't see that room right now");
    }
  }

  /** Method to take an item from a room and put it in the player's inventory
   * 
   *  @param item  the item to be taken
   */
  public void take(Item item) {
    if (this.room.has(item)) {
      if (item.isTakeable() && item.isVisible()) {
        this.room.removeFromInventory(item);
        this.inventory.add(item);
        System.out.println(item+" taken.");
        for (Item i : this.room.getInventory()) {
          if (i instanceof Container) {
            Container con = (Container) i;
            if (con.has(item)) {
              con.removeFromInventory(item);
            }
          }
        }
      } else {
        System.out.println("This item cannot be taken");
      }
    } else {
      System.out.println("You don't see that here");
    }
  }

  /** Check whether the player is carrying a specified item
   * 
   *  @param item  the item to be checked
   *  @return boolean  whether the player is carrying that item
   */
  public boolean has(Item item) {
    for (Item i : inventory) {
      if (i == item) {
        return true;
      }
    }
    return false;
  }

  /** Take an item from the player's inventory
   * 
   *  @param item  the item to remove
   */
  private void removeFromInventory(Item item) {
    this.inventory.remove(item);
  }

  /** Put an item into a container
   *
   *  @param item  the item to move
   *  @param container  the container to move it to
   */
  public void put(Item item, Container container) {
    if (this.has(item)) {
      boolean success = container.addToInventory(item);
      if (success) {
        this.room.addToInventory(item);
        this.removeFromInventory(item);
      }
    } else {
      System.out.println("You don't have this item");
    }
  }

  /** Method to drop an item and add the item to the current room
   *
   *  @param item  the item to drop
   */
  public void drop(Item item) {
    if (this.has(item)) {
      this.room.addToInventory(item);
      this.removeFromInventory(item);
      System.out.println("You have dropped the "+item);
    } else {
      System.out.println("You don't have this item");
    }
  }

  /** Method to go to a different room
   * 
   *  @param dir  the direction to go
   */
  public void go(String dir) {
    Room newRoom = this.room.getRoom(dir);
    if (newRoom != null) {
      this.room = newRoom;
      System.out.println(this.room);
      if (this.room.toString().equals("Cave") && this.sight) {
        System.out.println("The space around you has rugged rock walls. It's dim in here, but not dark enough that you can't see the whole room. With these glasses on, you can see a shimmering veil in front of a hidden passage leading north. A ladder leads back up to the foyer.");
      } else {
        System.out.println(this.room.getDesc());
      }
      this.printRoomItems();
    } else {
      System.out.println("You cannot go that direction");
    }
  }

  /** Method to read a book
   * 
   *  @param book  The book to read
   */
  public void read(Book book) {
    if (book.isReadable() == true) {
      System.out.println(book.read());
    }
    else {
      System.out.println("This book cannot be read right now");
    }
  }

  /** Method to open a container
   * 
   *  @param container  The container to open
   */
  public void open(Container container) {
    if (!container.isOpen()) {
      if (!container.isLocked()) {
        container.setOpen(true);
        System.out.println(container + " opened. You see: ");
        for (Item item : container.getInventory()) {
          item.setVisible(true);
          System.out.println(item);
        }
      } else {
        System.out.println("It's locked.");
      }
    } else {
      System.out.println("It's already open.");
    }
  }

  // /** Method to unlock a container
  // *  
  // *  @param container The container to unlock
  // */
  public void unlock(String containerName) {
    // System.out.println("trying to unlock");
    Container inventoryContainer = null;
    Item itemInContainer;
    boolean match = false;

    //System.out.println("looking in player inventory"); // to delete
    // look for container in player inventory
    for (Item inventoryItem : this.getInventory()) {
      //System.out.println("looping thru player inventory"); // to delete
      if (inventoryItem.toString().toLowerCase().contains(containerName) && inventoryItem instanceof Container) {
        inventoryContainer = (Container) inventoryItem;
        match = true;
        //System.out.println("found in inventory"); // to delete
        break;
      } else if (inventoryItem.toString().toLowerCase().contains(containerName) && !(inventoryItem instanceof Container)) {
        match = true;
        System.out.println("That isn't an item that can be unlocked.");
      }
    }

    // look for container in room inventory
    if (match == false) {
      for (Item roomItem : this.getRoom().getInventory()) {
        if (roomItem.toString().toLowerCase().contains(containerName) && roomItem instanceof Container) {
          inventoryContainer = (Container) roomItem;
          match = true;
          break;
        } else if (roomItem.toString().toLowerCase().contains(containerName) && !(roomItem instanceof Container)) {
          match = true;
          System.out.println("That isn't an item that can be unlocked.");
        }
      }
      if (match == false) {
        System.out.println("I couldn't find that container.");
      }
    }

    // if the container is in player or room inventory
    if (inventoryContainer != null) {
      boolean hasKey = false;
      Item playerKey;
      for (Item invItem : this.getInventory()) {
        // if player has the key
        if (invItem.equals(inventoryContainer.getKey())) {
          hasKey = true;
          playerKey = invItem;
            if (inventoryContainer.isLocked() == true) {
              inventoryContainer.setUnlock(playerKey);
              System.out.println(inventoryContainer + " is now unlocked.");
              for (Item item : inventoryContainer.getInventory()) {
                if (!(item.isVisible())) {
                  item.setVisible(true);
                  itemInContainer = item;
                  //System.out.println("itemInContainer: " + itemInContainer); // to delete
                  inventoryContainer.removeFromInventory(itemInContainer);

                  if (item.toString().toLowerCase().equals("shiny gears")) {
                    System.out.println(
                        "Inside the " + inventoryContainer.toString() + " is a set of " + item.toString());
                  } else {
                    System.out
                        .println("Inside the " + inventoryContainer.toString() + " is a " + item.toString());
                  }
                  break;
                }
              }
              // inventoryContainer.removeFromInventory(itemInContainer);
            } else {
              System.out.println(inventoryContainer + " isn't locked.");
            }
            // if player wants to lock
        }
      }
      // if player doesn't have key
      if (hasKey == false) {
        System.out.println("You don't have the key to this container.");
      }
    }
  }

  /** Method to put on a wearable item
   *
   *  @param item  the item to put on
   */
  public void wear(Item item) {
    if (item.toString().equals("Spectacles")) {
      this.setSight(true);
      System.out.println("You put on the spectacles. Do you look wizened? Absolutely not. But there is a weird shimmer at the edge of your vision.");
    } else if (item.toString().equals("Robes")) {
      this.setCap(10);
      System.out.println("You put on the robes. You look anything but regal, but at least you can fit stuff in the pockets.");
    }
  }

  /** Method to print the list of items in the room occupied
   *  by the player 
   * 
   *  @param dir  the direction to go
   */
  private void printRoomItems() {
    ArrayList<Item> items = new ArrayList<>(this.room.getInventory());
    System.out.println();
    System.out.println("You see the following items: ");
    for (Item item : items) {
      if (item.isVisible()) {
        System.out.println(item);
      }
    }
  }

}