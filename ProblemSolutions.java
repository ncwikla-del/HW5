/******************************************************************
 *
 *   Nick Cwikla / COMP272-001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
       // Set up flag to see if list2 is a subset of list1.
        boolean isSub = true;
       // Create HashMap for storing number of elements in list1.
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
       // Fill the hash map with number of elements in list1.
        for (int i : list1) {
            hashmap.put(i, hashmap.getOrDefault(i, 0) + 1);
        }
       // Make sure if numbers in list2 match up with the hashmap.
        for (int i : list2) {
          //  If a number is not in the map, or it is 0, set the isSub flag to false.
            if (hashmap.get(i) == null || hashmap.get(i) == 0 || !hashmap.containsKey(i)) {
                isSub = false;
           // Decrement count of the number in the hash map.
            } else {
                hashmap.put(i,hashmap.get(i) - 1);
            }
        }
       // Return result of whether list2 is a subset of list1.
        return isSub;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
       // Set up min heap for storing k largest elements in an array.
        Queue<Integer> pq = new PriorityQueue<>();
       // Go through each element present in the array.
        for (int num : array) {
           // Element is added to the min heap.
            pq.add(num);
           // Have k elements in the heap.
            if (pq.size() > k) {
               // Smallest element is removed if the heap size is larger than k.
                pq.poll();
            }
        }
       // Returns the root as the k-th max element.
        return pq.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
       // Set up min heap to sort elements in ascending order.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Add all elements from both arrays to the priority queue.
        for (int num : array1) {
            minHeap.add(num);
        }
       // All elements from array2 are added to the min heap.
        for (int num : array2) {
            minHeap.add(num);
        }
        // Extract elements in a sorted order.
        int[] result = new int[array1.length + array2.length];
        // Track position of the result array.
        int index = 0;
        while (!minHeap.isEmpty()) {
           // Smallest element is polled and is added to the result array.
            result[index++] = minHeap.poll();
        }
       // Sorted array is returned from both arrays.
        return result;
    }


}