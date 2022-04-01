package com.five_three;

public class DoubleHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 23;
    public DoubleHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public DoubleHashTable(int size){
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
        // find index w/ elem x
        int currentPos = findPos(x);
        // remove elem x
        if(isActive(currentPos))
            table[currentPos].isActive = false;
    }

    // DS for hash table indices
    private static class HashEntry<AnyType>
    {
        public AnyType element;
        public boolean isActive;

        public HashEntry(AnyType e){
            this(e, true);
        }

        public HashEntry(AnyType e, boolean i){
            element = e;
            isActive = i;
        }
    }

    private HashEntry<AnyType>[] table;
    private int currentSize;
    private int collisions;

    // create space in memory for hash table
    private void allocateArray(int arraySize){
        table = new HashEntry[nextPrime(arraySize)];
    }

    // see if index at currentPos is occupied
    private boolean isActive(int currentPos){
        return table[currentPos] != null && table[currentPos].isActive;
    }

    // find open index for element x
    private int findPos(AnyType x){
        int currentPos = myhash(x);
        int secondhash = mysecondhash(x);

        // handle collisions using i * second hash
        while(table[currentPos] != null && !x.equals(table[currentPos].element)){
            currentPos += secondhash;
            collisions++;
            if(currentPos >= table.length)
                currentPos -= table.length;
        }

        return currentPos;
    }

    // increasing the hash table size for once it gets to full
    private void rehash(){
        HashEntry<AnyType>[] oldTable = table;

        allocateArray(nextPrime(2 * oldTable.length));
        currentSize = 0;

        for(int i = 0; i < oldTable.length; i++)
            if(oldTable[i] != null && oldTable[i].isActive)
                insert(oldTable[i].element);
    }

    // hash function is simply h(x) = x % table.length where table.length is a prime number
    private int myhash(AnyType x){
        int hashVal = x.hashCode();

        hashVal %= table.length;

        if(hashVal < 0)
            hashVal += table.length;

        return hashVal;
    }

    // hash2(x) = r - (x mod r) where r is a prime smaller than table.length
    private int mysecondhash(AnyType x){
        int hashVal = x.hashCode();
        int r = nextPrime(table.length / 2);

        return (r - (hashVal % r));
    }

    // get next prime >= n
    private static int nextPrime(int n){
        if(n % 2 == 0)
            n++;

        while(!isPrime(n))
            n += 2;

        return n;
    }

    // check if n is prime
    private static boolean isPrime(int n){
        if(n == 2 || n == 3)
            return true;

        if(n == 1 || n % 2 == 0)
            return false;

        for(int i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;

        return true;
    }
}

