# Midterm-Takeup-Winter-2023
This repo contains notes and study materials for the Winter 2023 2522 Midterm. Here's a reminder of the midterm format and how to use this repository. 

The midterm is designed to expose flaws in your understanding of Java programming. That is why it's a difficult time trial. I can deeply assess difficulties and remedies as a result of applying this kind of test. There are many examples of misunderstandings here in this repository. It's your job now to find examples that are either taken from your midterm or are reasonably close and determine what you misunderstood while taking the midterm.

You are able to "make back" a portion of your marks by demonstrating your understanding of the material that you either missed or got wrong. Here's how it will work:

1) You can make back a maximum of half of the marks you missed. Precisely, if your mark is `X`, you can have a final grade of `X + (100-X)/2`.

Justification: This formula favours those of you who did poorly on the midterm. I want to highly incentivise a thorough review of your coding practices. People with higher grades can still "make back" marks, but the time investment is disincentivized.

2) You will have to **create and solve a unqiue version of the question you got wrong or missed** and **explain in detail how it tests the same concept as the question you got wrong or missed**. 

Justification: This will demonstrate that you thoroughly understand the material. Without both creating and explaining a unique question, I won't be able to properly assess whether you know the material.

3) If you got below 60%, you will have to submit evidence that you have gone to BCIT Peer Tutoring in the form of a screenshot or picture of your scheduled time with them. You may also decide to get other forms of tutoring, but I will only accept BCIT Peer Tutoring as evidence of tutoring.

Justification: If you got below 60% on the exam, you likely need focused, personal attention. I can give you some of that during office hours or in labs, but, realistically, you need to develop a practice where you rely on other official mechanisms for support. 

**Submit your questions to this repository** before **April 7 at midnight**. If you need to submit evidence of peer tutoring, **email the evidence to Paul at paul_bucci@bcit.ca**.


## Notes

### Basic 01
This question tests your basic ability to create Java classes that contain and manipulate state.

#### Example reasonble answer
```.java
class Basic_01_Player {
  private int id;
  String label;
  private float x;
  private float y;
  private int counter;

  public Basic_01_Player(String label) {
    Random rand = new Random();  // watch that you don't always know where the random seed comes from
    this.id = rand.nextInt(50);  // probably want this to be higher range
    this.label = label;
    x = 0; // using the this.attr syntax is important for consistency and disambiguating between
    y = 0; // local and global variables. The compiler may choose a scope that you're not expecting!
    this.counter = 0;
  }

  public void move(float x, float y) {
    x = x;          // re: scope, this would not achieve the expected change in class state
    this.y = y;     // whereas this would
    this.counter++; // this is my python bias, but I tend to discourage the ++ syntax due to readability
  }
}
```

#### Example mistakes

```.java
private int id = -1;
public Basic_01_Player(String s) {
  this.label = s;
  this.id = id++; // this will only ever give you id = 0
}
```
This example shows that the author is expecting that each new instantiation of the class will have a unique id that is higher than the last. Instead, each instantiation will have the same id of `0`.

```.java
public void move(float x, float y) {
  this.x = x; // good start
  this.y = y; // good start
  this.x++; // wrong place to add one (should be count) 
  this.y++; // wrong place to add one (should be count) 
}
```
This is likely a misreading of the question. The author is setting `this.x` and `this.y` properly, but then increasing each by one. This is part of the reason I discourage the `++` syntax. It would be a little easier to see visually that something was amiss if you saw any of the following:

```.java
this.x = x;
this.x = x + 1;
this.x = this.x + 1;
```

I try to encourage people to use their powerful human visual pattern-matching brains to debug as much as their explicit knowledge. Looking at the visual pattern that multiple assignments make in a row would likely send up a small red flag that something is wrong.

```.java
public void move(int x, int y) {
  this.xpos = this.xpos + x;
  this.ypos = this.ypos + y;
  xpos++;
  ypos++;
}
```

This is combining the two above problems, a confusing variable scope and a visually ambiguous operator.

