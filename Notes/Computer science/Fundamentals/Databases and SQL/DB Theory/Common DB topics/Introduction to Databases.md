# Introduction to databases

The world today is overloaded with information, and so are we. How do you keep important information safe and sorted? You may simply hope you neither forget nor confuse anything, but it's better to write it down or save it on your device. So you have it on your computer or phone, and the program keeps the information safe. While the program is active, it "remembers" everything. However, quitting the program may result in losing all that information. That's why it's better to keep the data using more sophisticated tools.

The challenge is to navigate a huge and complex web of information and ensure everything important is safe and organized: a task that **databases** handle well.

## 1. Database

A **database** is a collection of data that is specifically organized for rapid search and retrieval processed by a computer.

The difference between a database and a usual file is that a file may be structured or not, but a database must have a specific structure. For example, you can create a file with a to-do list:

![das](https://ucarecdn.com/83823a8e-3c7e-4657-9a4e-e136d7dbb0a6/)

Obviously, we'd say that this file has some kind of a structure, but from a computer's perspective, it's still a plain file, until you write a program that manages data in it. Usually, the information in databases is compressed and stored as binaries rather than plain text, so it's clear that this kind of structure is meant for computers, not humans.

Unlike us, computers can easily understand the binary format of data, but what allows them to read and write it correctly? It is a program called **Database Management System**, which controls the data in a database.

## 2. Database Management System

A Database Management System (**DBMS**) is a type of software that allows users to define, create, and control data.

The DBMS can optimize queries and retrieve data from а database in an optimal way. It is a mediator between the user and the database, which means that users can work with it through the interface of the DBMS. In addition, it can also help isolate data from the users.

Another goal of this software is to help people work with different types of databases without exposing their actual differences.

![das](https://ucarecdn.com/308c3786-605b-4dfe-8c84-0178b0d1fb03/)

Most database management systems have pretty good descriptions and tutorials on their websites. There are also specific languages that you need to learn to start working with them, but if you know some programming languages, you can work with a database with their tools instead.

> Although it sounds like all databases have different syntax, most of them actually implement common standards. Almost all relational databases use the SQL standard, so you can apply the same commands in different DBMSs. 


## 3. Access to data

At this stage, you may still have many questions about how to use databases. You have to learn a new language to update and select the data, which can be time-consuming. Why not use plain files instead?

Of course, you can store the files locally, but as they grow in number, you won't be able to find information quickly. Databases provide **schemas** and **metadata** that allow for a quick search of the data needed.

> A schema describes how you organize the data. Metadata holds structural and statistical information.

If you want to access your data from multiple devices, most systems provide a convenient way to work with them online.

To provide restricted access to another person, some management systems use simple login/password authentication, while some provide more powerful instruments. With their help, you can grant access to a limited amount of data for each user.

![das](https://ucarecdn.com/12a8b5fb-e0ef-4506-b8f6-ab2e98d71b83/)

If you still are not convinced how great the DBMSs are, let's look at what else they can do for you.

## 4. Data consistency

One of the best features of databases is their ability to keep and restore data correctly. It doesn't mean that a DBMS knows how to be correct, but once you define the rules with the configuration or schema, you can be sure that nothing will break these rules. The DBMS can provide you with formats for your data. You can also set up all the tests and constraints that you want to have.

If several people have simultaneous access to the same data, there may be a problem. Updates in files usually follow the "last save wins" rule, which leads to a conflict of updates. For example, if someone decides to contribute to your to-do list, then following the “last changes saved” file update rule, you may lose the notification you just created and miss the football game you have scheduled for tomorrow night. Meanwhile, databases isolate different users and can be configured to resolve conflicts between their updates.

There's another good thing about databases. When a usual file becomes corrupted and cannot be opened, you've lost your data forever. Using the DBMS instead, you can make backups and then restore the data and continue your work.

> Of course, you can emulate all of these operations and develop your own DBMS, but first, try to work with the existing solutions. 

## 5. Conclusion

There is a lot to do before you start working with databases. No pain, no gain, and here you can actually gain a lot.

With databases you can:

- Store, retrieve and update data;
- Get metadata;
- Access a database remotely;
- Restrict accesses to data;
- Make concurrent updates;
- Recover to some point in time;
- Check the rules for data consistency automatically.

In a data-driven world, this kind of functionality is golden. Welcome to the world of new opportunities and good luck with exploring databases!
