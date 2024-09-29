package 29-sept-2024;

public class allO`oneDataStructure {



    Name Of The Problem :- 432. All O`one Data Structure

    Date :- 29-September-2024

    Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

Implement the AllOne class:

AllOne() Initializes the object of the data structure.
inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
Note that each function must run in O(1) average time complexity.

 

Example 1:

Input
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
Output
[null, null, null, "hello", "hello", null, "hello", "leet"]

Explanation
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "hello"
allOne.inc("leet");
allOne.getMaxKey(); // return "hello"
allOne.getMinKey(); // return "leet"
 

Constraints:

1 <= key.length <= 10
key consists of lowercase English letters.
It is guaranteed that for each call to dec, key is existing in the data structure.
At most 5 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey.


*****************************************************************************************************************************************************

class AllOne {
    private class Node {
        int count;
        LinkedHashSet<String> keys; 
        Node prev, next;
        
        Node(int c) {
            count = c;
            keys = new LinkedHashSet<>();
        }
    }
    private Map<String, Node> keyCountMap;
    private Node head, tail;
    
    public AllOne() {
        keyCountMap = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        if (!keyCountMap.containsKey(key)) {
            if (head.next == tail || head.next.count != 1) {
                addNodeAfter(head, 1);
            }
            head.next.keys.add(key);
            keyCountMap.put(key, head.next);
        } else {
            Node curNode = keyCountMap.get(key);
            int curCount = curNode.count;
            if (curNode.next == tail || curNode.next.count != curCount + 1) {
                addNodeAfter(curNode, curCount + 1);
            }
            curNode.next.keys.add(key);
            keyCountMap.put(key, curNode.next);
            curNode.keys.remove(key);
            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }

    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) {
            return;
        }
        
        Node curNode = keyCountMap.get(key);
        int curCount = curNode.count;
        curNode.keys.remove(key);
        
        if (curCount == 1) {
            keyCountMap.remove(key);
        } else {
            if (curNode.prev == head || curNode.prev.count != curCount - 1) {
                addNodeAfter(curNode.prev, curCount - 1);
            }
            curNode.prev.keys.add(key);
            keyCountMap.put(key, curNode.prev);
        }
        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
    
}
