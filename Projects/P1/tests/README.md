# Project 1: PacMan

## Group Members:
Connor Hartzog
Austin Kim
Alex Srey
Aminah Yizar

## Gameplay:
![Alt text](https://keep.google.com/u/0/media/v2/1DtKPmrzpz9c6SjN5VJ0CnBiucpRFCQqOH3a-KWqhQMhl6IBvFH54oiNrgSS-VdE/1HbDIhVl_encE20N2BhSakbpV61lY8YM2H7naQl07S9jxbTpm1FjE2LzVBXvZdA?sz=512&accept=image%2Fgif%2Cimage%2Fjpeg%2Cimage%2Fjpg%2Cimage%2Fpng%2Cimage%2Fwebp "Optional title")

## Command Line Code: 
	### Use this to run the game.
javac -cp "src/" src/*.java
java -cp "src/" StartMenu

## Pacman Class:

### get_valid_moves():
This method will get the locations of the four adjacent tiles and determine which of them is a valid move for pacman. A valid move is one that is not a wall or a ghost. 
This method is tested by artificially puting pacman in a location with only 2 valid moves, and a case where one of the moves is occupied by a ghost. 
