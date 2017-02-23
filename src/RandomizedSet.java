/**
 * Created by flex on 17-2-23.
 * @author flex
 * no.380 Insert Delete GetRandom O(1)
 */

import java.util.*;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class RandomizedSet {

    private List<Integer> data = null;
    private Map<Integer, Integer> position = null;
    private Random random = new Random();
    private int count;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.data = new ArrayList<>();
        this.position = new HashMap<>();
        this.count = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (position.containsKey(val)) {
            return false;
        }
        position.put(val, count++);
        data.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (position.containsKey(val)) {
            int pos = position.get(val);
            if (pos != count-1) {
                data.set(pos, data.get(count-1));
            }
            position.put(data.get(pos), pos);
            position.remove(val);
            data.remove(--count);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        // System.out.println("count: " + count + "random: " + random.nextInt());
        if (count == 0) {
            return -1;
        }
        return data.get(random.nextInt(count));
    }

    private void printData() {
        System.out.print("[");
        for (int i=0; i<data.size(); i++) {
            if (i == 0) {
                System.out.print(data.get(i));
            } else {
                System.out.print("," + data.get(i));
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();
        /*
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        */
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(-2));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(-3));
        System.out.println(randomSet.insert(-1));
        System.out.println(randomSet.remove(-2));
        System.out.println(randomSet.remove(-2));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.remove(-1));
        System.out.println(randomSet.insert(-3));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.insert(-2));
        System.out.println(randomSet.insert(-2));
        System.out.println(randomSet.insert(-2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.insert(-2));
        System.out.println(randomSet.remove(0));
        System.out.println(randomSet.insert(-3));
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.getRandom());
    }
}
