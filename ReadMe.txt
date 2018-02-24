=====================================================================
			COMMAND TO BUILD
=====================================================================
1. Use mvn clean package to build the project
2. This will create battleship-1.0.0.jar file target directory

=====================================================================
			COMMAND TO RUN
=====================================================================
Use following command. For more information, see attached screenshot
java -jar battleship-1.0.0.jar <Path of the input file>

<E.g Path of the input file>	D:\test-input-player1.txt
=====================================================================
			OUTPUT
=====================================================================
5 E
2
Q 1 1 A1 B2
P 2 1 D4 C3
A1 B2 B2 C3 C4
A1 B2 B3 A1 D1 E1 D4 D4 D5 D5
2 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 1 1
0 0 0 0 0
0 0 0 0 0
0 2 0 0 0
0 0 1 1 0
0 0 0 0 0
0 0 0 0 0
Player-1 fires a missile with target A1 which got miss
Player-2 fires a missile with target A1 which got hit
Player-2 fires a missile with target B2 which got miss
Player-1 fires a missile with target B2 which got hit
Player-1 fires a missile with target B2 which got hit
Player-1 fires a missile with target C3 which got hit
Player-1 fires a missile with target C4 which got hit
Player-1 won the battle
