/*
 * *** Davide Mazzucco / 001 ***
 *
 * This java file contains several simple tree problems that need to be
 * codified. These routines  must use the TreeMap and TreeSet library
 * classes from the Java Collection Framework.
 *
 */

import java.util.*;

public class TreeProblems {

  /**
   * Method different()
   *
   * Given two TreeSets of integers, return a TreeSet containing all elements 
   * that are NOT in both sets. In other words, return a TreeSet of all the
   * elements that are in one set but not the other.
   */
  
  public static Set<Integer> different(Set<Integer> setA, Set<Integer> setB) {

    // INSERT CODE HERE - DO NOT FORGET TO PLACE YOUR NAME ABOVE
    //
    // This can be done numerous ways, but once such will only that
    // *several* lines of code. Hint: create two temporary TreeSets and utilize the
    // methods retainAll(), addAll(), and removeAll(). But in the end, get something to work.

    //create two temporary sets to use
    Set<Integer> fakeA = new TreeSet<>(setA);
    Set<Integer> fakeB = new TreeSet<>(setB);

    fakeA.removeAll(setB);  //remove all elements that are in setB that are in setA
    fakeB.removeAll(setA);    //remove all elements in setA that are in setB
    fakeA.addAll(fakeB);     //Add all element into one set

    return fakeA;


  }


  /**
   * Method removeEven()
   *
   * Given a treeMap with the key as an integer, and the value as a String,
   * remove all <key, value> pairs where the key is even. 
   */

  public static void removeEven(Map<Integer, String> treeMap) {
    //use an iterator to move through the tree
    Iterator<Integer> iterator = treeMap.keySet().iterator();
    while (iterator.hasNext()) {
      Integer key = iterator.next();
      if (key % 2 == 0) {  //check if key is even
        iterator.remove(); //remove if even
      }
    }
  }


  /**
   * Method treesEqual()
   *
   * Given two treeMaps, each with the key as an integer, and the value as a String,
   * return a boolean value indicating if the two trees are equal or not.
   */

  public boolean treesEqual(Map<Integer, String> tree1,Map<Integer, String> tree2 ) {

    //Check if trees are same size
    if (tree1.size() != tree2.size()) {
      return false;
    }

    //iterate through first tree
    for (Integer key : tree1.keySet()) {
      //check if tree2 contains every key in tree1
      if (!tree2.containsKey(key)) {
        return false;
      }

      //Make sure that the values match as well
      String value1 = tree1.get(key);
      String value2 = tree2.get(key);

      if (!Objects.equals(value1, value2)) {//if they dont match return false
        return false;
      }
    }

    //If all conditions are met the method will return true
    return true;

    //I could have also used this built-in method in the tree class:
    //return tree1.equals(tree2);
    //But I wasn't sure if I was allowed to use it
  }



} // end treeProblems class
