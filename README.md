# Tic-Tac-Toe

##Introduction Welcome to TicTacToe! The project was made for a Software Engineering Individual Project.



##Installation Click here to download the zip folder that contains the program files. If that does not work, click the "Clone or download" button and select the option "Download Zip". Next, find the zip folder in your downloads folder. Unzip the folder to a convenient location. To run this project you can either run the jar file in the main folder.  

<p align="center">
  <img src="Pictures/OpeningBoard.PNG" width="350"/>
</p>

##Instructions This is a two player game, so find a friend to play aganist! The object of this game is to get three of your character's (either X's or O's) in a row either horrizontally, vertically or diagnally.

The first player to go will be player X. Click on a tile to place your "token" this will end your turn. Player O will then place his/her token and this will continue till either: Player X or Player O gets a 3 in a row or all tiles have been used and there cannont be a winner and this will result in a tie!

##Example Gameplay

<p align="center">
  <img src="Pictures/XFirstTurn.PNG" width="350"/>
</p>

In this example, the player's first guess is "1234". This yields 0 correct and 2 misplaced. This means that two of the digits from the guess are in the secret code, but are not in their correct positions.

alt text

The player swaps the "1" for a "2" and guesses "2234". This yields 1 correct and 0 misplaced. The only digit that was changed was the first one, so having 1 more correct digit means that the changed digit is now in its correct position. The player can safely assume that the first digit is a "2".

It can be assumed that "1" is in the secret code because there are 0 misplaced digits. If "1" was not in the secret code, the number of misplaced would have instead gone from 2 to 1 because the "2" was put in its correct position.

alt text

The player guesses "2314" to confirm that the first digit is a "2". There is now 1 misplaced, so the "1" is not in the correct position. The "1" is supposed to be either in the second or fourth digit's place.

The player also knows that there is neither a "3" nor a "4" in the secret code. If either of them were, there would be more than one misplaced digit.

alt text

Based on this knowledge that there is neither a "3" nor "4" are in the secret code, the player swaps the "1" and the "3" for the new guess. The player does not have to be concerned that moving the "3" will cause any new correct digits that would complicate the results. This makes it easy to discern whether or not the "1" is in its correct position.

The guess of "2134" yields two correct! The player now knows that the first two digits of the secret code are "21".

Tip: If you are certain that one or more digits are not in the secret code, include them in your guesses. This technique makes it much easier to figure out which digits are in the secret code. If the player had guessed "2135", there could have been a result of two correct and one misplaced. The player would have no clue which digit (the "1" or the "5") was correct and which was misplaced.

alt text

Because the player knows that neither "3" nor "4" are in the secret code, the player includes the only other two possible digits in the next guess of "2165". This results in 2 misplaced digits. This means that the last two digits of the secret code are "5" and "6". The player simply has to swap the "6" and the "5" to win the game.

alt text

Victory! The secret code was "2156". The computer displays a congratulatory message and the number of guesses the player made. The player is asked if they would to play another game and prompted to enter "Y" or "N" in response.

Note: Most games require more than 5 guesses.

##Customizations

The length and span of digits of the secret code can be changed in the ["main"] (https://github.com/JBranflake/Codebreaker/blob/master/main.cpp#L9) file. An increase in either of these adds difficulty. Here is a chart displaying various settings and their corresponding difficulties.

Code Span	Code Length	Difficulty
4 digits (1-4)	3 digits	Easy
6 digits (1-6)	4 digits	Medium (Default)
8 digits (1-8)	5 digits	Hard
9 digits (1-9)	6 digits	EXTREME
##Notes

I overcame a couple logical obstacles when writing the code for this game. The first was ensuring that digits were not counted as both correct and misplaced. The second challenge was that, if a digit in a guess was in the secret code more than once, the digit was not counted as more than one misplaced digit. Example of the latter: the player guesses "1234" and the secret code is "5622". At the earlier stages of this code, the single misplaced "2" would be wrongly counted as two misplaced digits. The key to preventing both of these mistakes from happening was changing a digit that was counted as correct or misplaced to an alphabetic character that was not a number and thus not able to be found as a match when judged against the numbers found in the secret code.

##Acknowledgements

The professor of my C++ course provided the random number generator and player input functions for this assignment. I wrote the game logic, secret code generator, and header file. The title was made using a text-to-ASCII-art generator found on this website.