```.java
public void move(float v, float v1) {
  v+=1;
  v1+=1;
  count +=1;
}
```
This adds one to the passed-in variables, rather than adding to the global class state.

```.java
Random random = null;
int uid = random.nextInt();
```
This declares `random` as null, and therefore it would not be instantiated. It would compile, since the compiler sees that the type is correct, but it would have a null pointer exception on running.

```.java
Random random = new Random();
int uid = random.nextInt();
```
This instantiates the variable.


```.java
public Basic_01_Player(String label) {
  this.uid = gen.nextInt();
  this.label = label;
  this.x = x;
  this.y = y;
  this.count = count;
}
```
Also a problem with scope. The author may expect that these variabes would be instantiated in the constructor, but the compiler should complaint that `x` doesn't exist in that scope.

```.java
public void move(){
  this.x = this.x + x;
  this.y = this.y + y;
  count++;
}
```
This effectively doubles the `x` and `y` position since there are no parameters `x` and `y` in scope.

```.java
public class Basic_01_Player {
  private static int uidCounter = 0; // here
  public int uid;
  public String label;
  public float xpos;
  public float ypos;
  public int counter;
  public Basic_01_Player(String label) {
    uid = uidCounter;
    this.label = label;
    counter = 0;
  }
  public void move(float xpos, float ypos) {
    this.xpos = xpos;
    this.ypos = ypos;
    counter++;
  }
}
```
This is almost a good answer, but there's a dangerous under-the-hood difficulty. Here's my example and output so that you can see the problem:

```.java

public class Example {
  int counter = 0;
  static int statcount = 0;
  Example() {
    counter++;
    statcount++;
  }

  public static void main(String[] args) {
    Example ex1 = new Example();
    Example ex2 = new Example();
    System.out.format("ex1.counter: %s; ex2.counter: %s\n", ex1.counter, ex2.counter);
    System.out.format("ex1.statcount: %s; ex2.statcount: %s\n", ex1.statcount, ex2.statcount);
  }
}
> Task :Example.main()
ex1.counter:   1; ex2.counter:   1
ex1.statcount: 2; ex2.statcount: 2
```
as you can see, the class doesn't store state on instatiated objects, and a static variable is exactly that, static for all class instances.

### Basic 02
This question tested the ability to use classes to transform the state of other classes.

#### Example reasonable answers

```.java
public void run() {
  if (gasTank.gas > 0) {
    speedometer.speed++;
    gasTank.gas--;
  }
}
```

```.java
public void run() {
  if (tank.getGasValue() > 0) {
    speedometer.setSpeed(speedometer.getSpeed() + 1);
    tank.setGasValue(tank.getGasValue() - 1);
  }
}
```

#### Remedies
The above problems suggest that the authors are having difficulty with basic Java syntax. The only solution is practice, and a lot of it. Type out the correct Java synstax in a `main` method without using autocomplete until you can do it 25 times in a row without making a mistake. Treat it like piano practice.

#### Example mistakes
```.java
public void run() {
  if (Basic_02_GasTank.gas > 0) {
      Basic_02_Speedometer.speed++;
      Basic_02_GasTank.gas--;
  }
}
```
I saw a lot of these kinds of answers. In this case, the author is (possibly) imagining that they are accessing instantiations of the class, but the meaning of the above would be setting static variables. You would want to declare and instantiate the above as variables, then access them.

```.java
public void run() {
  Basic_02_Speedometer.speed++;
  Basic_02_GasTank.gas++;
}
```
I also saw a surprising number of these. This has the above problem and also the wrong direction of increment/decrements.

```.java
public void run(){
  if (Basic_02_GasTank.gas > 0){
      run();
  }
}
```

Circular call, will either run forever or stack overflow.

```.java
public void run() {
  sm.speed += 1;
  if (gas.gas > 0) {
    gas.gas -= 1;
  }
}
```
Misreading of the question: `sm.speed += 1` should be inside the `if` statement.

