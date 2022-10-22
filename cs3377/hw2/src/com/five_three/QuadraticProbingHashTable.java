package com.five_three;

public class QuadraticProbingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 23;

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
        collisions = 0;
    }

    public int getCollisions(){return collisions;}

    // set all indexes in hash table to null
    public void makeEmpty(){
        currentSize = 0;
        for(int i = 0; i < table.length; i++)
            table[i] = null;
    }

    // see if hash table contains element x
    public boolean contains(AnyType x){
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    public void insert(AnyType x){
        // find open index in hash table
        int currentPos = findPos(x);

        // can't have duplicates in table
        if(isActive(currentPos))
            return;

        // add element x to open index
        table[currentPos] = new HashEntry<>(x);

        // need to rehash once table is more than half full for better efficiency
        if(++currentSize > table.length / 2)
            rehash();
    }

    public void remove(AnyType x){
        int currentPos = findPos(x);
        if(isActive(currentPos))
            table[currentPos].isActive = false;
    }

    // DS for hash table indices
    private static class HashEntry<AnyType> {
        public AnyType element;
        public boolean isActive;

        public HashEntry(AnyType e) {
            this(e, true);
        }

        public HashEntry(AnyType e, boolean i) {
            element = e;
            isActive = i;
        }
    }

    private HashEntry<AnyType>[] table;
    private int currentSize;
    private int collisions;

    // allocate space for hash table in memory
    private void allocateArray(int arraySize) {
        table = new HashEntry[nextPrime(arraySize)];
    }

    // check if index is open at currentPos
    private boolean isActive(int currentPos) {
        return table[currentPos] != null && table[currentPos].isActive;
    }

    // find open index for elem x
    private int findPos(AnyType x) {
        int currentPos = myhash(x);
        int i = 1;

        // handle collisions using f(i) = i^2 (add f(i))
        while (table[currentPos] != null && !x.equals(table[currentPos].element)) {
            currentPos += i * i;
            i++;
            collisions++;
            if (currentPos >= table.length)
                currentPos -= table.length;
        }

        return currentPos;
    }

    // increasing the hash table size for once it gets to full
    private void rehash() {
        HashEntry<AnyType>[] oldTable = table;

        allocateArray(nextPrime(2 * oldTable.length));
        currentSize = 0;

        for (int i = 0; i < oldTable.length; i++)
            if (oldTable[i] != null && oldTable[i].isActive)
                insert(oldTable[i].element);
    }

    // hash function is simply h(x) = x % table.length where table.length is a prime number
    private int myhash(AnyType x) {
        int hashVal = x.hashCode();

        hashVal %= table.length;

        if (hashVal < 0)
            hashVal += table.length;

        return hashVal;
    }

    // get next prime >= n
    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        while (!isPrime(n))
            n += 2;

        return n;
    }

    // check if n is prime
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }
}

