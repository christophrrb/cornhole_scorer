# cornhole_scorer
Keeps track of cornhole scoring.

Scoring is as follows:
Each player has a score for each round of cornhole as well as an overall score.
For each bag on the board, the player gets 1 point for the round. For each bag in the hole, the player gets 3 points.
After each round, the player with the most points has their round score subtracted by the other player's.
This difference is then added to the player's total score who had the most points for that round.
If both players have the same round score, then neither wins points for that round.

For example, let's say the first player to 5 points wins.

*Round 1*
>> Rob: 3 Points
>> Bob: 1 Point

Rob has the most points, so he has his score subtracted from Bob's, so 3 - 1 = 2 Rob's score. 2 is added to Rob's total score, which is 0 right now since the game just started.

> _Rob's Total: 2_
> _Bob's Total: 0_
 
*Round 2*
>> Rob: 4 Points
>> Bob: 3 Points

> _Rob's Total: 3_
> _Bob's Total: 0_

*Round 3*
>> Rob: 2 Points
>> Bob: 9 Points

> _Rob's Total: 3_
> _Bob's Total: 7_

Bob won the game!
