# Hangman
This is a small personal project meant to keep my Java skills sharp, using a programme I've written in the past.  
The old project in question is this [Python Hangman](https://github.com/OneOverCosine/Code-Cache/blob/main/Projects/Python/hangman.py)
programme.

I will also be including tests as I attempt to familiarise myself with junit.

## The Objective
Hangman is a two (or more) player game when one person comes up with a word and the other (or others) try to  
guess it. The guessers have a limited number of incorrect guesses. If they reach this limit, they lose.  
In this version of the game, the 'computer' will come up with the word.

## User Stories and Testing
While not really necessary for a small project like this, creating user stories and writing tests based on them can  
help with the development process. Any work done will keep you moving in the right direction if the stories are well-  
defined. The best way to get good at that is by starting with a simple task like this.

### User Stories
- [x] As a player, so that I can interact with the game, I'd like to use the keyboard to make inputs
- [ ] As a player, so that I can see the state of the game, I'd like info like remaining guesses, guessed letters and the like logged to the console
    - [x] As a player, so that I can play the game, I would like a word to guess
    - [x] As a player, so that I can play the game, I'd like to know how many letters I need to guess
    - [x] As a player, so that I can play the game, I'd like to know when I've guessed correctly
    - [ ] As a player, so that I can play the game, I'd like to know when I've guessed *incorrectly*
    - [ ] As a player, so that I won't guess the same letter twice, I'd like to know which letters have been guessed already
    - [ ] As a player, so that I know when to be cautious, I want to know how many guesses I have left
- ~~[ ] As a player, so that it's clear how many letters are in the mystery word, I'd like to see an underscore for each hidden letter~~
- ~~[ ] As a player, so that I can see my correct guesses, I'd like the underscore to be replaced by the letter in the correct place~~
- [ ] As a player, so that I can see how many incorrect guesses are left, I'd like a visual representation of the hanged stick-man
---
- [ ] As a player, so that the game doesn't get boring, I'd like the computer to chose from a variety of English (GB) words

### Domain Models
```
As a player, so that I can interact with the game, I'd like to use the keyboard to make inputs
```
| Objects      | Properties | Messages                        | Outputs  |
|--------------|------------|---------------------------------|----------|
| InputManager |            | getInput(@InputStream, @String) | @String  |
|              |            | isValid(@String)                | @Boolean |
---
```
As a player, so that I can play the game, I would like a word to guess
As a player, so that I can play the game, I'd like to know how many letters I need to guess
As a player, so that I can play the game, I'd like to know when I've guessed correctly
```
| Objects | Properties          | Messages                   | Outputs |
|---------|---------------------|----------------------------|---------|
| Hangman | word @String        | getWord()                  | @String |
|         | displayWord @String | getDisplayWord()           | @String |
|         |                     | checkPlayerGuess(@String)  | Void    |
|         |                     | updateDisplayWord(@String) | Void    |

### Tests
- Character/letter input prompt
- Only accept A-Z, a-z, and digits
- No input on character/letter prompt
- Hangman starts with a word to guess
- Hangman starts with display word where underscores represent missing letters
- Correct guess replaces underscore with guessed letter