'use strict';
// Write a program that calculates the sum and the average from 1 to a given number.
// Example input: 5
// Example output: Sum: 15, Average: 3
var givenNumber = 5;
var sum = 0;
for (var i = 1; i <= givenNumber; i++) {
    sum += i;
}
console.log("Sum: " + sum + ", Average: " + sum / givenNumber);
