

'''
fibonacci sequence DP using memoization
'''
def fib(n):
    if n in memo:
        return memo[n]

    ans = fib(n - 1) + fib(n - 2)

    memo[n] = ans

    return ans

memo = {}



'''
    show call stack of fib(n) hw4 problem 3
'''

'''
    call tree of fib(n)
                                        fib(n)
                                    /           \
                                fib(n - 1)    fib(n - 2)
                            /               \
                        fib(n - 2)        fib(n - 3)
                    /               \
                fib(n - 3)       fib(n - 4)
                .         \
                .       fib(n - 5)
                .
            fib(2)
        /           \
    fib(1)         fib(0)

    the fib calls on the right always terminate because their values will be in the memo,
    so we don't need to recurse further from right children

    call stack of fib(n)

        fib(1)
        fib(2)
        .
        .
        .
        fib(n - 3)
        fib(n - 2)
        fib(n - 1)
        fib(n)

'''