```.java
public void run(){
  if (Basic_02_GasTank.getGas() > 0){
    s.setSpeed(s.getSpeed()+=1);
    g.setGas(g.getGas() -= 1);
  }
}
```
Can't `+=` a function. This is a difference between code and math variables that is sometimes difficult to grasp. If you set `x = s.getSpeed()` and then `x += 1`, you could then `s.setSpeed(x)`, but each of these actually evaluate to "nothing" without a variable assignment or a return statement. It's kind of like calling `s.setSpeed(undefined)` as written.

```.java
public void run() {
  if (Basic_02_GasTank.gas > 0) {
    speedometer++;
    gasTank--;
  } else {
    return 0;
  }
}
```
Wrong return type. A bit of C creeping in: beware that Java is less flexible than C in this regard by design.

```.java
public void run (int gas, int speed) {
  if (gas < 0) {
      speed += 1;
      gas -= 1;
  }
}
```
Variable scope problem. Local variables would be set and then thrown away.

```.java
public void run() {
  speed += speed;
}
```
Missing conditional logic and simply doubles speed.

#### Example remedies
These problems are also mostly syntactic. Practice as suggested for `Basic 01`, but also spend time stepping through functions by hand, and then by the debugger. If you ever find that your stepping by hand is different than the debugger, inspect the problem with your mental model and update it. Write it out: what did you think was happening and what was actually happening? Although it sounds annoying, actually writing it out will force you to conceptualize the problem fully.

### Basic 03
This question tested your ability to use superclasses effectively to avoid duplicate code and rely on already-created logic.

#### Example reasonable answer
```.java
public void startTimer(int time) throws InterruptedException {
  Thread.sleep(time); 
  makeCoffee(); // makes use of superclass
}
```

```.java
public void startTimer(int milliseconds) {
  try { // using a try..catch is the other way to handle the exception.
      Thread.sleep(milliseconds);
  } catch (InterruptedException e) {
      throw new RuntimeException(e); 
  }
  makeCoffee();
}
```
#### Example mistakes
```.java
public void startTimer(int time) {
  fill(1000); // not asked for
  makeCoffee(); // good
}
```
Misreading of the question: makes use of superclass (good) but doesn't improve functionality. Also erroneously fills the pot again.

```.java
public class Basic_03_CoffeeMakerWithTimer extends Basic_03_Answer {
  int timer;
  
  public void startTimer(int i) {
    timer = i;
  }
  
  @Override
  public void makeCoffee() {
    Thread.sleep((long) timer);
    while (this.waterLevel > 0f) {
      System.out.format("Coffee is at %d millileters...\n", this.coffeeLevel);
      this.coffeeLevel += 1f;
      this.waterLevel -= 1f;
      try {
        Thread.sleep(15);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    System.out.println("Coffee is done!!");
  }
}
```
Overrides rather than uses the superclass method. No parameters.

```.java
public void startTimer(float minInFuture) {
  long startTime = System.nanoTime();
  long coffeeTime = System.nanoTime();
  if (coffeeTime != (startTime + minInFuture)) {
    coffeeTime = System.nanoTime();
  } else {
    makeCoffee();
  }
}
```
Good ideas in here, but nothing will advance the timer.

```.java

```.java
public void startTimer(int i) {
  for(int j = i; j <= 16; j++) {}
}
```
Not a great idea to rely on the for-loop taking some time for a real timing need. Also uses a very low magic number.

```.java
int timer;
public void startTimer(int timer) {
  this.timer = timer;
}
```
Doesn't actually start the timer. Likely a misunderstanding of the question.

#### Example remedies
Many of the problems here are with misunderstanding the relationships between super and sub classes. Practice creating super and subclasses that make use of `super()`. Write code outside of the IDE and predict whether something will be accessible before confirming with the IDE. Similarly, create instances of subclasses and see what is accessible from the superclass.

### Basic 04
Most problems here were simply missing the fact that I had asked for an interface. Practice with interfaces.

### Basic 05
This question tested your ability to create and use exceptions.

#### Example reasonable answers
```.java

// Correct
class Basic_05_LockedException extends Exception {
  public Basic_05_LockedException(String message) {
    super(message);
  }
}

