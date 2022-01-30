import java.util.ArrayList;

/** Class for items which can contain other items */
public class Container extends Item {
  /** A list of all of the items contained within */
  ArrayList<Item> inventory;

  /** The max number of items which will fit within */
  int invCap = 100;

  /** Whether this is open */
  boolean open = false;

  /** Whether this has a lock */
  boolean lockable = false;

  /** Whether this is locked */
  boolean locked = false;

  /** What item can open the lock */
  Item key = null;

  /** Constructor method for Container
   *
   *  @param name  the name of the item
   *  @param desc  the description of the item
   *  @param inventorySize  the maximum capacity of the container
   *  @param items  everything the item contains
   */
  public Container(String name, String desc, int inventorySize, ArrayList<Item> items) {
    super(name, desc);
    this.invCap = inventorySize;

    if (items.size() <= inventorySize) {
      this.inventory = items;

    } else {
      this.inventory = (ArrayList<Item>) items.subList(0, invCap);
      System.out.println("Warning: " + this.name + " could not contain everything that was entered. These first " + inventorySize + " items were contained:");
      System.out.println(inventory);
      System.out.println("And these were excluded:");
      System.out.println(items.subList(inventorySize, items.size()));
    }
  }

  /** Getter method for inventory
   * 
   *  @return inventory  The inventory
   */
  public ArrayList<Item> getInventory() {
    return this.inventory;
  }

  /** Sets container to lockable and locked, assigns key.
   *  
   *  @param key  the item used to lock/unlock the container
   */
  public void setLock(Item key) {
    if (this.open) {
      this.open = false;
    }
    this.lockable = true;
    this.locked = true;
    this.key = key;
  }

  /** Sets container to unlocked
   *  
   *  @param key  the item used to lock/unlock the container
   */
  public void setUnlock(Item key) {
    if (this.locked) {
      if (key == this.key) {
        this.open = true;
        this.locked = false;
      }
    }
  }

  /** Setter method for open 
   * 
   *  @param bool  what to set open to
   */
  public void setOpen(boolean bool) {
    this.open = bool;
  }

  /** Setter method for locked. Checks first to make sure the item is lockable.
   *
   *  @param bool  what to set locked to
   */
  public void setLocked(boolean bool) {
    if (this.lockable) {
      this.locked = bool;
    } else {
      System.out.println("Warning: " + this.name + " is not lockable, and so cannot be locked or unlocked");
    }
  }

  /** Setter method for lockable
   *
   *  @param bool  what to set lockable to
   */
  public void setLockable(boolean bool) {
    this.lockable = bool;
    if (!bool) {
      this.locked = false;
    }
  }

  /** Checks to see if the specified item is in this container
   *
   *  @param item  the item to check the inventory for
   *  @return boolean  whether it item is present
   */
  public boolean has(Item item) {
    for (Item i : inventory) {
      if (i == item) {
        return true;
      }
    }
    return false;
  }

  /** Getter method for open
   *
   *  @return boolean  whether this is open
   */
  public boolean isOpen() {
    return this.open;
  }

  /** Getter method for lockable
   * 
   *  @return boolean  whether this is lockable
   */
  public boolean isLockable() {
    return this.lockable;
  }

  /** Getter method for locked
   * 
   *  @return boolean  whether this is locked
   */
  public boolean isLocked() {
    return this.locked;
  }

  /** Getter method for key
   * 
   *  @return Item  the item which unlocks this container
   */
  public Item getKey() {
    return this.key;
  }

  /** Adds an item to the container's inventory, checking first to make sure it's there
   *  
   *  @param item  the item to add
   *  @return boolean  whether adding was successful
   */
  public boolean addToInventory(Item item) {
    if (this.inventory.size() < invCap) {
      inventory.add(item);
      System.out.println("You have put the "+item+" into the "+this.name);
      return true;
    } else {
      System.out.println("That won't fit here");
      return false;
    }
  }

  /** Removes an item from inventory
   *
   *  @param item  the item to remove
   */
  public void removeFromInventory(Item item) {
    this.inventory.remove(item);
  }

}