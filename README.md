# Electronic Billboards Installation Planning

This repository contains the Java program Advertising, which aims to find a minimum spanning tree for a graph representing a city map. The program assists the Mayor's office in installing advertising terminals in a neighborhood, connecting all public places in the district with a wired network in an optimal manner.

## 1. Objectives

The objectives of the program are as follows:

1. Implement an abstract data type Carte based on the graph representation.
2. Implement an algorithm to find a minimum spanning tree with Prim-jarnik's algorithm.

## 2. Problem Statement

The Mayor's office wants to install advertising terminals in a neighborhood to connect all the public places within the district. The provided data includes the list of the most visited public places with corresponding streets in the neighborhood and the cost of terminal installations on each street segment.

A street is identified by a set of places, and both streets and sites are represented by their names. For example:
- "rue0" is the street name
- "a", "b" are the place names
- "4" is the installation cost

The neighborhood sites are connected to each other by forming a labeled connected graph, where nodes represent the neighborhood sites, edges represent the segments of streets connecting the sites, and edge weights represent the installation cost. The objective of TP3 is to find a minimum spanning tree (ARMin) of the neighborhood site graph using the Prim-Jarnik algorithm. When processing edges of the same weight, the program should consider the alphanumeric order of the edge out vertices. In case of equality of weights and edge "out vertices," the alphanumeric order of the edge "in vertices" should be used.

## 3. Program Structure

The program should adhere to the following specifications:

1. **Call Syntax**: The program should be executed using the appropriate Java command or through an IDE.
2. **Input Format**: The input data should be provided to the program in a specific format as specified by the assignment.
3. **Output Format**: The program should generate the minimum spanning tree in the prescribed format as per the assignment's requirements.

Ensure that the program retains the original call syntax, input format, and output format to achieve compatibility with other components and systems.

## 3.1 Call Syntax

The call of your program should be as follows:
- The file `carte.txt` specifies a district public places map with the installation cost.
- The results (a generated minimum spanning tree) have to be saved in the file `arm.txt`.

## 3.2 The File carte.txt

The file `carte.txt` is composed of the following sections:

1. Public Places List (Nodes):
   - Each place is defined by its name (string) on a separate line.

2. Separation Line:
   - The next line contains three dashes (---) to separate the public places list from the street segments.

3. Street Segments:
   - Each street segment is specified on a separate line.
   - Format: `Street name : PlaceIn ; PlaceOut ; InstallationCost ;`
   - Example: `rue0 : a ; b ; 4 ;`

4. End Separator:
   - Three dashes (---) indicate the end of the street segments section.

## 3.3 Adversiting Output Format

The found spanning tree has to be saved in the `arm.txt` file in the following format:

1. Sites List:
   - One site on each line.

2. Street Segments with Corresponding Information:
   - Each line corresponds to a street segment (edge) in the spanning tree.
   - Format:
     ```
     a) Street name: rue0
     b) Sites names: a b
     c) A label (cost): 4
     ```

3. Separation Line:
   - Three dashes (---) of separation between the segments and the total spanning tree cost.

4. Total Spanning Tree Cost:
   - The spanning tree cost is displayed on the last line.

## Sample Code

You can find the Java source code for the Adversiting program in the `src` directory of this repository.

## How to Use

To run the Adversiting program, follow these steps:

1. Clone this repository to your local machine.
2. Open a terminal or command prompt and navigate to the repository directory.
3. Compile the Java source code:
4. Run the program with the input file `carte.txt` and save the output to `arm.txt`:
5. Check the `arm.txt` file to see the generated minimum spanning tree.

Feel free to modify the input data in `carte.txt` to test the program with different scenarios.

---

This repository provides the Electronic Billboards Installation Planning program (Adversiting) that helps in finding an optimal solution for installing advertising terminals in a neighborhood. You can use the program as specified in the README and explore the provided sample code to understand the implementation.