class Basic_05_OpenException extends Exception {
  public Basic_05_OpenException(String message) {
    super(message);
  }
}

public void open() throws Basic_05_LockedException {
  if (locked) {
    throw new Basic_05_LockedException("It is locked!");
  }
  open = true;
}

public void close() throws Basic_05_LockedException {
  if (locked) {
    throw new Basic_05_LockedException("It is locked!");
  }
  open = false;
}

public void lock() throws Basic_05_OpenException {
  if (open) {
    throw new Basic_05_OpenException("It is opened.");
  }
  locked = true;
}

public void unlock() {
  this.locked = false;
}

// Technically not quite correct, but I would accept this
public void closeAndLock() {
  try{
    this.close();
  } catch (Basic_05_LockedException e) {
    System.err.println("Locked"); // We can rely on the Exception class to print a message
  }
  try {
    this.lock();
  } catch (Basic_05_LockedException e) {
    System.err.println("Locked!");
  }
}

// Technically correct, but I would suggest passing parameters
public class Basic_05_LockedException extends Exception {
  public Basic_05_LockedException() {
    super(); // we'd like to know more when seeing an error
  }
}

// Works (and got full marks), but needs to throw to super
class Basic_05_LockedException extends Exception {
  public Basic_05_LockedException(String locked) {}
}
// Works (and got full marks), but needs to throw to super
public class Basic_05_LockedException extends Exception {}

// Technically works, but typically inline styles 
// are not what we're shooting for in a design course
Exception Basic_05_LockedException = new Exception();
public void open() throws Exception {
  if (locked == true){
    throw Basic_05_LockedException;
  }
  open = true;
}
```
#### Example mistakes

```.java
public class Basic_05_LockedException extends Throwable{
  public Basic_05_exception(int a, int b){ // Unsure where the ints are from
    if (locked == true) {                  // where does `locked` come from?
      System.out.print("Locked")           // you can rely on super for this
    }
    return open = true;                    // if you were using a return value
                                           // you could just write `return true`
                                           // `open` doesn't exist as a variable 
  }
}
```
Created an exception, but didn't throw to super also, many syntax and logic problems. Parameters are declared and not used, the return value is undefined. It looks like the author may have a few misunderstandings to work on which could be remedied by the practices suggested above.

```.java
public void open() {
  if(this.locked) {
    try {
      throw new Basic_05_LockedException(); // only need this line
    } catch (Basic_05_LockedException e) {
      throw new RuntimeException(e);
    }
  }
  this.open = true;
}
```
Defeats the point of an exception by catching the exception in the same place it throws the exception.

```.java
public class Basic_05_OpenException extends Exception {
  boolean locked;
  boolean open;
  public void lock() {
      if (open == true) {
          try {
              throw new Basic_05_OpenException();
          } catch (Basic_05_OpenException e) {
              throw new RuntimeException(e);
          }
      } else {
          locked = true;
      }
  }
}
```
The logic from method shouldn't be in the Exception, that should be handled by the throwing class.

#### Example remedies
Most people who got something wrong about this question need practice with `try..catch`. Set up a system of methods within a class where some methods throw and other methods catch the exceptions. Try to predict why the above incorrect code is incorrect, then run it in a `main` method to confirm.

### Basic 06
This tested your ability to cover all conditions of a method with appropriate tests. However, I may have asked this in too confusing of a way. There was enough variation on this question that I accepted any reasonable answer, even if not entirely correct. The expected answer would have addressed the following conditions:
- Door is locked and open
- Door is locked and closed
- Door is unlocked and open
- Door is unlocked and closed

The way to approach designing tests like this is to make a truth table for your conditions and do a full cross. Few to no people used `assertThrows`, which can be used to address the conditions where an `Exception` is thrown.

### Basic 07
This tested your ability to trace code.
```
// Correct order:

