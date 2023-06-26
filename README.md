# Project Description
Toy Robot
* Toy robot is a robot simulation game written in java it mimics the basic functionalities of a robot, 
* A robot is able to perform these actions move forward using the  `<forward <steps (the number of steps to move )>>` command, eg `forward 1`
* A robot is able to move bak using the `<back <steps ( the number of steps to move )>>` command, eg `back 19`
* A robot is able to turn either left or right using the `<left> or <right> ` command, eg `right` or `left`
* A robot can also replay its past command by using the ` < replay < steps ( the number of commands to replay) > >  ` command, eg `replay 3 or replay 1`
* A robot can run to the top of the world using the `<mazerun <direction>>` command, eg `mazerun top` or `mazerun bottom`

## Getting Started
This project is a `Java` project using `maven` as build tool.

The structure is as follow:
* `src/main/java` - in here is some skeleton code that you must use as starting point for the problem.
* `src/test/java` - in here are unit tests code that you must complete and extend (your unittests will also be reviewed)

## Build, Test & Run
You may use IntelliJ to run your code and tests, but alternatively you can use the Maven build tool:
* First ensure you are in the root directory of the project
* To compile your code, run: `mvn compile` 
* To run your application: `mvn compile exec:java`
* To run the tests: `mvn test`
* To run GUI application : `java -jar ./jar/toyrobot.jar turtle DesignedMaze`

