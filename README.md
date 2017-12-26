
This game is developed in Java. This game is about one explorer tries to walk out of the pyramid while he is trapped in the pyramid. This game is only one player game. The player can play from the computer keyboard. The player represents the explorer.

In the github repository, I provided nineteen java files which were saved in the pyramidPanic folder. PyramidPanicGame.java, which was one of java files that was saved in the pyramidPanic folder, provided main function to compile the program for this game. There were many png
files and wav files which were saved in the pyramidPanic/Pictures folder. These png files and wav files are used in the PyramidPanicGame code. There were other two java files, which were called KeyboardControl.java and KeyboardEvents.java, were saved in the pyramidPanic/GameKeyControl folder. The implementation of PyramidPanicGame was to upload png files, upload wav files, place images on the game screen, play music and allow player to control explorer from keyboard when the game is begun.

The program can be compiled and executed on the command prompt.

Command line instructions to compile and execute tank game:

1st step (compile program): javac pyramidPanic/MapBackground.java pyramidPanic/Walls.java pyramidPanic/DrawWalls.java pyramidPanic/Explorer.java pyramidPanic/Blocks.java pyramidPanic/Sword.java pyramidPanic/DrawPotions.java pyramidPanic/Potions.java pyrmaidPanic/DrawTreasures.java pyramidPanic/Treasures.java pyramidPanic/DrawScarabs.java pyramidPanic/Scarabs.java pyramidPanic/DrawEnemyBeetles.java pyramidPanic/EnemyBeetles.java pyramidPanic/DrawEnemyScorpions.java pyramidPanic/EnemyScorpions.java
pyramidPanic/DrawEnemyMummies.java pyramidPanic/EnemyMummies.java pyramidPanic/PyramidPanicGame.java

2nd step (execute program): java pyramidPanic/PyramidPanicGame

How to play the game: The player uses the computer keyboard to control the explorer.

Player controls are:
Left Arrow: Rotate left
Right Arrow: Rotate right
Up Arrow: Move forward
Down Arrow: Move in reverse

In this game, the explorer has three lives opportunities. The explorer has three enemies: beetles, mummies, and scorpions. These three enemies move automatically when the game is begun. They will kill explorer and end his exploration. The player should control explorer to try to escape these enemies. If explorer is killed by one of these enemies, the game will be restarted automatically and he will remain only two lives opportunities. The pyramid has many treasures, scarabs, and potions. The explorer can get ten scores after he picks up each treasure. The explorer can get one more life opportunity after he picks up one potion. The explorer can use scarabs to make the mummies temporarily vulnerable after he picks up scarabs. Then he can get ten scores when he drives one mummy away. The pyramid also has one fabled sword of the sun. After explorer picks up the sword, the pyramid's light will become dark. Then the explorer can use sword to drive mummies away. But the explorer's scores will be decreased to ten when he drives one mummies away. It means the explorer's wealth will be drained. If explorer doesn't have remaining life in the game, the game will be finished and player will fail this game. If explorer has remaing life and he successfully walks out of the pyramid, the game will be finished and player will win this game.
