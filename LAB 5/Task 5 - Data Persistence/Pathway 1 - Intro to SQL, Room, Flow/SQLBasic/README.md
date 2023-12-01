# Practice Question
Problem 1:
Write a SQL query to get the names of all parks with fewer than 1,000,000 visitors.

SELECT name FROM park
WHERE park_visitors < 1000000


Problem 2:
Write a SQL query to get the number of distinct cities in the park table

SELECT COUNT (DISTINCT city) AS distinct_cities_count
FROM park


Problem 3:
Write a SQL query to get the total number of visitors to parks in San Francisco.

SELECT SUM(park_visitors) AS total_visitors_in_sf
FROM park
WHERE city = 'San Francisco'


Problem 4: 
Write a SQL query to the top 5 park names along with their visitor count that had the most visitors, in descending order.

SELECT name, park_visitors FROM park
ORDER BY park_visitors DESC
LIMIT 5


# SQL Basics

This folder contains the source code for the SQL Basics codelab.

# Introduction

The SQLBasics project is a single screen app that simply instantiates a Room database. Rather than interacting with the database through Kotlin code, you'll learn the fundamentals of SQL, including writing queries to get data, as well as how to insert and delete from a database.

When the app is running, you'll be able to send SQL commands to the database via Android Studio's Database Inspector.

# Pre-requisites
* Experience navigating an Android Studio Project

# Getting Started
1. Install Android Studio, if you don't already have it.
2. Download the sample.
3. Import the sample into Android Studio.
4. Build and run the sample.