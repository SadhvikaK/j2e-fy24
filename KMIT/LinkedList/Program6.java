import java.util.*;

class Program6{
    private int capacity;
    private Map<Integer, Integer> cacheMap;
    private LinkedList<Integer> keys;

    public Program6(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.keys = new LinkedList<>();
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            keys.removeFirstOccurrence(key);
            keys.addFirst(key);
            return cacheMap.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            keys.removeFirstOccurrence(key);
        } else if (cacheMap.size() == capacity) {
            int leastRecentlyUsed = keys.removeLast();
            cacheMap.remove(leastRecentlyUsed);
        }
        keys.addFirst(key);
        cacheMap.put(key, value);
    }

    public static void main(String[] args) {
        Program6 cache = new Program6(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}