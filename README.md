# Army Simulation

This program simulates two armies fighting each other, with each army having a certain number of foot soldiers, tanks, and planes. The simulation is turn based, with both armies inflicting damage on each other using a discretized set of first order differential Lanchaster equations. The battle is ended when one army is completely defeated (all of its units are destroyed). This program has two modes: visual and command line. 

## Getting Started

These instructions will help you download and execute the program.

### Prerequisites

This code was developed in and tested using Java version "1.7.0_131". 

### Installation

Download the repository locally into an environment with a correct Java version installed. The javadocs can be accessed [here](docs/). 
 
## Program Execution

A step by step series of how to get the program to execute

#### Option 1: Use jar file

```
cd location-of-army-simulation/
java -jar ArmySimulation.jar 
```

#### Option 2: Compile and run manually

```
cd location-of-army-simulation/
javac src/main/*.java
java src/main/ArmySimulationMain
```

## Using the Program

A series of steps on how to actually use the program once it is executed.

#### Visual

When prompted, choose visual mode.

```
Welcome to army simulation by Mohit Kohli!
Do you want to use visual mode? (Type Y or N)
Y
```

In the following data entry screen that pops up, enter the amount of units for each category for both armies. The values must be non-negative integers.

In the following simulation window, you can click the 'Step' button to perform one turn in the battle. Clicking 'Run Full Simulation' will run all the turns until the battle is over. Click 'New Simulation' to return to the data entry screen.

#### Command Line

When prompted, choose command line mode.

```
Welcome to army simulation by Mohit Kohli!
Do you want to use visual mode? (Type Y or N)
>>> N
```

You will be prompted 

## Authors

* **Mohit Kohli** - [MohitPKohli](https://github.com/MohitPKohli/)


## Acknowledgments

* [Lanchaster's Equations](https://en.wikipedia.org/wiki/Lanchester's_laws)

