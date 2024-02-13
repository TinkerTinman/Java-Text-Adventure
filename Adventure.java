//Grand JAVA mini cave Adventure Game

import java.util.HashMap;  //hashmap is required to allow the game to function since that is the selected way to navigate the in game map
import java.util.Scanner;  //scanner is required to allow the user to input their commands

class Room {
    String id;  //Needed to add an "ID" string to create a unique room
    String description;  //tells me about the room
    HashMap<String, Room> exits;   //allows me to move between rooms

    public Room(String id, String description) {  //updated to include ID, description and exits
        this.id = id;
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void addExit(String command, Room room) {
        exits.put(command, room);
    }
}

class Game {
    Room currentRoom;
    Room room20; //This is needed to declare the winning room

//below is the code for all of the rooms in the game, to include the ID, to create a new room, a coder needs to add the ID and description, exits are also needed to make the room work in the game.
    public Game() {
        Room room1 = new Room("1", "You start in the middle of a path, a large boulder blocks the path behind you and the entrance to a cave is in front of you.\n");
        Room room2 = new Room("2", "You find yourself just inside the entrance to a large cave.\n");
        Room room3 = new Room("3", "You take a right, the opening of the cave was rather large, but this path has become more more narrow.  You see an opening in the direction of North or you can return west from whence you came.\n");
        Room room4 = new Room("4", "You are now in the middle of the cave, it's rather dark, but you see a faint light in front of you in the distance.  There also seems to be a space to the west of you, but it's hard to tell.\n");
        Room room5 = new Room("5", "You find yourself blocked on all sides with a large boulder in front of you, it is a really nice boulder.\n");
        Room room6 = new Room("6", "There is a large fallen tree in front of you, the entrace to the cave is west.  The North is a rock face you cannot climb and the south is blocked by boulders.\n");
        Room room7 = new Room("7", "There is a large river in front of you with no way to get across.  The North is a rock face you cannot climb and the South is blocked by boulders.\n");
        Room room8 = new Room("8", "You take a left, the opening of the cave was rather large, but this path has become more more narrow.  You see an opening in the direction of North or you can return East from whence you came.\n");
        Room room9 = new Room("9", "You are in a long narrow hallway, you can go North or South\n");
        Room room10 = new Room("10", "This seems to be a dark hallway, not much else around.  The room seems to continue on, or you can go back the way you came.\n");
        Room room11 = new Room("11", "There is a lone lantern hanging from the ceiling that you cannot reach, it provides just enough light to see that the West end of this room abruptly drops into a dark cavernous pit.  The walls are high on either side of you so the only way back is to the East.\n");
        Room room12 = new Room("12", "This is a long narrow hallway, exits are North and South.\n");
        Room room13 = new Room("13", "This is a long narrow hallway, exits are North and South\n.");
        Room room14 = new Room("14", "You come to a sharp corner, if you stay perfectly still you swear you can feel a breeze to the left of you, but it's hard to tell being so dark in here.\n");
        Room room15 = new Room("15", "You see are finally at the other end of the cave, you see a light to the north and a way out!.\n");
        Room room16 = new Room("16", "You've come to a sort of T shaped room, you feel a slight breeze on the right side of you, but there is a larger space you can explore on your left.\n");
        Room room17 = new Room("17", "You're getting a little tired of narrow spaces at this point and begin to wonder why you didn't decide to explore a forest or something.  You can continue on or go back the way you came.\n");
        Room room18 = new Room("18", "You are in room 18, at least thats what the sign said above the door as you walked under it.  The fact that someone named this room and had signage made for it is obviously a sign that a crazy person likes to hang out around here so I'd get scarce unless you want to be this seasons fashionable set of clothes.  The only other things to note is that the room contains only a single folding chair and a take a number stand that is currently on number 6.\n");
        Room room19 = new Room("19", "You feel the sunlight on your skin, it's nice to have made it out of the cave, you wonder why you were in there in the first place. North of you is your house, the south is the path you came from.\n");
        room20 = new Room("20", "It's good to be home, time to take a nap.\n");  //This line has been modified to create the winning room that ends the game automatically, other rooms will be left as is since they are not needed for the winning room.

      //this area provides all of the exits for each room, the exits are listed in the order of the rooms in the game, if an exit is not needed for a room, it will not be listed.
        room1.addExit("north", room2);
        room1.addExit("south", room5);
        room1.addExit("east", room6);
        room1.addExit("west", room7);
        room2.addExit("south", room1);
        room2.addExit("east", room3);
        room2.addExit("west", room8);
        room3.addExit("west", room2);
        room3.addExit("north", room4);
        room4.addExit("south", room3);
        room4.addExit("east", room10);
        room4.addExit("north", room12);
        room5.addExit("north", room1);
        room6.addExit("west", room1);
        room7.addExit("east", room1);
        room8.addExit("east", room2);
        room8.addExit("north", room9);
        room9.addExit("south", room8);
        room9.addExit("north", room13);
        room10.addExit("west", room4);
        room10.addExit("east", room11);
        room11.addExit("west", room10);
        room12.addExit("south", room4);
        room12.addExit("north", room14);
        room13.addExit("south", room9);
        room13.addExit("north", room16);
        room14.addExit("south", room12);
        room14.addExit("west", room15);
        room15.addExit("east", room14);
        room15.addExit("north", room19);
        room15.addExit("west", room16);
        room16.addExit("east", room15);
        room16.addExit("south", room13);
        room16.addExit("west", room17);
        room17.addExit("east", room16);
        room17.addExit("west", room18);
        room18.addExit("east", room17);  
        room19.addExit("south", room15);
        room19.addExit("north", room20);
        room20.addExit("south", room19);

      //this is the starting room
        currentRoom = room1;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);//this is to look for player input
      System.out.println("Welcome to a new adventure, you find yourself on a path in front of a cave, the path behind you is blocked by a boulder, the only way is forward. The cave lies to the North.\n");  //this is the game introduction and give you the starting location
        while (true) {
            System.out.println(currentRoom.description); 
            if (currentRoom.id.equals(room20.id)) { // Check if current room is room20 or the winning room, room ID was required to ensure the game verified the correct room and ended as designed
                System.out.println("Congratulations! You've reached the end of your journey.");
                break; // this break is to break out of the loop and end the game, it is only used in the winning room
            }
            System.out.print("What does thoust do? ");//asking for player input of direction, look or quit
            String command = scanner.nextLine();//the string command is used over direction because the player can type in look or quit, as well as a direction
            if (command.equals("look")) {//if the player types look, it will print out the description of the room
            System.out.println("You look around.\n ");
          } else if (command.equals("quit")) {//this is to quit the game, if the player types quit, it will break out of the loop and end the game if a confirmed yes was also typed in.
            System.out.println("Taking off your adventurers cap so soon? (yes/no)");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing! Goodbye.");//this tells the player that they have quit the game
                System.exit(0);//this is to end the game
            }
            } else if (currentRoom.exits.containsKey(command)) { //this is to check if the player input is a valid direction, if it is, it will move the player to the next room
                currentRoom = currentRoom.exits.get(command);
            } else {
                System.out.println("You can't go that way.\n");  //this is to tell the player that they can't go that way and has entered an invalid direction
            }
        }
    }
}
//starts a new game when program starts
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
