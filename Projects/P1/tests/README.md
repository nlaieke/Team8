# Project 1: PacMan

## Group Members:
Connor Hartzog
Austin Kim
Alex Srey
Aminah Yizar

## Gameplay:

![Alt text](/Team8/Projects/P1/src/assets/Demo1.png?raw=true "Optional Title")


## Command Line Code: 
	### Use this to run the game.
javac -cp "src/" src/*.java
java -cp "src/" StartMenu

## Pacman Class:

### get_valid_moves():
This method will get the locations of the four adjacent tiles and determine which of them is a valid move for pacman. A valid move is one that is not a wall or a ghost. 
This method is tested by artificially puting pacman in a location with only 2 valid moves, and a case where one of the moves is occupied by a ghost. 
