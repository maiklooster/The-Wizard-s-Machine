
/** A class to make items with extra text that may be read, and may be indecipherable for some amount of time */
public class Book extends Item {
  /** Readable text of the book */
  String text = "";

  /** Whether the book can be read without a magic word */
  boolean readable = true;

  /** Magic word to show text */
  String keyword = "";

  /** Constructor for the Book class
   * 
   *  @param name  the name of the item
   *  @param desc  the description of the item
   *  @param text  the extra, possibly readable, text
   */
  public Book(String name, String desc, String text) {
    super(name, desc);
    this.text = text;
  }

  /** Marks the text as unreadable without saying a keyword
   *  
   *  @param keyword  a string for the keyword to 'unlock' the text
   */
  public void setKeyword(String keyword) {
    this.readable = false;
    this.keyword = keyword;
  }

  /** Setter method for readable
   *  
   *  @param bool  what to set readable to
   */
  public void setReadable(boolean bool) {
    this.readable = bool;
  }

  /** Getter method for the text of the book
   *  
   *  @return String  the text
   */
  public String read() {
    return this.text;
  }

  /** Getter method for the keyword
   *  
   *  @return String  the keyword
   */
  public String getKeyword() {
    return this.keyword;
  }

  /** Getter method for the readable attribute
   *  
   *  @return boolean  for whether the text can be read
   */
  public boolean isReadable() {
    return this.readable;
  }

}