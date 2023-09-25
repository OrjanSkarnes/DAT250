# DAT250: Experiment Assignment 3 Report

## Technical Problems Encountered

While working on this assignment, I faced no significant issues expect setting up the connection, thanks to the straightforward MongoDB Java Driver.

## Experiment 1: CRUD Operations

The CRUD operations were performed in the `CrudOperations` class. The code initializes a clean database and collection, and then performs the CRUD operations:

- **Create**: Inserted four documents into the collection.
- **Read**: Read the first document from the collection.
- **Update**: Updated the age of the document with the name "John".
- **Delete**: Deleted the document with the name "John".

## Experiment 2: Aggregation

The aggregation logic is implemented in the `CollectionOperations` class. The code performs an aggregation that calculates the average age for each occupation using the `$group` and `$avg` aggregation stages.

The aggregation results are saved into a new collection named `average_age_by_occupation`.

### Why is Aggregation Useful?

Given that I am a fullstack developer working on TV2 Play, data aggregation can be particularly useful. For instance, understanding the average age of users per occupation can help in segmenting the audience for better content recommendations or targeted promotions.

## Code Structure

The code is organized into separate packages and classes for clarity and ease of maintenance:

- `CrudOperations` handles CRUD functionalities.
- `CollectionOperations` takes care of the aggregation operation.
