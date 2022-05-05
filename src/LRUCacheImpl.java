import java.util.LinkedHashMap;
import java.util.Map;

/**Problem statement
 * https://leetcode.com/problems/lru-cache/
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCacheImpl {
    static class LRUCache {
        private Map<Integer, Integer> cache = new LinkedHashMap<>();
        private int capacity = 0;
        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int i = cache.getOrDefault(key,-1);
            if (i != -1) {
                cache.remove(key);
                cache.put(key, i);
            }
            return i;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
            } else if (cache.size() > capacity - 1) {
                cache.remove(cache.keySet().iterator().next());
            }
            cache.put(key, value);
        }

        public void printCache() {
            System.out.println(String.format("Cache: %s", cache));
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.printCache();
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.printCache();
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.printCache();
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.printCache();
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.printCache();
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.printCache();
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        lRUCache.printCache();
        System.out.println(lRUCache.get(3));    // return 3
        lRUCache.printCache();
        System.out.println(lRUCache.get(4));    // return 4
        lRUCache.printCache();
    }
}