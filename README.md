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
- [x] As a player, so that I can know the state of the game, I'd like to have access info like to remaining guesses, guessed letters, etc
    - [x] As a player, so that I can play the game, I would like a word to guess
    - [x] As a player, so that I can play the game, I'd like to know how many letters I need to guess
    - [x] As a player, so that I can play the game, I'd like to know when I've guessed correctly
    - [x] As a player, so that I can play the game, I'd like to know when I've guessed *incorrectly*
    - [x] As a player, so that I won't guess the same letter twice, I'd like to know which letters have been guessed already
    - [x] As a player, so that I know when to be cautious, I want to know how many guesses I have left
        - [x] As the system, so that I can show the player their remaining guesses, I want to calculate the number of incorrect guesses made 
        - [x] As a player, so that I can see how many incorrect guesses are left, I'd like a visual representation of the hanged stick-man

*These stories gave me a bit of trouble in terms of testing. I couldn't figure out how to mock functions/ get method  
spying to work. I went with manual testing in the end.  
- [x] As a player, so that I can see the state of the game, I'll like the current game info logged to the console
    - [x] As a player, so that I can start a game, I'd like to see that option in a menu
    - [x] As a player, so that I know what to do next, I'd like to see the state of the current game
---
- [x] As a player, so that the game doesn't get boring, I'd like the computer to chose from a variety of English (GB) words

### Domain Model

| Objects       | Properties                      | Messages                               | Outputs         |
|---------------|---------------------------------|----------------------------------------|-----------------|
| InputManager  |                                 | getInput(@InputStream, @String)        | @String         |
|               |                                 | isValid(@String)                       | @Boolean        |
|               |                                 |                                        |                 |
| Hangman       | word @String                    | getWord()                              | @String         |
|               | displayWord @String             | getDisplayWord()                       | @String         |
|               | initialWord @String             | getIncorrectGuesses()                  | @String         |
|               | incorrectGuesses @String        | getHangedMan()                         | @String         |
|               | hangedManStates @Array[@String] | checkPlayerGuess(@String)              | Void            |
|               |                                 | incorrectGuessCount()                  | @Integer        |
|               |                                 | showDisplayWord(@String)               | Void            |
|               |                                 | checkPlayerGuess(@String)              | Void            |
|               |                                 | updateWord(@Integer, @String, @String) | @String         |
|               |                                 | mainMenu()                             | Void            |
|               |                                 | gameOver()                             | @Integer        |
|               |                                 | currentGameState()                     | @String         |
|               |                                 | setup()                                | Void            |
|               |                                 | play()                                 | Void            |
|               |                                 |                                        |                 |
| HangmanHelper | menu @String                    | loadHangedManStates()                  | @Array[@String] |
|               | words @Array[@String]           | loadMenu()                             | @String         |
|               |                                 | loadWords()                            | @Array[@String] |
|               |                                 | loadFile(@String)                      | @StringBuilder  |

---
### Tests

**InputManager**  
- Character/letter input prompt
- Only accept A-Z, a-z, and digits
- ~~No input on character/letter prompt~~

**Hangman**  
- Hangman starts with a word to guess
- Hangman starts with display word where underscores represent missing letters
- Correct guess replaces underscore with guessed letter
- Incorrect guess leaves display word unchanged
- Incorrect guess is stored
- Can get number of incorrect guesses
- Displayed hanged man depends on number of incorrect guesses

**HangmanHelper**  
- Load hangman states in correct format

## Final Thoughts

### Known Issues
I may or may not fix these in the future. I just wanted to move on before I spent the next month on something  
I only wanted to spend two weeks on. For the moment, most of these issues are to do with input checking.

- While guessing, an empty input throws an exception.
- While guessing, multiple characters are allowed as input - it's only supposed to accept one.