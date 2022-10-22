Zach Tang zxt200009 4/25/2022 CS 3345.503 Assignment 3

The problems that required coding are in the com.company package folder
    each package contains a Main file for testing the problem

    problem 6.34 corresponds to package com.company.six_threefour
        The code for the insert function can be found in the BinomialQueue class.
        I developed the binomial queue code based on the code given in our Data Structures text book by Mark Weiss;
        however, I developed the insert function itself without referring to the code in the textbook
        as I couldn't use the merge routine given. Instead, I used the combineTrees method to combine the necessary
        trees after I inserted a new tree of height 0 (single node) into the queue. The tests for the insert
        function are in the Main class of the package.

    problem 9.3 corresponds to package com.company.nine_three
        The code for the topological sort function can be found in the AdjacencyList class.
        It is this method called topsort(). Testing the function is found in the Main class.
        I created my own graphs: one cyclic and acyclic. Running the main method should show
        the top sort of each. An error should be encountered in the cyclic graph because it's
        impossible to topologically sort a cyclic graph.
