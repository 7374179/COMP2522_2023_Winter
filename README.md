# Lab 10: Callbacks
Today we are learning about callbacks. The idea is simple, but the pattern is important to learn as a pattern, since it shows up in many, many different types of programming. You'll want to think of callbacks as the following:
- Something happens that you define as an important Event. For example, the mouse is clicked.
- Something must go and process data as a result of the important Event. That is called the EventListener.
- This might happen synchronously, i.e., Event -> EventListener -> Wait for processing to finish -> Continue running program. However, often, you want events to be asynchronous or be able to interrupt existing loops.

## TODO 1: Trace the example code in this repository
Read through and run the synchronous code that we have in this repo. I'm simulating a slow internet connection with the `Thread.sleep` call. Don't remove it for now. The idea is that the code gets a user's records if you query their first name.

## TODO 2: Read through the Callback tutorial
[This tutorial](https://www.baeldung.com/java-callback-functions) has an explanation of callback functions. Read through the synchronous portion and determine the similarities and differences to this lab repo. Then, read the asychronous part.

## TODO 3: Implement an async version of the code in this repo
Follow the above tutorial in implementing an async callback for this repo's code. 

## TODO 4: Implement an async callback in your project
This is the pattern that you want to use to get and put data into your database. Even if you are simulating that database locally in a JSON file, implement the get/fetch as an async callback for your project. Show Paul next week.