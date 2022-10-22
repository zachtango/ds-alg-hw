import math
'''
example run through on hw 4 problem 8
'''
tasks = [[14,15],[10,13],[1,5],[4,6],[8,11],[11,16],[3,6],[2,4],[7,10],[12,14]]

# sort tasks by their end time (second item in the interval)
# if 2 end times are the same,sort by their start time
tasks = [[2,4],[1,5],[3,6],[4,6],[7,10],[8,11],[10,13],[12,14],[14,15],[11,16]]

# loop through sorted tasks and add element i to our result list if element i is
# compatible with the last element saved
lastInterval = [-math.inf, -math.inf]

i = 1
result = [[2,4]]
lastInterval = [2,4]

i = 2
result = [[2,4]] # elem at i = 2 isn't compatible --> don't add to result list
lastInterval = [2,4]

i = 3 # elem isn't compatible

i = 4
result = [[2,4],[4,6]]
lastInterval = [4,6]

i = 5
result = [[2,4],[4,6],[7,10]]
lastInterval = [7,10]

i = 6 # elem isn't compatible

i = 7
result = [[2,4],[4,6],[7,10],[10,13]]
lastInterval = [10,13]

i = 8 # elem isn't compatible

i = 9
result = [[2,4],[4,6],[7,10],[10,13],[14,15]]
lastInterval = [14,15]

i = 10 # elem isn't compatible
