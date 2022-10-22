import math
'''
    optimal scheduling problem: greedy

    given a list of intervals where an interval is semi open / closed --> [s, f)
        s < f

    find the optimum schedule, meaning the schedule with the most intervals possible that are compatible with each other

    interval a is compatible with b if they don't overlap
        b[0] >= a[1] or a[0] >= b[1]

'''
def optimalSchedule(intervals : list[list[int]]):
    # sort intervals by end time
    sortedIntervals = intervals[:]
    sortedIntervals.sort(key=lambda interval : interval[1])

    result = [[-math.inf, -math.inf]]

    for interval in sortedIntervals:
        if interval[0] >= result[-1][1]: # compatibility
            result.append(interval)

    return result[1:]

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
