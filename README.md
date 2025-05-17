Patience Card Game
This is a Java implementation of a text-based Patience (Solitaire) card game. The objective is to end up with as few piles of cards as possible, ideally just one pile.
Game Rules

The deck is shuffled at the start
Cards are laid down one by one, forming separate piles
Cards can be combined when:

They are adjacent piles with the same number or suit
There are two piles between them with the same number or suit


The goal is to reduce the number of piles to as few as possible, ideally just one

Features

Command-line menu interface
Deck generation and shuffling
Card dealing functionality
Multiple move types:

Move the last pile onto the previous one
Move the last pile back over two piles
Amalgamate piles in the middle (given pile numbers)


Auto-play capabilities:

Play a single move
Play multiple moves


Score tracking with persistent storage
Top 10 leaderboard display

Technologies Used

Java
Object-Oriented Programming
File I/O for score persistence
ArrayLists for dynamic data management

How to Run

Clone this repository
Open the project in your IDE (IntelliJ IDEA recommended)
Run the Main.java file
Interact with the game through the command-line menu

Command Menu
The game offers the following commands:

Print the pack out
Shuffle
Deal a card
Make a move, move last pile onto previous one
Make a move, move last pile back over two piles
Amalgamate piles in the middle (by giving their numbers)
Print the displayed cards on the command line
Play for me once (if two possible moves, makes the furthest one)
Play for me many times
Display top 10 results
Q. Quit the game

Project Structure

Card.java: Represents individual cards with suits and values
Deck.java: Manages the card deck with shuffling functionality
Main.java: Contains game logic and menu interface
Player.java: Base class for player information
PlayerInfo.java: Extended player class with game statistics
PlayerScore.java: Handles saving and loading scores

Score Management
The game keeps track of player scores in a text file (score.txt). The score is determined by the number of piles remaining at the end of the game, with fewer piles being better. When quitting, players can save their score by entering their name.
Future Improvements

Graphical user interface implementation
More advanced auto-play strategies
Additional game statistics

License
This project was created as an academic assignment for "Programming Using an Object-Oriented Language" course.
Acknowledgments

Based on an assignment from CS12320 at Aberystwyth University
