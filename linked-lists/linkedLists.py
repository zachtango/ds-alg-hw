'''
    linked list is a data structure in which the objects
    are arranged in a linear order

    different than an array bc the order is determined by
    the pointers in each obj rather than the array indices

    supports search, insert, delete, maximum, minimum,
    successor, and predecessor operations on dynamic sets


    each element of a singly linked list is an object
    with an attribute key and a pointer attribute next

    each element of a double linked list is an object
    with an attribute key and two pointers next and prev
        objects may contain satellite data

    given x, x.next points to successor and x.prev points to predecessor
        if x.prev == NIL, x is the head
        if x.next == NIL, x is the tail

        L.head points to the first element of the list
        if L.head == NIL, the list is empty

    many forms of a linked list
        singly linked or doubly linked
        sorted or not
            sorted --> keys sorted in linear order
        circular or not
            circular --> prev pointer of head points to tail
                and next pointer of tail points to head

'''

from dataclasses import dataclass

@dataclass
class Object:
    def __init__(self, k, next = None, prev = None):
        self.key = k
        self.next = next
        self.prev = prev

    key: int
    next: 'Object'
    prev: 'Object'

@dataclass
class List:
    nil: Object

'''
    using sentinels
    we could write cleaner code if we don't have to
    worry about the boundary conditions at head and tail

    use a sentinel, a dummy node, between the head and tail
    of the list, making it a circular linked list
'''

'''
    searching a linked list
    O(n) time to find key k
'''
def search(L : List, k: int):
    x = L.nil.next
    while x != L.nil and x.key != k:
        x = x.next
    return x

'''
    inserting into a linked list
    given Object x, insert splices x onto the front of the linked list
    O(1) time
'''
def insert(L : list, x : Object):
    x.prev = L.nil
    x.next = L.nil.next

    L.nil.next.prev = x
    L.nil.next = x

'''
    deleting from a linked list
    delete removed element x from the linked list
    must be given pointer to x --> splices x out of the list

    if we want to delete an elem w/ a given key, call search first
    to get the pointer to the elem
'''
def delete(x : Object):
    x.prev.next = x.next
    x.next.prev = x.prev


'''
Exercises free response

10-2-1
    We can implement the dynamic-set operation INSERT on a singly linked list in O(1). Given an element x, we can perform the insert
    by having the x.next point to the list's current head and changing the head to point to x.

    For the dynamic-set operation DELETE on a singly linked list, if we are only given the element x, we can't implement it in O(1) time.
    We would have to search for the predecessor of x in the list to delete x, which will take O(n) time. If we are provided the,
    predecessor, we can perform the DELETE in O(1) time by making the predecessor point to x.next.

'''

# 10-2-2, implement a stack using a SINGLY linked list
# operations PUSH and POP should take O(1)
class Stack: # won't use .prev pointer of Object
    def __init__(self):
        self.L = List(Object(None))

    def push(self, x : Object):
        x.next = self.L.nil.next
        self.L.nil.next = x

    def pop(self):
        if self.L.nil.next == None:
            print("ERROR UNDERFLOW")
            return

        x = self.L.nil.next
        self.L.nil.next = x.next

        return x.key
# 10-2-3, implement a queue using a SINGLY linked list
# operations ENQUEUE and DELETE should take O(1)
class Queue:
    def __init__(self):
        self.L = List(Object(None))
        self.tail = self.L.nil
    
    def enqueue(self, x : Object):
        self.tail.next = x
        self.tail = x

    def dequeue(self):
        if self.tail == self.L.nil:
            print("ERROR UNDERFLOW")
            return

        if self.tail == self.L.nil.next:
            self.tail = self.L.nil
        
        x = self.L.nil.next

        if x != None:
            self.L.nil.next = x.next
        
        return x.key
        
# testing stack and queue
stk = Stack()
q = Queue()

stk.push(Object(10))
stk.push(Object(32))
print(stk.pop()) # print 32
print(stk.pop()) # print 10
print(stk.pop()) # exp error
stk.push(Object(40))
stk.push(Object(44))
print(stk.pop())
print(stk.pop())

q.enqueue(Object(20))
print(q.dequeue()) # print 20
q.enqueue(Object(30))
q.enqueue(Object(40))
print(q.dequeue()) # print 30
print(q.dequeue()) # print 40
print(q.dequeue()) # exp error
q.enqueue(Object(32))
q.enqueue(Object(40))
print(q.dequeue())


# 10-2-4
# eliminate check for x != L.nil in each iteration
def search(L : List, k: int):
    L.nil.key = k

    x = L.nil.next
    while x.key != k:
        x = x.next
    
    L.nil.key = None
    return x # returns sentinel if k is not found

# 10-2-5
# implement dict operations insert, delete, and search
# using singly linked, circular lists what are the running times?
'''
    the implementation will be similar

    insert should be O(1) because you can just insert it at the head of the list

    delete should be O(n) because you need to search for the predecessor of the given element x
    to perform a delete (we don't have access to x.prev bc single list)

    search should be O(n) as well because you still can iterate through the list using x.next
'''

# 10-2-6
'''
    take S1 and S2 as linked lists
    union S1 and S2 by connecting tail of S1 to head of S2
'''

# 10-2-7
# give an O(n) time nonrecursive procedure that reverses a singly linked list of n elements
# procedure shouldn't use more tha nconstant storage beyond that needed for the list itself
def reverse(L : List): # don't use .prev
    prev = L.nil.next
    
    if prev == None:
        return

    curr = prev.next
    prev.next = None

    while curr != None:
        temp = curr.next
        curr.next = prev

        prev = curr
        curr = temp
    
    L.nil.next = prev

