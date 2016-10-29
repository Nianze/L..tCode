# Leetcode Notes

*In order to keep track of all the thoughts I've got during my practising
Leetcode, I create this note to highlight all the points and experience.*

## ** 10/29/2016 ** ##
### Thoughts on Binary Search from H-Index###
1. Remember always to include trivial test case at first place:
```java
if (nums == null || nums.length == 0) {return 0;}
```

2. Remember to consider all the corner case at the end:
```java
if (start ??? target) {return ??;}
if (end ??? target) {return ??;}
return ???; // cornell case!
```
### Thoughts on mock interview ###
I should think out loud and speack to my self and explain all my thoughts
and algorithms to my self, just like there's an interviewer sitting in front
of me.

## Thoughts on ArrayDeque vs. LinkedList in Java ##
* **Cons of Linked List**:
 * Linked structures are the worst structure to
iterate with a cache miss on each element
 * have to allocating a node for each item to insert, which essentially
involves JVM/OS and expensive
 * for pop() operation, it mark internal nodes eligible for garbage collection
and that's more work behind the scene
* **ArrayDeque**:
  * if only need to add/remove of both ends, use ArrayDeque
  * e.g.: when using BFS, consider ArrayDeque first.
* **Linked List**:
  * The only better operation of a linked list is **removing the current
element** during iteration.
  * Linked List supports null element

