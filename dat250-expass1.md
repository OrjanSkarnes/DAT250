# DAT250: Software Technology Experiment 1

## Introduction

This report covers the various aspects and challenges encountered while setting up the software development environment and working on a Java and Docker project. Since I have a few years of experience in the field, including working with frontend development and streaming services, the assignment was not particularly challenging for me. However, I believe the task is incredibly relevant for anyone pursuing a computer science degree, and I certainly enjoyed working on it.

## Validated

Validated by running the gradle commands you listed in this markdown

### Technical Problems and Solutions

#### Issue: Simplifying Java Code for Unit Conversion

- **Problem**: The initial Java code for unit conversion was cluttered with multiple `if-else` statements.

- **Solution**: Considered using a `Map` for lookup but ended up using a `switch-case` statement to make the code cleaner and more efficient.

### Issue: Double conversion of units in the Java code

- **Problem** The initial approach required converting units twice: once to meters and then to the desired unit.

- **Solution** Refactored the code to perform a single conversion, reducing computational overhead.

### Issue: Not to much experience with writing Dockerfile 

- **Problem** I have not written a Dockerfile before, and didnt know the java version i was using.
- **Solution** Created a Dockerfile to build and run the Java application with Amazon Corretto-17 as the base image.

## DockerHub
The Docker container for this project is published and can be found [here](https://hub.docker.com/repository/docker/acrosight/dat250/general).