// local.add(file)
//    f.getEdited()
//    changed.add(f)
// local.push()
//  forEach:
//    remote.push(f)
//      files.add(f)
//    f.setEdited(false);
```
You could find this by tracing via clicking on method name with ctrl-click. Alternatively, you could ensure everything was properly instantiated and run in the debugger. Finally, you could trace by hand. Being able to trace code is **essential** to being an effective coder. If you are having difficulty learning how, literally print systems of classes on paper and trace the calls between methods. Alternatively, sequence diagrams are annoying, but force you to really, deeply learn code tracing. Force yourself to draw the sequence diagram for code in your project.

### Basic 08
```.java
// Correct
public class Basic_08_UIElement {
  public float x;
  public float y;
  public float width;
  public float height;
  public ArrayList<Basic_08_UIElement> elements;

  public void draw() {}
  public void move(float x, float y) {}
  public void add(Basic_08_UIElement uie) {}
  public void remove(Basic_08_UIElement uie) {}
}
```

Most mistakes were just omissions, part marks for incomplete classes or if you made a mistake in syntax that was important. For those of you who did out-of-order declarations, I didn't take off marks, but you need to get yourself into the habit of keeping your style clean. Always put your class variables on top, followed by your constructor, then the rest of the methods. Again, this is because you need to be able to debug due to the "feel" of the code, which will come from well-ordered classes. You need to start reading code like a paragraph. Discipline yourself to ALWAYS write your code with good style, and I promise you that deeper understanding will come. It's not being pedantic, it's actually training the monkey part of your brain that is very good at pattern matching. An experienced coder such as myself can debug **without reading** if the code is well-formatted.

### Intermediate 01
This question tested your ability to read and implement UML Class diagrams.
#### Example reasonable answer

```.java
public interface Feedable {
  String getContent();
}

public class Blog {
  public ArrayList<Post> posts;
  public Comment addComment(Post, User, String){}
  public Post addPost(User a, String b) {}
  public Boolean NotifyRSS(Feedable a){}
}

public class Comment implements Feedable {
  public String content;
  public Post post;
  public String getContent(){}
}

public class Post implements Feedable {
  public String content;
  public ArrayList<Comment> comments;
  public String addComment(Post a, User b, String c){}
  public String getContent(){}
}

public class RSSFeed {
  public Boolean notify(Feedable a){}
}

public class User {
  public Blog blog;
  public Comment addComment(Post a, String b){}
  public Post addPost(String a){}
}

public class ContentManager {
  private ArrayList<User> users;
  private ArrayList<Blog> blogs;
  public static void main(String[] args) {}
}
```
#### Example mistakes
Most mistakes were simply that people forgot methods, attributes, or classes. A few problems:

```.java
public class User extends ContentManager { ... }
```
This is misreading the syntax. Extends is the full line with the black outlined arrow.

```.java
public class Post extends Feedable { ... }
```
This is also misreading the syntax. Implements is the dashed line with the black outlined arrow.

#### Example remedies
Your project is the best practice. Create your class diagrams for your project and maintain them. Make sure that the code exactly matches the current UML diagram. Make sure that everyone on your team agrees that the code matches your UML diagram.

### Intermediate 02
This question tested your ability to follow sequence diagrams. 

#### Example reasonable answer
```.java

public class ContentManager {
  ArrayList<User> users;
  ArrayList<Blog> blogs;
  public static void main(String[] args) {
    User u1 = new User();
    User u2 = new User();
    u1.addPost("I am writing a blog post.");
  }
}

public class User {
  // excluding other details for tracing clarity
  Blog blog;
  Post addPost(String str){
    return blog.addPost(this, str);
  }
}

public class Blog {
  ArrayList<Post> posts;
  Post addPost(User user, String str) {
    Post post = new Post(str);
    RSSFeed rssFeed = new RSSFeed();
    rssFeed.notify(post);
  }
}

