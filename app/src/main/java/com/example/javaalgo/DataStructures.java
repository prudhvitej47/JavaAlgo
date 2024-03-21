package com.example.javaalgo;

import java.util.*;

public class DataStructures {

    public static void main(String[] args) {

        // LinkedList
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(12);
        ll.addFirst(5);
        ll.addLast(15);
        ll.remove(); // removes at head
        ll.removeFirst();
        ll.removeLast();
        ll.indexOf(12); // O(n)

        // Queue implemented via LinkedList
        Queue<Integer> normalQueue = new LinkedList<>();
        normalQueue.add(2);
        normalQueue.add(4);  // adds to back of the queue
        normalQueue.remove(); // removes from head of queue
        normalQueue.peek(); // retrieves but does not remove
        normalQueue.poll(); // retrieves and removes

        // Queue implemented via Deque
        Queue<Integer> dequeue = new ArrayDeque<>();  // supports element insertion and removal from both ends
        dequeue.add(5);
        dequeue.add(6);
        ((ArrayDeque<Integer>) dequeue).addFirst(4);
        ((ArrayDeque<Integer>) dequeue).addLast(7);
        ((ArrayDeque<Integer>) dequeue).removeFirst();
        ((ArrayDeque<Integer>) dequeue).removeLast();
        ((ArrayDeque<Integer>) dequeue).peekFirst();
        ((ArrayDeque<Integer>) dequeue).peekLast();
        ((ArrayDeque<Integer>) dequeue).pollFirst();
        ((ArrayDeque<Integer>) dequeue).pollLast();

        // elements are ordered by their natural order
        // a type T conforms to a natural order if it implements the type Comparable
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(11);
        priorityQueue.remove();
        priorityQueue.peek();
        priorityQueue.poll();

        Queue<Integer> priorityQueueRev = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueueRev.add(10);
        priorityQueueRev.add(11);
        priorityQueueRev.add(15);
        priorityQueueRev.add(20);
        System.out.println("Head of Priority queue in reverse order: " + priorityQueueRev.peek());


        Comparator<JavaStreamsTut.Person> customPersonComparator =
                Comparator.comparing((JavaStreamsTut.Person p) -> p.getName())
                        .thenComparing((JavaStreamsTut.Person p) -> p.getAge());

        Queue<JavaStreamsTut.Person> priorityQueuePerson = new PriorityQueue<>(customPersonComparator);
        priorityQueuePerson.add(JavaStreamsTut.Person.of("Muddy", 56));
        priorityQueuePerson.add(JavaStreamsTut.Person.of("Fred", 44));
        priorityQueuePerson.add(JavaStreamsTut.Person.of("Avatar", 12));
        priorityQueuePerson.add(JavaStreamsTut.Person.of("Roger", 22));
        priorityQueuePerson.add(JavaStreamsTut.Person.of("Andy", 14));
        priorityQueuePerson.add(JavaStreamsTut.Person.of("Andy", 13));
        System.out.println("Head of Priority queue with custom comparator: " + priorityQueuePerson.peek());

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("Andy", "Sales");
        hashMap.put("Dwight", "Assistant to the Regional Manager");
        hashMap.put("Angela", "Accounting");
        hashMap.put("Michael", "Regional Manager");
        hashMap.put("Pam", "Receptionist");
        hashMap.get("Angela");
        hashMap.remove("Andy");

        hashMap.entrySet().forEach(e -> System.out.print(e.getKey() + " = " + e.getValue() + "; "));
        System.out.println();

        // HashMap but in a sorted order
        // TreeMap uses a Red-Black tree based navigation and sorting
        // Red-Black tree is a binary search tree in which every node is colored with either red or black.
        // It is a type of self-balancing binary search tree.
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("Andy", "Sales");
        treeMap.put("Dwight", "Assistant to the Regional Manager");
        treeMap.put("Angela", "Accounting");
        treeMap.put("Michael", "Regional Manager");
        treeMap.put("Pam", "Receptionist");
        treeMap.get("Angela");
        treeMap.remove("Andy");

        treeMap.entrySet().forEach(e -> System.out.print(e.getKey() + " = " + e.getValue() + "; "));
        System.out.println();

        PriorityQueue<AdjListNode> pq = new PriorityQueue<>(Comparator.comparing(adjListNode -> adjListNode.minDistance));
        pq.add(new AdjListNode(1, 4));
        pq.add(new AdjListNode(2, 2));
        pq.add(new AdjListNode(3, 10));
        pq.add(new AdjListNode(4, 1));

        AdjListNode minDistanceNode = pq.poll();
        System.out.println(minDistanceNode.vertex + " " + minDistanceNode.minDistance);

        List<List<Integer>> snap = new ArrayList<>();
        snap.add(List.of(1,2,4));
        snap.add(List.of(1,2,3,6));
        snap.add(List.of(1,2,3,6,7,9));
        snap.add(List.of(1,2,3,6,8,9));

        System.out.println(Collections.binarySearch(snap.get(3), 5));

        List<Integer> temp = new ArrayList<>(List.of(1, 2, 3, 4));
        System.out.println(List.copyOf(temp));

        int[] arrx = new int[]{1,2,3,4,5};
        int[] tempArrx = arrx.clone();

        Random rand = new Random();
        for (int i = tempArrx.length - 1; i >= 0; i--) {
            int j = rand.nextInt(i + 1);
            int swap = tempArrx[i];
            tempArrx[i] = tempArrx[j];
            tempArrx[j] = swap;
        }

        System.out.println(Arrays.toString(arrx));
        System.out.println(Arrays.toString(tempArrx));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "String");
        map.put(1, "Hello");
        System.out.println(map.get(1));
    }

    static class CustomComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

    static class AdjListNode {
        int vertex;
        int minDistance;

        AdjListNode(int vertex, int minDistance) {
            this.vertex = vertex;
            this.minDistance = minDistance;
        }
    }
}
