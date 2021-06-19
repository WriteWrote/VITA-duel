# VITA-duel
This is a simple project that imitates card-game.

**Rules of the game:** there are two players, each holding 12 cards with numbers from 0 to 11. The first player chooses a card from his hand and places it face down on the table. The number on the selected card will be the player's "attack". After that, the second player chooses a card from the remaining in his hand and also plays it face down. This is his "defend". After that, the players simultaneously turn over the cards, and the defending player receives as many penalty points as the "attack" of the first player exceeds the defense of the "second". In the next round, the players switch places. The game ends when the players have no cards left in their hands. The player with the least penalty points wins.

The point was to make a working algorithm to challenge actual player.

# Used algorithms
I used several very simple algorithms and one a bit more difficult than others, which, as I believe, externalize all advantages from simple ones.
First two algorithms are **"Choose max. cards firstly"** (so the attack will be more powerful), and **"Choose min.cards firstly"** (so the most useless cards will be thrown away quickly). Another simple algorithm is just **"Choosing card randomly"**.

But first two algorithms above are too predictive, and random-algorithm does not seems to me promising enough. (Also, the win with this algorithm is the matter of luck.)

**Last algorithm ("Median")** divides all available cards into four baskets: [0-3], [4-6], [7-9], [10-11]. Then it picks numbers in that order:
     
     * two random numbers from [4-6]
     
     * two random numbers from [7-9]
     
     * all numbers from [0-3] (also randomly)
     
     * leftover number from [4-6]
     
     * leftover number from [7-9]
     
     * randomly picks all numbers from [10-11]
     
This way it is possible to save the most valuable cards for the last attacks or defends, and at first bot will use "middle"-value cards. After that it will throw away all useless cards from [0-3] (so human-player likely waste some cards) and finally defends/attacks with most powerful cards.

# Struggles
I cannot think right way to invert choosing the way of reacting of bot.
