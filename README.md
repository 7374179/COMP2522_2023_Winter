# Lab 12

For today's lab, you're going to set up your database. I've included individual instructions on how to access a free MongoDB instance and example code to get you started. Even if your group has already set up a database, this will be a helpful exercise to get you rolling on concurrency and asynchronous I/O.

## TODO 1: Sign up for a free MongoDB account
Go to [MongoDB](https://www.mongodb.com/) and sign up for a Cloud Atlas instance. You can follow the "Start Free" link. Once you have an account, navigate to the Database Deployment panel and select "Build a Database". Choose the free M0 deployment on the far right.

![image](https://user-images.githubusercontent.com/3506567/226447324-8b31650b-d628-4203-aee2-c9e359d0048b.png)

Now create a username and password. This should be different from your account username and password.
![image](https://user-images.githubusercontent.com/3506567/226447903-baf02032-b1ba-419b-b036-51f90bae960f.png)

Add whichever IP you'd like to connect from. I put `0.0.0.0` because I'm OK with anyone in the world accessing my database.

![image](https://user-images.githubusercontent.com/3506567/226448181-27fb4f6f-68aa-4fa0-a1a8-d2b3b02a651a.png)

Finish and close the setup.

## TODO 2: Connect to your database
On the main deployment page, you should now see your database and a "Connect" button which you should press now.

![image](https://user-images.githubusercontent.com/3506567/226448543-b3220819-b89e-4ad8-a034-42efc9d81326.png)

Then click "Connect your application". Select the Java driver code and copy it into a `main` method somewhere in your project or personal repo.

![image](https://user-images.githubusercontent.com/3506567/226448776-1ffd8aa5-6d7c-4533-8068-ecad49b7dbe9.png)

Note that you have to replace `<password>` with your password.

Before you can run this, you'll have to add a line to your `build.gradle` and rebuild your gradle.

```
dependencies {
    <other dependencies>
    implementation 'org.mongodb:mongodb-driver-sync:4.9.0'
}
```

Now try running. If it works, great! Otherwise, talk to Paul.

## TODO 3: Initialize a collection, insert a document, and find a document.

Now you are ready to start using your database. Start by initializing a new collection:

`database.createCollection("students");`

Note that each new collection needs a new name, so you should only have to run this once.

Now add a document into the database:

```.java
Document document = new Document();
document.append("name", "Ram");
document.append("age", 26);
document.append("city", "Hyderabad");
```

This is going to create a BSON (which is similar to JSON) object that looks like this:

```
{
  "name": "Ram",
  "age": 26,
  "city: "Hyderabad"
}
```

Insert it into your database:

`database.getCollection("students").insertOne(document);`

Now we're going to test if it's really there.

`Document find = database.getCollection("students").find(eq("name", "Ram")).first();`

This is grabbing the first document that has the field "name" that equals "Ram". Print it to confirm:

`System.out.println(find);`

## TODO 4: Create a variable, async put function
Take the above code and turn it into a `put` method which takes a `key` and `value`. Then turn it into an async method through one of the many ways we've demonstrated creating Threads in lecture. You can now call this from anywhere you want and have your database write be non-blocking.

## TODO 5: Implement the above in your project
If you haven't yet, implement this same thing for your project. Save some portion of your game state and write it to your database. Then, when you've figured out what you want to write, figure out what you might want to read. Also make this non-blocking by creating threads.

## TODO 6: Prep for demo and code review
Next week will be the code reviews. I'll explain more in lecture, but you will have to have enough of your own code written at this point that someone can give you feedback on it. It doesn't need to be done, but it needs to be pretty well finished. Next week, you'll be writing reviews on each other's code.