public class RSSFeed {
  notify(Feedable content) {
    content.getContent();
    return true;
  }
}
```
This is a possible trace for the sequence diagram. You'll note that there are some ambiguities and different interpretations. That's some of the difficulty of diagrams: they necessarily leave out information. I gave marks to reasonable answers that were close enough. Marks were typically lost if there were non-sensical syntax errors, e.g., method calls in the body of the class without any containing method.

#### Example remedies
Best way to practice is to write these for your project, and then check against the debugger. Or to write WITH the debugger.

### Intermediate 03
So few people attempted this that I gave full marks for anything reasonable and half marks for an incorrect but still OK attempt.

### Intermediate 04
I accepted any reasonable description of the hierarchy that included interfaces as abilities and superclasses to organize the organisms in a reasonable taxonomy. Few people did poorly.

### Intermediate 05
This tested your ability to use implements/extends according to polymorphic code.

#### Example reasonable answers

```.java
Clock implements Tickables
Timer implements Tickables

Stopwatch extends Timer
WallClock extends Clock
AlarmClock extends Clock implements Alarmables
AlarmTimer extends Timer implements Alarmables

All classes (or superclasses) have tick()
All Alarmables (or superclasses) have setAlarm()
```

#### Example Mistakes

Many people put `add` in the interface or classes which indicates a misunderstanding of the type system. `add` is a method of `ArrayList` and not of the type hiearchy in this question. Many people declared the interfaces as classes. Many people did not implement the interfaces. Many people did not put methods in the interfaces or classes as required by dependencies.

#### Example remedies
The best remedy is to practice with interfaces within the project. Even if it's not strictly the most efficient use of code space and time, declare interfaces for any classes that share a method name and signature.

### Intermediate 06
This tested your ability to implement the `Comparable` interace.

#### Example reasonable answer
```.java

public class Intermediate_06_CompableAns implements Comparable {

  private float x;
  public Intermediate_06_CompableAns(float x) {
    this.x = x;
  }

  public boolean equals(Object o) {
    if (o == null) {
      throw new NullPointerException("object reference provided in argument is null");
    }
    if (!(o instanceof Intermediate_06_CompableAns)) {
      throw new IllegalArgumentException("Cannot compare two different types of objects");
    }
    return this.x == ((Intermediate_06_CompableAns) o).x;
  }

  @Override
  public int compareTo(Object o) {
    if (o == null) {
      throw new NullPointerException();
    }
    if (!(o instanceof Intermediate_06_CompableAns)) {
      throw new IllegalArgumentException("Object is of different type, cannot be compared");
    }
    if (this.x < ((Intermediate_06_CompableAns) o).x) {
      return -1;
    } else if (this.x > ((Intermediate_06_CompableAns) o).x) {
      return 1;
    } else {
      return 0;
    }
  }

