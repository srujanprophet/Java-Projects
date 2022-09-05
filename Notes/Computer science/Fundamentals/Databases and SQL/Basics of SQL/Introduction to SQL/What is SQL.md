# What is SQL

**SQL (Structured Query Language)** is a [domain-specific programming language](https://www.jetbrains.com/mps/concepts/domain-specific-languages/) designed to handle data in tables. It was developed in the 1970s. To this day, SQL-like interfaces are very popular in various data management systems, not only the ones based on tables!

Understanding such a popular language is likely to be very useful. If you are a software engineer, it's good to learn it because many systems store and process business data via services that support SQL. For example, the backend of an insurance company's information system may use SQL to extract and update data about their clients.

We will begin by looking at a practical example of how you can use SQL to calculate statistics. Then we will examine what the letters in the name SQL stand for.

## 1. Calculating statistics

SQL makes aggregating data and calculating statistics easier. Suppose you need to evaluate changes in the popularity of the name Jessie between 1920 and 2000 (inclusive) based on census data. Using SQL, you can complete this task with only 11 lines of code! You might not understand the code below yet, so try to read it as a sentence written in English. It selects records about individuals named `'Jessie'` who were born `BETWEEN 1920 and 2000`. It groups them by `year` and `gender`, counts the number of records in each group via `COUNT(*)`, and generates a table with columns named `year`, `gender`, and `cnt`. It also sorts the table by `year` and `gender` in descending order.

The "census" table:

| id | year | name | ... | gender |
| -- | ---- | ---- | --- | ------ |
| 1 |	2000 |	Jessie | 	... | 	M |
| 2 |	1880 |	Kelly |	... |	F |
| 3  |	1985 |	Willie |	... |	M |
| 4 |	2018 |	Taylor |	... |	M |
| ... | 	... | 	...  |	... | 	... |
| N |	1946  |	Jessie 	| ... | 	F |

The query:

```sql
SELECT
  year, gender, COUNT(*) as cnt
FROM
  census
WHERE
  year BETWEEN 1920 and 2000
  AND name = 'Jessie'
GROUP BY
  year, gender
ORDER BY
  year, gender DESC
```

The query evaluation result:

| year | 	gender | 	cnt |
| ---- | ---- | ---- |
| 1920 | 	M | 	1590 |
| 1920 |	F |	3329 |
| ... |	... |	... |
1960 |	M |	935|
1960 |	F |	509|
... |	... |	...|
2000 |	M |	533|
2000| 	F 	|710|

SQL is the standard [data manipulation language](https://www.techopedia.com/definition/1179/data-manipulation-language-dml) used by data-driven companies around the world. There is a lot to gain from understanding it and plenty to learn. The best place to start is with the basics, so let's now look at what each letter in the name SQL means to find out what exactly we're dealing with! 

## 2. S is for structured

SQL is a language used to extract and update data **structured** as tables. This kind of data appears in various application areas, such as Excel spreadsheets containing accounting data, or census statistics in Google BigQuery. Another example is an online store that utilizes a special software system to store and access tables, known as a **Relational Database Management System (RDBMS)**. These can help to process information on goods, orders, and customers.

SQL is intended for use with tables that have a particular structure:

![das](https://ucarecdn.com/33e54fe7-c08c-4d0c-acaa-50e8d02ebd65/)

The tables contain **rows** and **columns**. Each row is an object or entity that has a set of properties or attributes. For instance, the third row contains data about Willie, a man born in 1985.

Data is often organized into a set of tables, known as a **database**. Then it's possible to access these tables using their individual names. For example, in an online store's database, a table called `Customers` would probably contain general information about the company's customers: their names and contact details. The `Orders` table would store information about the specific orders they place: customer names, goods, payment details.

## 3. Q is for Query

SQL is a programming language with a large set of data processing features. It is **declarative**, meaning that a statement written in SQL is a **query** that tells the system what should be done or evaluated but doesn't specify how.

In the next example, a query extracts all rows and columns from the table `Census`:

`SELECT * FROM Census;`

Symbol `*` is used to select all the records from the table.

It's necessary to end each SQL statement with a semicolon, also known as **statement terminator**. Else, there will be an error. Semicolon may be omitted only if you make one query at a time, but it is a good practice to always put it at the end of your query.

Keywords such as `SELECT` are not case sensitive in the SQL language. They can be in any letter case but are often written in all caps to make them more visible.

## 4. L is for Language

You can read the simple query in the above example as "select everything from census." SQL was designed to be as similar as possible to a natural **language**. Its declarative nature helps to hide the operation's complexities, letting the user define what is required in a relatively straightforward way. The system then analyses the query, chooses the control flow, and executes it.

SQL was originally adopted as a standard by the [American National Standards Institute (ANSI)](https://www.ansi.org/) in the 1980s. There are many dialects implemented by software vendors that support it. Dialects are based on the ANSI standard but have some technical differences. For example, they might process dates or strings differently. This means that SQL queries written in different dialects are not compatible. However, once you know the SQL basics, it's possible to adapt to dialects fairly easily, like with written American and British English.

MySQL syntax has been used in this topic and elsewhere on this website, so the examples may not be compatible with other SQL dialects.

## 5. Conclusion

SQL is a domain-specific, declarative language used when working with structured data.

You have learned that with data organized in tables, you can write SQL queries to select rows and columns according to various criteria, create groups of entities, calculate statistics, and much more!
