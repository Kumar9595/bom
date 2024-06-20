# bom

Material Requirement Planning

1. Problem Statement:
Generate material requirement plan (MRP) to manufacture 200 bicycles.

2. Definition:
 MRP – Material Requirement Plan – How much of each part (component) going to be
required to manufacture a finished product (200 bicycles in this case)
 BoM – Bill of Material – Like a recipe, this is a list of all the components, sub-assemblies to
make an end product. This will give you a ratio of each part with respect to the Finished
Good. So In this case how many seats, frames, brake sets etc are going to be required to
manufacture 1 bicycle.
e.g in BoM, it says 1 seat is requires for 1 bicycle. So the BoM ratio is 1 seat divided by 1
bicycles = 1
Calculate ratio for each of the parts with this method and finally multiply each part’s ration
with the total bicycle requirement i.e 200. This will generate the total required quantity of
each part.
A bill of materials or product structure is a list of the raw materials, sub-assemblies,
intermediate assemblies, sub-components, parts, and the quantities of each needed to make
an end product.
 On Hand Inventory – This is the quantity of each part which is already available. It’s not
necessary that there will be some stock of each part. Whatever inventory is available for any
part will be called as On Hand Inventory
 Inventory Net off – After generating the material requirement from BoM, it has to be
compared with on hand inventory. If there is any inventory for any part, that has to be
subtracted from the BoM quantity to generate the final to be procured quantity.
e.g through BoM explosion we know for 200 bicycles, we need 200 seats. On hand inventory
is 50. So Inventory net off (200-50) will have to be done to calculate 150 as a to be procured
quantity.

3. Input:
3.1 Bill of Material:
To assemble a bicycle following items are required.
First Level – to assemble a Bicycle
1 seat, 1 frame, 2 brake sets, 1 handlebar, 2 wheels, 2 tires, 1 chain, 1 crank set, 2 pedals are
required.
Second Level – to assemble a Brake set
Each brake set assembly requires 1 brake paddle, 1 brake cable, 1 set of Lever, and 2 brake
Shoes.
1.2 On Hand Inventory:
For each material there is some availability of stock as given in table below.
Item Stock
Seats 50
Frames 80
Brake sets 25
Brake paddles 100
Brake cables 75
Levers 60
Brake Shoes 150
Handlebars 100
Wheels 60
Tires 80
Chains 100
Crank set 50
Paddles 150

4. What is expected:
You are expected to write a detailed JAVA code to;
Logical/Functional
a) Do BoM explosion to arrive at the total requirement of each part to manufacture a total of
200 bicycles. Take no of bicycles as input instead of fix value of 200.
b) Do inventory net off considering the on hand inventory from the table above and calculate
the final required quantity which is to be purchased from outside.
Coding/Technical

a) Use of proper data structures and exception handling.
b) Application of OOPS concept.
c) Follow coding standards, proper comments in code which explains the points from
functional expectation.
d) More generic solution then considering hardcoded input data sets.