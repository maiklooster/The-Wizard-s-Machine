import java.util.ArrayList;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    // create items
    // lab items
    ArrayList<Item> labItems = new ArrayList<>(); // add tools

    ArrayList<Item> machineItems = new ArrayList<>();
    Item brokenLens = new Item("A Broken Lens", "Once a glass disc that might have been used to magnify light. Now you should be careful not to cut yourself.");
    Item rustyGears = new Item("Rusty Gears", "Well these won't turn any more. Don't get tetanus.");
    Item greenCrystal = new Item("A Green Crystal", "A round, smoothly cut green crystal. It glows faintly.");

    machineItems.add(brokenLens);
    machineItems.add(rustyGears);
    machineItems.add(greenCrystal);

    Container machine = new Container("Machine", "A decrepit machine that clearly used to be magical. Maybe you can fix it.", 5, machineItems);
    machine.setTakeable(false);
    machine.setOpen(true);

    Book notes = new Book("Notes", "Scattered papers with scribbled notes and a rough drawing of the machine in the lab", "Something seems to be causing trouble with my machine. The crystals used to power it keep disappearing to the farthest reaches of my tower, and this morning I woke up to see the lens broken in two. I've resolved to keep spare lenses and gears in hidden places, and only put them in when I need to use the machine.");

    labItems.add(machine);
    labItems.addAll(machineItems);
    labItems.add(notes);

    // study items
    ArrayList<Item> studyItems = new ArrayList<>();
    Book journal = new Book("Journal", "An old looking leather-bound notebook. The cover is embossed with a lotus.", "You're really going to read a wizard's journal? Well, let's hope he's not around to curse you. It says:\n Friday - Emrys just sent me a new decoration for my study. The mirror is strange, said to be able to see truths. He said the magic word was 'abracadabra', but I haven't tried it out yet. Maybe if I hadn't misplaced the instruction manual. Things keep going missing lately...");

    Item key = new Item("Key", "A small silver key attached to a chain.");

    Item spectacles = new Item("Spectacles", "Dainty spectacles with copper rims. The glass is rather thin, but shines oddly in the light.");
    spectacles.setWearable(true);

    Book mirror = new Book("Mirror", "The frame is beautifully carved with owls, but the glass is foggy... and the fog is moving. Is this even a mirror?", "The fog swirls and fades from the surface of the mirror, displaying what looks like the lab upstairs. A man is scribbling on papers as a set of beakers bubbles next to him.\nThen a shadow moves when it absolutely shouldn't. From the darkness comes a little goblin, visibly holding in laugher as it creeps toward the alchemy setup. One push sends the whole apparatus tumbling to the floor. The man who you assume to be the wizard leaps up in surprise, but is too late to stop the crash. Magic clouds fill the room, obscuring your vision. When they fade, the broken glass and spilled potions are gone. And so is the wizard.\nThe the mirror clouds back over, apparently finished with show and tell.");
    mirror.setTakeable(false);
    mirror.setKeyword("abracadabra"); // maybe change the keyword later

    studyItems.add(journal);
    studyItems.add(key);
    studyItems.add(spectacles);
    studyItems.add(mirror);

    // bedroom items
    ArrayList<Item> bedroomItems = new ArrayList<>();
    ArrayList<Item> jewelryBoxItems = new ArrayList<>();

    Item newLens = new Item("Glass Lens", "A clear glass disc. It looks like it might fit in the machine.");
    newLens.setVisible(false);
    jewelryBoxItems.add(newLens);

    Container jewelryBox = new Container("Jewelry box", "Graceful silver patterns curl around the edges of this little box. A small silver lock adorns the front.", 1, jewelryBoxItems);
    jewelryBox.setTakeable(false);
    jewelryBox.setLock(key);

    Item robes = new Item("Robes", "Who on earth would wear something this gaudy? Oh wait, huge pockets. Never mind.");
    robes.setWearable(true);

    Book book = new Book("Worn Book", "It's titled 'How to To Tame a Cursed Raven', by Ash Cole. Sounds cuddly.", "How to Tame a Cursed Raven\nIt says: First you must aquire the heart of a-\nActually, you don't think you want to know.");

    Item wand = new Item("Wand", "About a foot of twisted rowan wood with an onyx stone at its base. It hums faintly.");

    Item lamp = new Item("Lamp", "It looks like it's made from an old stump, a purple one. And the lampshade looks odd too. It completely encloses the light... hold on, are those insects casting those shadows in there?");
    lamp.setTakeable(false);

    Item bed = new Item("Bed", "A fancy four poster bed, with sheets in complete disarray. Somehow, it still manages to look inviting.");
    bed.setTakeable(false);

    bedroomItems.add(jewelryBox);
    bedroomItems.addAll(jewelryBoxItems);
    bedroomItems.add(robes);
    bedroomItems.add(book);
    bedroomItems.add(wand);
    bedroomItems.add(lamp);
    bedroomItems.add(bed);

    // greenhouse items
    ArrayList<Item> greenhouseItems = new ArrayList<>();

    Item firstFood = new Item("Shriveled Apple",
        "The fruit has turned brown and pruny. It looks unappetizing, but probably not any more poisonous than a ripe apple. That said, this place was home to a wizard, so who knows.");
    firstFood.setConsumable(true);
    Item secondFood = new Item("Shriveled Plum", "This might as well be a prune, but it's probably safe to eat.");
    secondFood.setConsumable(true);

    Item firstFreshFood = new Item("Ripe Apple", "Shiny and red, this apple looks juicy and appetizing.");
    firstFreshFood.setConsumable(true);
    firstFreshFood.setVisible(false);
    Item secondFreshFood = new Item("Ripe Plum", "Dark purple and just soft enough to be juicy.");
    secondFreshFood.setConsumable(true);
    secondFreshFood.setVisible(false);

    Item fountain = new Item("Fountain",
        "The fountain has a beautifully carved statue of a peacock, and the water coming out of the bird's mouth and tail is crystal clear.");
    fountain.setTakeable(false);

    Book instructionBook = new Book("Instruction Book",
        "A spiral bound notebook with a drawing of a goldfinch on the front.", "It says: For proper use of your new seer's mirror, you must first know its keyword. Say this keyword out loud, and then you'll be able to see great mysteries. \n\n(Mirror may cause dizziness, nausea, or sudden loss of heartbeat. Speak with your local wizard before trying this mirror.)");

    greenhouseItems.add(firstFood);
    greenhouseItems.add(secondFood);
    greenhouseItems.add(firstFreshFood);
    greenhouseItems.add(secondFreshFood);
    greenhouseItems.add(fountain);
    greenhouseItems.add(instructionBook);

    // foyer items
    ArrayList<Item> foyerItems = new ArrayList<>();

    ArrayList<Item> drawerItems = new ArrayList<>();
    Item newGears = new Item("Shiny Gears",
        "Bright, shiny, brass gears.");
    newGears.setVisible(false);
    drawerItems.add(newGears);

    Container drawer = new Container("Side Table Drawer", "It's a drawer. It looks like a drawer.", 1, drawerItems);
    drawer.setTakeable(false);

    foyerItems.add(drawer);
    foyerItems.add(newGears);

    // cave items
    ArrayList<Item> caveItems = new ArrayList<>();

    Item blueCrystal = new Item("Blue Crystal", "A round, smooth blue crystal. Maybe sapphire?");

    caveItems.add(blueCrystal);

    // spring items
    ArrayList<Item> springItems = new ArrayList<>();

    Container pool = new Container("Spring",
        "A gently glowing pool of water. It ripples mildly despite there being nothing to move it.", 100, springItems);
    pool.setOpen(true);
    pool.setTakeable(false);
    springItems.add(pool);

    Item purpleCrystal = new Item("Purple Crystal", "A light purple crystal, glowing brightly.");
    springItems.add(purpleCrystal);

    // create rooms
    Room greenhouse = new Room("Greenhouse",
        "The walls and ceiling are all made of glass, and you have no idea how a place like this would survive a storm. The air is warm and humid, but none of the plants look healthy. Maybe the wizard has been gone longer than you thought. Stairs behind you lead back down to the Laboratory.",
        greenhouseItems);

    Room lab = new Room("Laboratory",
        "A messy stone room filled with metal scraps that might or might not be magical, and scattered papers covered with magical diagrams. A machine sits at the center, but looks like it might be broken. The stairway winds up and down.",
        labItems);
    lab.addExit("up", greenhouse);
    greenhouse.addExit("down", lab);

    Room study = new Room("Study",
        "A massive dark oak desk dominates this room. It is covered with well-loved books and various knick-knacks. A curious mirror sits on the wall. The stairway spirals up and down.",
        studyItems);
    lab.addExit("down", study);
    study.addExit("up", lab);

    Room bedroom = new Room("Bedroom",
        "One of the most luxurious bedrooms you have ever seen. And it definitely looks lived in, considering the mess... Behind you, the stairway continues up or down.",
        bedroomItems);
    study.addExit("down", bedroom);
    bedroom.addExit("up", study);

    Room foyer = new Room("Foyer",
        "You are in a gilded room with vaulted ceilings. You're not quite sure how vaulted ceilings work on the first floor of a tower, but hey, that's magic for you. A stairway leads upwards, and you spy a ladder leading down through a hole in the floor.",
        foyerItems);
    bedroom.addExit("down", foyer);
    foyer.addExit("up", bedroom);

    Room cave = new Room("Cave",
        "The space around you has rugged rock walls. It's dim in here, but not dark enough that you can't see the whole room. A ladder leads back up to the foyer.",
        caveItems);
    foyer.addExit("down", cave);
    cave.addExit("up", foyer);

    Room spring = new Room("Underground Spring",
        "Large glowing crystals of every color of the rainbow seem to sprout from the walls of this cavern. In the center of the chamber is a shallow pool of rippling water. It seems to glow just as much as the crystals around it. The passageway you came from lies to the south.",
        springItems);
    cave.addExit("north", spring);
    spring.addExit("south", cave);

    // create player
    Player player = new Player(foyer);

    // Begin gameplay

    System.out.println();
    System.out.println("There's a cloud of dark magic on the horizon. Glittery, like all curses are, in a way that you just know will stick everywhere for months. Usually the wizard in his tower takes care of things like this. You've heard tales he has some weird curse-repelling machine, but there's been no word from him. \n\nYou're not quite sure how you got elected to go check on him, but you're here now, and he isn't answering when you call out. \n\n...Well if he's not here, you suppose it's up to you. Maybe you can find something to help. \n\n *Type 'help' to get a list of commands");
    System.out.println();
    System.out.println(player.getRoom());
    System.out.println(player.getRoom().getDesc());
    System.out.println();
    System.out.print("You see the following items: \nSide Table Drawer");
    System.out.println();

    Scanner input = new Scanner(System.in);
    boolean playing = true;
    boolean won = false;
    String response;
    String[] command;

    String[] dirs = { "up", "down", "north", "northwest", "west", "southwest", "south", "southeast", "east", "northeast", "in", "out" };
    ArrayList<String> reasonableDirections = new ArrayList<String>();
    for (String str : dirs) {
      reasonableDirections.add(str);
    }

    String[] keywords = {
        "Drop item - leave item in the current room",
        "Examine/Look/X - look around the room",
        "Examine/Look/X item - take a closer look at something", "Go direction - move player to another room",
        "Inventory - check your inventory", 
        "Open item - try to open an item",
        "Put item into container - put item into container", 
        "Read book - read extra text from a book",
        "Say word - maybe you can do some magic in the right place",
        "Take item - try to take an item",
        "Unlock container - unlock container",
        "Wear item - don an article of clothing" };
    ArrayList<String> reasonableCommands = new ArrayList<>();
    for (String str : keywords) {
      reasonableCommands.add(str);
    }

    while (playing == true) {
      response = input.nextLine();

      command = response.toLowerCase().split(" ");
      System.out.println();

      // get possible commands
      if (command[0].equals("help")) {
        for (String str : reasonableCommands) {
          System.out.println(str);
        }

        // (going) in a direction(given a single direction)
      } else if (command.length == 1 && reasonableDirections.contains(command[0])) {
        player.go(command[0]);

        // going in a direction
      } else if (command[0].equals("go")) {
        if (reasonableDirections.contains(command[1])) {
          player.go(command[1]);
        } else {
          System.out.println("Where?");
        }

        // looking
      } else if (command[0].equals("x") || command[0].equals("examine") || command[0].equals("look") || command[0].equals("describe")) {
        if (command.length == 1) {
          player.examine(player.getRoom());

        } else {
          boolean match = false;
          for (Item item : player.getRoom().getInventory()) {
            if (item.toString().toLowerCase().contains(command[1])) {
              match = true;
              player.examine(item);
              break;
            }
          }
          if (match == false) {
            for (Item item : player.getInventory()) {
              if (item.toString().toLowerCase().contains(command[1])) {
                match = true;
                player.examine(item);
                break;
              }
            }
          }
          if (match == false) {
            System.out.println("I can't find that item.");
          }
        }

        // check inventory
      } else if (command[0].equals("inventory")) {
        if (player.getInventory().size() == 0) {
          System.out.println("Your inventory is empty.");
        } else {
          System.out.print("You are carrying: ");
          if (player.getInventory().size() == 1) {
            System.out.println(player.getInventory().get(0));
          } else if (player.getInventory().size() == 2) {
            System.out.println(player.getInventory().get(0) + " and " + player.getInventory().get(1));
          } else {
            for (int i = 0; i < player.getInventory().size() - 1; i++) {
              System.out.print(player.getInventory().get(i) + ", ");
            }
            System.out.println("and " + player.getInventory().get(player.getInventory().size() - 1));
          }
        }

        // taking an object
      } else if (command[0].equals("take")) {
        if (command.length == 1) {
          System.out.println("Take what?");
        } else {
          int counter = 0;
          Item match = null;
          String[] takeItem = response.toLowerCase().split(" ", 2);
          for (Item item : player.getRoom().getInventory()) {
            if (item.toString().toLowerCase().contains(takeItem[1]) && item.isVisible()) {
              match = item;
              counter++;
            }
          }
          if (match == null) {
            for (Item item : player.getInventory()) {
              if (item.toString().toLowerCase().contains(takeItem[1]) && item.isVisible()) {
                match = item;
                counter++;
              }
            }
          }
          if (counter > 1) {
            System.out.println("I'm not sure what you're trying to take.");
          } else if (counter == 0) {
            System.out.println("You don't see that here");
          } else {
            player.take(match);
          }
        }

        // drop item in room
      } else if (command[0].equals("drop")) {
        if (command.length > 1) {
          for (Item item : player.getInventory()) {
            if (item.toString().toLowerCase().contains(command[1])) {
              player.drop(item);
              break;
            }
          }
        } else {
          System.out.println("Please specify an item");
        }

        // put item into container
      } else if (command[0].equals("put")) {
        if (command.length > 3) {
          Item currentItem = null;
          Container container = null;
          boolean havePut = false;

          for (Item item : player.getInventory()) {
            if (item.toString().toLowerCase().contains(command[1])) {
              currentItem = item;
              break;
              } else {
            }
          }
          if (currentItem != null) {
            for (Item roomItem : player.getRoom().getInventory()) {
              if (roomItem.toString().toLowerCase().contains(command[command.length - 1]) && roomItem instanceof Container) {
                container = (Container)roomItem;
                if (container.isLocked()) {
                  System.out.println("This container is locked.");
                  break;
                } else {                  
                  player.put(currentItem, container);
                  havePut = true;
                  //System.out.println("You have put the "+currentItem+" into the "+container);
                  break;
                }
              }
            }
            if (container == null) {
              for (Item playerItem : player.getInventory()) {
                if (playerItem.toString().toLowerCase().contains(command[command.length - 1]) && playerItem instanceof Container) {
                  container = (Container)playerItem;
                  if (container.isLocked()) {
                    System.out.println("This container is locked.");
                    break;
                  } else {                  
                    player.put(currentItem, container);
                    havePut = true;
                    //System.out.println("You have put the "+currentItem+" into the "+container);
                    break;
                  }
                }
              }
            }
            if (container == null) {
              System.out.println("I can't find that container.");
            }
          }
        } else {
          System.out.println("Incorrectly formatted.");
        }

        // unlock a container
      } else if (command[0].equals("unlock")) {
        if (command.length == 1) {
          System.out.println("Unlock what?");
        } else {
          player.unlock(command[command.length - 1]);
        }

        // read book
      } else if (command[0].equals("read")) {
        Book toRead = null;
        for (Item item : player.getInventory()) {
          if (item.toString().toLowerCase().contains(command[1]) && item instanceof Book) {
            toRead = (Book) item;
            player.read(toRead);
            break;
          }
        }
        if (toRead == null) {
          for (Item item : player.getRoom().getInventory()) {
            if (item.toString().toLowerCase().contains(command[1]) && item instanceof Book) {
              toRead = (Book) item;
              player.read(toRead);
              break;
            }
          }
          if (toRead == null) {
            System.out.println("I can't find that book.");
          }
        }

      //open a container
      } else if (command[0].equals("open")) {
        Container toOpen = null;
        for (Item item : player.getInventory()) {
          if (item.toString().toLowerCase().contains(command[1]) && item instanceof Container) {
            toOpen = (Container) item;
            player.open(toOpen);
            break;
          }
        }
        if (toOpen == null) {
          for (Item item : player.getRoom().getInventory()) {
            if (item.toString().toLowerCase().contains(command[1]) && item instanceof Container) {
              toOpen = (Container) item;
              player.open(toOpen);
              break;
            }
          }
          if (toOpen == null) {
            System.out.println("I can't find that.");
          }
        }
      
      //wear something
      } else if (command[0].equals("wear")) {
        Item toWear = null;
        boolean match = false;
        for (Item item : player.getInventory()) {
          if (item.toString().toLowerCase().contains(command[1])) {
            toWear = item;
            match = true;
            if (item.isWearable()) {
              player.wear(toWear);
            } else {
              System.out.println("You can't wear that.");
            }
            break;
          }
        }
        if (!match) {
          for (Item item : player.getRoom().getInventory()) {
            if (item.toString().toLowerCase().contains(command[1])) {
              toWear = item;
              match = true;
              if (item.isWearable()) {
                player.take(toWear);
                player.wear(toWear);
              } else {
                System.out.println("You can't wear that.");
              }
              break;
            }
          }
        }
        if (!match) {
          System.out.println("You don't see that here.");
        }

      // say
      } else if (command[0].equals("say")) {
        if (player.getRoom() == study && command.length == 2) {
          if (command[1].equals("abracadabra")) {
            mirror.setReadable(true);
            player.read(mirror);
          }
        }

      // anything else
      } else {
        System.out.println("I don't know how to do that. Type 'help' for a list of commands.");
      }
      System.out.println();


      //check win
      if (machine.has(greenCrystal) && machine.has(blueCrystal) && machine.has(purpleCrystal) && machine.has(newLens) && machine.has(newGears) && !won) {
        won = true;

        System.out.println("You won!!! The machine whirs to life, and you can see the glittery curse cloud get blown back. Would you like to continue exploring?");
        String answer = input.nextLine().toLowerCase();
        System.out.println();
        if (answer.equals("n") || answer.equals("no")) {
          playing = false;
          System.out.println("Thank you for playing!");
          input.close();
        } else {
          machine.setDesc("A glowing, humming magical device currently occupied by repelling a glitter curse.");
          System.out.println("Well, the tower is still empty, you suppose you can stay a little longer.");
        }
      }
    }
  }
}