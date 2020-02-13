# Find the best way between two cities

## Multi-Graph

Between two cities there may be more than one way of locomotion

-Highway
-Train
-Airplane
-Road

![Alt Text](https://github.com/henriquecfg/Multi-Graph/raw/master/graph.jpg)


And each one has different advantages

-Time spent traveling
-Money Cost
-Nearest


## Implementation

So these 3 options can be the "cost" of the graph
To differentiate the 3 options the design pattern strategy was used, and so with the dijkstra algorithm the graph can be easily solved generating 3 different solutions, one for each type of cost.