  public static void main (String[] args) {
    Intermediate_06_CompableAns a1 = new Intermediate_06_CompableAns( 0.2f);
    Intermediate_06_CompableAns a2 = new Intermediate_06_CompableAns( 0.4f);
    Intermediate_06_CompableAns a3 = new Intermediate_06_CompableAns( 0.4f);

    System.out.println("Expected : -1, Actual: " + a1.compareTo(a2));
    System.out.println("Expected : +1, Actual: " + a2.compareTo(a1));
    System.out.println("Expected : +0, Actual: " + a2.compareTo(a3));
    Integer wierd = 12;

    try {
      a1.compareTo(wierd);
    } catch (IllegalArgumentException e) {
      System.out.println("compared two different objects");
    }

    try {
      a1.compareTo(null);
    } catch (NullPointerException e) {
      System.out.println("object reference was null");
    }

  }
}
```

#### Example mistakes
The most common mistakes were simply missing content: either the examples in main, throwing exceptions, or throwing the wrong exceptions.

#### Example remedies
It's likely that people who threw the wrong exceptions need to practice specifically with exceptions. They can seem like this super secret other kind of thing, but they're just classes. If you're having a hard time differentiating, write down the meaning of each exception in plain English. Then try defining and throwing your own.

### Advanced 01
This question tested your ability to follow the singleton design pattern.

#### Example reasonable answers
Most people got correct, and you can reference on Refactoring Guru, so I'll leave the correct implementation to their notes.

#### Example mistakes
Most mistakes were about testing the Singleton, rather than the Singleton itself. This is why I included this as a TODO: it's important to demonstrate the Singleton to show that you understand the idea of unique instances.

```.java
public static Advanced_01_Server getInstance(){
  if (server1 == null){
      server1 = new Advanced_01_Server();
      Random myRandom = new Random();
      uid = myRandom.nextInt();
      connected = false;
  }
  return server1;
}
```
Technically correct, but you should actually put most of the instantiating logic in the constructor still. `getInstance` is just a way to hide the constructor.

```.java
public void testOne(){
  Advanced_01_Server s1 = Advanced_01_Server.getInstance();
  s1.setUid(106);
  assertEquals("106",s1.getUid());
}
```
This doesn't test the uniqueness of the server

```.java
void SingTest03() {
  while (test.getUid() == test2.getUid()) {
    test.reroll();
    test2.reroll();
  }
  Assertions.assertFalse(test.getUid() == test2.getUid());
}
```
For a singleton, this is like running while(true). This contradicts the last line.

```.java
private static Advanced_01_Server instance = null;
```
Small mistake: don't need to set it null to begin with.

#### Example remedies
The biggest problem with Singleton is treating it as a pattern with no meaning. Therefore, the best practice is to find concrete examples of where a Singleton becomes useful. Implement a Singleton in your project for something that you want only one of, and then start practicing with calling `getInstance` in repeated methods. For example, if you have a single `Player`, you may want to call `getInstance` inside draw to demonstrate the usefulness of this pattern.

### Advanced 02
This question tests your ability to create and use iterators.

#### Example strategy for solving
The basic strategy for Advanced 02 could take three forms. One would be making the LinkedList a doubly-linked list:
```.java
Node {
  Node next;
  Node prev;
  String value;
  String label;
}
```
Then, you can run the same iteration algorithm forwards or backwards, just switching out the `next` or `prev` and keeping track of the `head` or `tail` of the list.

The other strategy is to rely on another data structure. For example, you could run the iterator as follows:

```.java
Node head;
ArrayList<Node> nodes = new ArrayList<Node>();
nodes.add(head)
Node curr = head;
while (curr.next != null) {
  curr = curr.next;
  nodes.add(curr);
}
```

Now you can keep track of the current index of the iterator from either side.

```.java
int curr = 0;
hasNext() {
  return curr < nodes.size();
}

next() {
  Node temp = nodes[curr];
  curr = curr + 1;
  return temp.value;
}
```

#### Example mistakes
The most common mistakes were simply not attempting the backwards iteration. I won't include many examples here because those who did attempt it generally got it correct.

#### Example remedies
Iterators are always hard since it seems like you're learning something useless that comes built in with a lot of collections. However, once you start building your own collections with different underlying topologies and needing arbitrary orderings, the utility of knowing about them becomes more obvious. If you really, really, really want to learn them well, define an arbitrary arity graph:

```.java
Node {
  List<Nodes> siblings;
}
```

If you can figure out how to iterate through this using different search metrics, you can be sure that you understand iterators deeply. This would be because there would be no natural ordering and it wouldn't make sense to use a `ArrayList`.

### Advanced 03
This question tests your ability to implement the Composite pattern.

#### Example reasonable implementation

```.java
public class Document implements TextElement {
  public ArrayList<TextElement> items;

  public Document() {
    this.items = new ArrayList<TextElement>();
  }

  public void add(TextElement item) {
    items.add(item);
  }

  public void remove(TextElement item) {
    items.remove(item);
  }

  @Override
  public void print() {
    for (TextElement item : items) {
      item.print();
    }
  }
}

public class Paragraph implements TextElement {
  public String content;

  public Paragraph(String content) {
    this.content = content;
  }

  @Override
  public void print() {
    System.out.println(content);
  }
}

