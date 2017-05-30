# Army Simulation

This program simulates two armies fighting each other, with each army having a certain number of foot soldiers, tanks, and planes. The simulation is turn based, with both armies inflicting damage on each other using a discretized set of first order differential Lanchaster equations. The battle is ended when one army is completely defeated (all of its units are destroyed). This program has two modes: visual and command line. 

## Getting Started

These instructions will help you download and execute the program.

### Prerequisites

This code was developed in and tested using Java version "1.7.0_131". 

### Installation

Download the repository locally into an environment with a correct Java version installed. The javadocs can be accessed [here](docs/index.html). 
 
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

## Authors

* **Mohit Kohli** - [MohitPKohli](https://github.com/MohitPKohli/)


## Acknowledgments

* [Lanchaster's Equations](https://en.wikipedia.org/wiki/Lanchester's_laws)

