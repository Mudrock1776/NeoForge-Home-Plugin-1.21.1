This is a recreation of the home plugin designed in https://www.youtube.com/watch?v=bYH2i-KOLgk for neoforge minecraft 1.21.1
The commands he designs are in the ./src/main/java/hughes/mods/commands, and the events he adds are in ./src/main/java/hughes/mods/hughesmod.java

This repo is for educational purposes but feel free to add it to your world. It works entirely on the server and is installed the same way mods are.
The Commands are:
- /home: takes player back to thier home
- /set home: sets player home

to build the jar file run:
```
gradlew build
```
The jar file will be in ./build/libs

you might need to download dependecies, which can be done with:
```
gradlew
```