public interface TextElement {
  void print();
}
```

#### Example mistakes
```.java
public class Document implements TextElement {
  ArrayList<Paragraph> paras = new ArrayList<Paragraph>();
  ArrayList<Document> docs = new ArrayList<Document>();
```
The composite pattern allows this to be just one ArrayList using polymorphism. In fact, this complicates the pattern and renders it partially useless. You can fix this by having the print statement iterate over both lists, but there's no point.

```.java
class Paragraph {
class Document {
```
Implementing the interface is key to this design pattern. If the classes do not use the `implements` keyword, they won't be able to use polymorphism.

### Advanced 04
This question tests your ability to create tests BEFORE writing the classes themselves. There was a very wide variety of answers for this one, so I gave marks to any reasonable attempt.

### Advanced 05
This question tests your ability to use nested iterators.

#### Example reasonble answer
```.java

public class GridIterator implements Iterator {
  ArrayList<GridItem> values = new ArrayList<GridItem>();
  int index;

  public GridIterator(){
    index = 0;
  }

  public void iterate(Grid g){
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        if (g.grid[i][j] == null){
          j = 5;
        } else {
        values.add(g.grid[i][j]);
        index++;}
      }
    }
  }

  @Override
  public boolean hasNext() {
    return index < values.size();
  }

  @Override
  public Object next() {
    if (hasNext()){
    index++;
    return values.get(index - 1);
    }
    return null;
  }

}

```
Good solution, some magic numbers. The strategy is what should be paid attention to here: the list is being flattened out by adding to a new array this is the simplest iterator strategy which is actually quite effective.

#### Example mistakes
```.java
// Close, but doesn't work
public class Grid implements Iterable {
  String[][] grid;

 public Grid() {
   grid = new String[5][5];
 }
 
 @Override
 public Iterator iterator() {
   // Streams over one array, but not both
   return (Iterator) Arrays.stream(grid).iterator(); 
 }

 public static void main(String[] args) {
   Grid grid = new Grid();
   for (int i = 0; i < 5; i ++) {
     for (int j = 0; j < 5; j++) {
       grid.grid[i][j] = String.format("%d, %d", i, j);
     }
   }
   Iterator it = grid.iterator();
   while(it.hasNext()) {
     System.out.println(it.next().toString());
   }
 }
}

```
This sets up the 2D array, but the iterator itself is only over one of the two. You would need to set up another iterator for each element of the outer iterator.

Most mistakes simply iterated over one of the two arrays.

#### Example remedies
The HashMap lab gives a detailed look into 2D iteration. If you can master HashMap iteration from scratch, you'll understand 2D iteration.

### Advanced 06
This tests your ability to set up a Comparable for a non-obvious ordering.

#### Example correct implementation
```.java
@Override
  public int compareTo(Object o) {
    if (o == null) {
      throw new NullPointerException();
    }

    if (o.getClass() != this.getClass()) {
      throw new ClassCastException();
    }

    Advanced_06_Comparable obj = (Advanced_06_Comparable) o;

    if (this.equals(o)) {
      return 0;
    }

    double thisTotal = Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2);
    double objTotal = Math.pow(obj.x, 2) + Math.pow(obj.y, 2) + Math.pow(obj.z, 2);

    if (thisTotal > objTotal) {
      return 1;
    }
    return -1;
  }
```

#### Example mistakes

```.java
public int compareTo(Object o) throws ClassCastException {
  if(equals(o) == true){
    float distance = (float) (Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    if(distance == (float)o) {
```
A surprising number of people made the mistake above where they were casting the entire object to a float. Although Java allows arbitrary casts, this is sort of a meaningless statement. For example, what would it mean to cast the following to a float?

```.java
Document {
  ArrayList<String> paragraphs;
}
```
There isn't really a meaningful translation between a float and an ArrayList of String. This is essentially the same kind of mistake as is shown above.

#### Example remedies
The way to master this is to find a picture for what you're trying to compare. Ask yourself: is there an obvious or natural ordering, and then how can I express that in terms of the object properties? Think about things that can be ordered and cannot be ordered, and if they can, along which dimensions can they be ordered? An example might be billard balls. You could order them in terms of their number, but you could also decide to arrange them according to their place on the rainbow. Both would be valid orderings on different dimensions/attributes.
