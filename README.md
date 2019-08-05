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

## Design and approach

This application uses 2 main design patterns; the State Pattern and the Command Pattern.

### State Pattern

The State pattern was used as this greatly simplified handling the movement of the bike depending on the direction it was facing. Without the use of the State pattern, the VirtualBike object would need to make use of long conditional logic to determine where it should move when issued a command. This would mean that the code is brittle to any sort of future changes which would require modifying existing working code to add the additional behaviour.

Take for example if the following feature was added in the future: The ability to half turn and therefore allow the bike to move diagonally. Without the use of state objects that the VirtualBike delegates method calls to, the long conditional logic in the VirtualBike class would need to be modified and add cases for facing in any of the half turn directions (NE,SE,SW,NW) which would carry the risk of introducing bugs into the existing working code.

With the use of the State Pattern, all that would be required to be added are additional state objects representing each of the facing directions and implement the methods that the VirtualBike object delegates to. This would mean that no existing code is touched and would eliminate the risk of adding additional bugs.

The state objects controlling the state transition does create coupling between the state objects themselves. This was minimised by avoiding the state objects instantiating concrete state objects themselves when transitioning the VirtualBike's state, and instead instantiating these objects in the VirtualBike class and providing getters for those state objects. In making this decision, this means that the VirtualBike class is closed for future modification.

### Command Pattern

The Command pattern was used as this decoupled the VirtualBike class from the Instruction class. A VirtualRider class was created instead that would execute the command objects for the bike. While initially this does provide an extra layer of abstraction between the VirtualBike and Instruction classes, this would allow additional future features to be added more easily.

The code could have been made more compact by representing the Instruction object methods as lamdas instead however this also was not chosen to allow ease of adding additional features.

For example, the ability for the VirtualBike to have a history of executed commands and provide an "undo" feature that would support issuing it an UNDO command to revert it to its previous state. Implementing this feature would be as simple as adding a undo() method to the Instruction interface and having the VirtualRider class hold a stack of executed commands to pop off as the UNDO command is issued. The Instruction objects would delegate any calls of undo() to the bike which would perform the actions required to revert it its previous state. This would be trivial for TURN_LEFT commands and TURN-RIGHT commands and require only slightly more work for FORWARD commands.


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
