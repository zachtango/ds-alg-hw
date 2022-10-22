


'''
fractional knapsack example hw 4 problem 8
'''


# element[0] is the weight of the object and element[1] is the value of the object
objects = [[14, 15], [5, 13], [10, 12], [11, 11], [16, 15], [6, 16], [4, 6], [10, 25], [14, 28], [7, 21]]

# fractional knapsack --> sort objects by value : weight ratio
objects = [[7, 21], [6, 16], [5, 13], [10, 25], [14, 28], [4, 6], [10, 12], [14, 15], [11, 11], [16, 15]]
'''
iterate through sorted objects
at each object:
    if we have enough capacity so far (W) to add the whole object
        add it and update the capacity (W - current obj weight)
        update the total value as well (V + current obj value)
    else 
        add as much of the object as you can (W) 
        update the total value as well (V + W * current obj value / current obj weight)
        break out of the iteration
'''
W = 65
V = 0

i = 1
W = 58
V = 21

i = 2
W = 52
V = 37

i = 3
W = 47
V = 50

i = 4
W = 37
V = 75

i = 5
W = 23
V = 103

i = 6
W = 19
V = 109

i = 7
W = 9
V = 121

i = 8
W = 0
V = 121 + 9 * 15 / 14
V = 130.64 # add fractional value