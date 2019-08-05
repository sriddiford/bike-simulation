# bike-simulation

## General Description
This command line application simulates a bike driving on a 7 x 7 grid.

The application accepts the following case sensitive instructions:
* FORWARD
* TURN_RIGHT
* TURN_LEFT
* PLACE (X),(Y),(CARDINAL DIRECTION) (e.g. PLACE 1,2,NORTH)
* GPS_REPORT

## Why was this exercise chosen?

This exercise was chosen because I believe it allowed me to demonstrate object oriented design and application most effectively. The problem naturally lent itself to two main design patterns; the State Pattern and the Command Pattern. Using these design patterns allowed the code to be more easily reasoned about and open to additional future features.



## Running the program
``` Shell
git clone https://github.com/sriddiford/bike-simulation.git
cd bike-simulation
mvn clean
mvn package
```

For interactive input, run the following command:
```
java -jar target/bike-simulation.jar
```

For input from a file, run the following command:
```
java -jar target/bike-simulation.jar <file location>
```

E.g.
```
java -jar target/bike-simulation.jar ~/Documents/instructions.txt
```
