# Project 1: PacMan

## Group Members:
Connor Hartzog
Austin Kim
Alex Srey
Aminah Yizar

## Gameplay:

![Alt text](Demo1.png?raw=true "Demo1")
![Alt text](Demo2.png?raw=true "Demo2")


## Command Line Code: 
 Use this to run the game.
javac -cp "src/" src/*.java
java -cp "src/" StartMenu

## Pacman Class:

### get_valid_moves():
This method will get the locations of the four adjacent tiles and determine which of them is a valid move for pacman. A valid move is one that is not a wall or a ghost. 
This method is tested by artificially puting pacman in a location with only 2 valid moves, and a case where one of the moves is occupied by a ghost. 

### move():
This method calls get_valid_moves(). If the resulting ArrayList is empty, PacMan cannot move and the method returns false. If the ArrayList is not empty, a random direction is chosen and PacMan is moved to a new position, with the method returning true.

### is_ghost_in_range():

This method checks PacMan’s surroundings to see if there is a ghost within its attack radius of 1. If a ghost has location , that ghost can attack PacMan if it is located at .  If a ghost is in range to attack Pac-Man, this method will return true. Otherwise, the method will return false.

### consume():

## Ghost Class:

### get_valid_moves():
This method will get the locations of the four adjacent tiles and determine which of them is a valid move for a Ghost. A valid move is one that is not a wall. 
This method is tested by artificially putting a Ghost in a location with only 2 valid moves, and a case where one of the moves is occupied by a ghost and pacman. 


### move():
This method calls get_valid_moves(). If the resulting ArrayList is empty, the Ghost cannot move and the method returns false. If the ArrayList is not empty, a random direction is chosen and the Ghost is moved to a new position, with the method returning true.

### is_pacman_in_range():

This method checks a Ghost’s surroundings to see if PacMan is within its attack radius of 1. If PacMan has location , a Ghost can attack PacMan if it is located at .  If PacMan is within range for the ghost to attack, this method will return true. Otherwise, the method will return false.

### attack():

## Map Class:

### move(String name, Location loc, Type type):
This method updates the sprites location and various map data to keep the GUI mirroring the underlying code. 

### getLoc(Location loc):
This method takes in a Location object, and returns a HashSet of the Types of objects at that location (PACMAN, COOKIE, GHOST, WALL). If the space is outside of the bounds of the maze, a set containing only WALL is returned. Otherwise, the space is empty, and a set containing only EMPTY is returned.  

### attack(String name):
This method takes in a String name as a parameter. Given a ghost name, this method will attempt to control a given ghost and attempt to attack PacMan. If the ghost is able to attack PacMan (is in range), the method will update the display to reflect whether the attack was successful and the game should or should not continue. 

### eatCookie(String name):
