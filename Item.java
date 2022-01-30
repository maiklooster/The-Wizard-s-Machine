
/** A class to make items the player can interact with */
public class Item {
  /** The name of the item */
  String name = "";

  /** A description of the item */
  String desc = "";

  /** Whether this can be taken */
  boolean takeable = true;

  /** Whether this can be worn */
  boolean wearable = false;

  /** Whether this can be consumed - currently an unused feature */
  boolean consumable = false;

  /** Whether the player can see this when they are in the room */
  boolean visible = true;

  /** Constructor for Item class 
   *  
   *  @param name  the name of the item
   *  @param desc  a description of the item
   */
  public Item(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  /** Getter method for description
   *
   *  @return String  this description
   */
  public String getDesc() {
    return this.desc;
  }

  /** Getter method for takeable
   * 
   *  @return boolean  whether this is takeable
   */
  public boolean isTakeable() {
    return this.takeable;
  }

  /** Getter method for wearable
   * 
   *  @return boolean  whether this is wearable
   */
  public boolean isWearable() {
    return this.wearable;
  }

  /** Getter method for consumable
   * 
   *  @return boolean  whether this is consumable
   */
  public boolean isConsumable() {
    return this.consumable;
  }

  /** Getter method for visible
   * 
   *  @return boolean  whether this is visible
   */
  public boolean isVisible() {
    return this.visible;
  }

  /** Setter method for desc
   * 
   *  @param new_desc  the new description
   */
  public void setDesc(String new_desc) {
    this.desc = new_desc;
  }

  /** Setter method for takeable
   *  
   *  @param bool  what to set takeable to
   */
  public void setTakeable(boolean bool) {
    this.takeable = bool;
  }

  /** Setter method for wearable
   *  
   *  @param bool  what to set wearable to
   */
  public void setWearable(boolean bool) {
    this.wearable = bool;
  }

  /** Setter method for consumable
   *  
   *  @param bool  what to set consumable to
   */
  public void setConsumable(boolean bool) {
    this.consumable = bool;
  }

  /** Setter method for visible
   *  
   *  @param bool  what to set visible to
   */
  public void setVisible(boolean bool) {
    this.visible = bool;
  }

  /** Getter method for name/what to print if print is called
   *
   *  @return String  this Item's name
   */
  public String toString() {
    return this.name;
  }
}