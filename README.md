# Hill climber and Simulated anealing - Matlab implementation

## Simulated annealing
Simulated Annealing is one of the probabilistic methods to search for global optimum (i.e. minimum and maximum values) of a given function. Simulated Annealing is often used when time of finding a value is more important than precision of a result.
During each iteration Simulated Annealing algorithm decides between staying in a state S, or moving to its neighbour S’. In most common implementations, this step is repeated until either:
1.	The state S is the best solution (either the best maximum or minimum of a function), or
2.	Computation budget (energy) has been fully used.
Paradoxically, Simulated Annealing accepts a better neighbour to find higher/lower value of a function, but it can lead to finding the best local optima, rather than global optima.
To overcome this issue, metaheuristics can also accept worse neighbour to discover other values and to avoid being stuck in local optima, doing so can potentially lead to finding global optima if run for a long enough time.
Probability whether transition from position S to position S’ will be made is defined by a function called Acceptance Probability Function (APF) that depends on the energy of movement to position S and S’ and global variable called Temperature. States that requires less energy to move to are considered better than those with greater energy required for transition. Although, even if energy required to move to state S is less than energy required to move to state S’ the APF needs to be greater than 0 – this will prevent from being stuck in local optima.
