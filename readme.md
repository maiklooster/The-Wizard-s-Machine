# Design Justification
We used a HashMap to link the rooms together. We would also have been able to use a DoublyLinkedList to link the rooms together, since our rooms are in a chain structure (each room has max 2 rooms attached to it, and there are no cycles). However, a HashMap is much better, since a future programmer can add more rooms to the network (and they could attach more than two adjacent rooms to a given room). This allows for the possiblility of an underground cave system, or potentially making the tower part of a castle.

We only needed three general kinds of objects: a Player whose actions impact the in-game world, interconnected Rooms that have objects and in which a Player can be located, and Items that the Player can interact with. Since the rooms must be able to contain items, each rooms has an ArrayList of items that can be modified as the player takes or drops items, and has a HashMap that stores the adjacent rooms. Since the main objective of the game is to fix the machine by inserting the functioning components, we needed a subclass of Item that has its own inventory of items and can be locked or unlocked; this was the Container. We wanted to have books to give a player hints, so we made Book another subclass of item. Each book has text that can be read by the player. Finally, we needed a Player class that contains the actions the player may perform. The actions are methods called in the game loop (So long as certain conditions are met).


# Amanda's Reflection
1) I started with an idea of a story, and then figured out what the smallest set of items was to make this story both possible and engaging. Then I started on support code to make sure that I would have that minimum level of functionality. 

After that Mai and I started building our world, adding support code as we needed. We also made up our game loop and started adding commands. 

We had to restructure the loop a couple of times before we landed on going command by command, but I like the way it turned out.

2) This project kind of drove home the point of what classes can interact with in other classes. On several occasions I wanted to change an item's attributes in the player class, but that doesn't work since the items only exist in main. Learning to get around that was challenging, but actually pretty fun. 

I really enjoyed seeing how comfortable with Java I've grown over the course of this semester. I felt solid on my coding skills, including using the documentation when I needed it.

3) I kind of wish I had created items and rooms with multiple constructors so they could have different descriptions depending on whether the player was wearing the spectacles (and therefore 'sighted'). 

I also wish we had found a better way of doing container inventories so we could see items from containers when the containers are open and move containers with objects inside.

4) Given unlimited time, I would make it so that you have to charge each crystal in the underground spring for them to properly power the machine. I would also like to create some fun uses for the wand, maybe some extra magic words to find and say. Adding more books would be a fun activity too. I already brainstormed some titles with a friend:
  - Standard uses for Pickles in Sleeping Potions
  - The History of the Lepruchan Liberation Movement
  - How to Curse a Tamed Raven (Sister volume to how to Tame a Cursed Raven)

5) I would tell myself not to go overboard on non-essential items. As cool as they were to write and add to the world, they should have been saved for last, as additions that we could build on after we made sure we already had a working game.


# Mai's Reflection
1)   Amanda wrote the story and the descriptions/text/etc., which was very very impressive! She had an idea of the rooms and items, and I made some suggestions and additions. After implementing base code and some basic methods and attributes for Player, Room, Item, Container, and Book, we created the rooms and items (we left the descriptions blank until much later in the process). We then started the game loop, using conditionals for each command and adding more attributes/methods to the classes as needed. We ended up moving things around, but I think it ended up being generally logical and clean. There are definitely some things that I'd like to be more streamlined, but overall I'm very happy with it and I had a lot of fun with it!!!
 
2)   HashSets/HashMaps are definitely the data structures that I feel least secure about, but this assignment helped me understand them a bit more. They still feel quite squishy, but using them for the architecture navigation made a lot more sense. The different classes (and the relationships between the classes) also really solidified my understanding of inheritance. I also haven't played a lot of interactive games like this, so it was very interesting to build one from scratch!!
 
3)   Originally, the spectacles were called glasses. However, if glasses and glass lens were in the inventory, and glasses had a lower index in the arraylist, if the user enters 'put glass lens into machine', the program will put glasses into the machine because we use .contains() to look for the item. For the 'put' command, we used .contains and the last word in command[] so that we can find two-word items and one-word items without having to differentiate.
 
4)   Add a 'take from container' method. Currently, the player.take() method has a conditional looping through the items in the room looking for a container. if the room has a container containing the item to take, it removes it from the container inventory as well as the room inventory, so unfortunately it doesn’t work if you take the container out of the original room. Even though we had intended to make some containers takeable, we had to make all of them untakeable so that the player would be able to take an item from the container. I'd also like the wand to do things. Also, when the player wins, the greenhouse should be clean and lush, and the fruit should look fresh and ripe! We didn't get around to implementing that, but it was the idea. Also, I would add some kind of hunger meter, eat() method, and drink() method in the player class. The items have a consumable attribute, but there isn't a way to eat them at the moment. Since the description of the lamp says there are insects, it would be fun if the lamp were a container that had insects, and when the player tries to take the insects, it prints something like "they're bugs. why do you want to take them?"
 
5)   Try to put as much code into player methods as possible! I wrote a lot of really complicated and difficult-to read conditionals writing the game loop. Originally, the Player class didn't have an unlock method, and all the code was in the game loop. there was a lock/unlock conditional in the game loop that was a little over 100 lines and made it very difficult to read. I transferred the code to an unlock method in the player class, but it took more work and confusion than it needed. I also let Amanda take the lead on all of the descriptions because she does a lot of creative writing and is very good at it, and I was a little nervous to do so. I would tell myself to do some writing anyway, even if it isn't as 'good' as I might have liked it to be.
