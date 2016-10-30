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

## Thoughts on inner piece, and why CS/Tech ##

I have to admit, I am kind of tired. Tired the getting up early. Tired
about thinking for my future, tired about knowing who I am. And tired about
thinking up who I used to be.

But just now, suddenly, after reading an Harvard Law PhD's post on Zhihu,
it occurred to me that, to forget is to betray.

Why I choose to be here? Why I want to become a programmer?

The answer, which I forget, is actually very simple.

I used to think that coding is fun, considering coding as a fascinating job,
which I could be working along for a whole day and still smile for any coding
challenges. I used to think hackers are so cool, who are able to dig out all
the untoldable information hidden in the internet and get some first-hand
knowledge, predicting the trend of the world. I used to dream to be a creator,
using my own skills and knowledge to create complex machine.

And what about now? All these thoughts are gone. I forget them all, with only one
thing left behind: I know I have to prepare for the interview, or I will become
a free man without any job. I do not want to be a jobless man. But I can not
control myself to fight for my dream, eighter. Recently, I can not get up
early enough to do the coding challenge, because every night when I go to bed,
it usually is 5:00am in the morning already. I'm afraid of being jobless,
and have a lot of pressure deep in my heart, so somehow I choose to escape.

I know this is not a good atitude toward life. But I just can't help. So I
write down all of this into this note, somehow hoping that expressing
myself may relief my mind and make things better.

Human beings are emotional animals. For a long time, without reading any
literary book or watching any deep-thought movie, my mind becomes barren and
torpid. So these days I just buried myself into entertainment videos, somehow
relieved my mind by escaping the cold reality. But time flies, unstoppable.
The deadline will always come, no sooner, no later.

I know it's not a good time to escape any more. I know it's time to fight. With
all my effort. I should firstly let myself know, why the hell I really
want to do the job?

For money? For living? For anyone else also choose to be?
No, they are add-ons. They are never my initial intention.

I choose to be so, because I really think this is a good career that worth my
fighting for a life long time. I do like to **dig out** how things functioning
under the surface. I do want to **create** something big and elegant. I do like
a **freedom** lifestyle. Those are my believes. After searching for all the jobs,
I've found that coding is a really good fit: I can learn how every thing
inside the internet works and influence every one's life; I can create elegant
code that make big impact to people with just a laptop and an editor; I can
live in a wonderful lifestyle with so much freedom and schedule my time to
learn everything I get interested about in my spare time.

All of this, is exactly how I can dream about for an ideal job and ideal lifestyle.
All I care about is that I can live with passion and fun. Life is so short,
I don't want to waste it on something I don't like, or something I am to regret about.

So I decided to fight for my future, with everything I have.
Everything!
