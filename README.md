# kata Tennis
It is about implementing a simple tennis game. The scoring system is rather simple:
  1) Each player can have either of these points in one game 0 15 30 40
  2) If you have 40 and you win the ball you win the game, however there are special rules.
  3) If both have 40 the players are deuce.
      a) If the game is in deuce, the winner of a ball will have advantage and game ball.
      b) If the player with advantage wins the ball he wins the game.
      c) If the player without advantage wins they are back at deuce.
Alternate description of the rules per Wikipedia ( http://en.wikipedia.org/wiki/Tennis#Scoring ):
  1) A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
  2) The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as            “love”, “fifteen”, “thirty”, and “forty” respectively.
  3) If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
  4) If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is        “advantage” for the player in the lead.
  
# Getting Started
  
  In order to run and deploy this application user needs follow below steps-
  
    1) Clone git repostitory in some local folder using below command run on cmder of bash git command prompt.
         git pull https://github.com/mouradbbr/katatennis.git
    2) Open STS and import project as exiting maven project in STS, Setting up STS steps given in installation section.
    3) Right click imported project and go to maven -> update project.
    4) Right click again imported project and go to Run as -> maven clean to clean project.
    5) Right click again imported project and go to Run as -> maven install to install project to compile source code and generate jar
        file in target folder.
    6) Copy katatennis-0.0.1-SNAPSHOT.jar file generated in target folder to some local folder.
    7) Start dos command prompt and reach to copied jar folder location and run below java 
        command - Java -jar katatennis-0.0.1-SNAPSHOT.jar
    8) One dialog will open in command prompt to enter player names of both players and scores. Once user enters the asked details,
        system calculate match outcome based on the points entered for each player.
