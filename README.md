# Lab-05
## Test-driven development

In today's lab, you will be designing an Iterator for a tree collection performing [depth-first search](https://en.wikipedia.org/wiki/Depth-first_search). Importantly, you'll be designing the tests, not the DFS solution. You're welcome to look that up and use it directly. Instead, you'll be practicing creating a good test structure.

This lab is an individual assignment, but you are welcome to work with your project team to develop solutions.

## TODO 1: Create a new project and implement a tree collection
Start a new project and create a tree collection. You should have some kind of `Node` that looks like this:

```.java
public Node {
  Node right;
  Node left;
  Node parent;
  ...
}
```

And a containing class called `TreeCollection` which implements `Iterable` and an `insert` method. For now, I am not asking you to make a guarantee about the order of the values, but you are welcome to implement any structure that would help you understand the methods better. For example, you could implement a [Binary Search Tree](https://en.wikipedia.org/wiki/Binary_search_tree) if you wanted some guarantee about the tree structure.

## TODO 2: Create an iterator that implements depth-first search (DFS)
Make your `TreeCollection` return a non-trivial iterator that implements depth-first search. Again, you are welcome to simply use whatever code you find on the internet for this part. The bulk of this lab should be focused on test development.

## TODO 3: Sketch out the test coverage you imagine you need for DFS
On a piece of paper, draw a number of different trees and the order that DFS would iterate through them. Write out all of the test cases that you would need to feel satisfied that you had appropriate test coverage to make sure that `hasNext()` and `next()` are working properly. For example, you would want to test the trivial case of an empty tree to begin with. Then, a single-node tree. And so forth. As a rough estimate, I can think of a minimum of 9 test cases that it would take to convince me that DFS was working correctly. Write a minimum of 9 different tests for your DFS iterator.

## TODO 4: Finalize UML Diagrams and Issues
Your initial UML diagrams and issues are due next week. Finalize them after getting your drafts reviewed. Get started on your code base and make your intial commits.

## TODO 5: Draft individual pitches and UML diagrams
With the initial UML diagrams finished, you should start to have a clearer idea of what your individual contribution to the project is going to be. Of course, everyone may be contributing to each other's work, but everyone must have a clear, singular piece that they have individual responsibility for. Drafts will be due next week, but because of midterms, the final will be due the first week after the midterm.

## TODO 5.5: Write initial tests for your part of the system
You are strongly encouraged, but not required, to write well-tested code. Using the ideas from today, try to imagine what the test coverage would be for your part of the system. An easy way to add to your "line count" non-trivially is to develop tests. 

