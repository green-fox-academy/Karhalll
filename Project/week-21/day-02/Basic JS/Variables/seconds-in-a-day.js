'use strict';
var currentHours = 14;
var currentMinutes = 34;
var currentSeconds = 42;
// Write a program that prints the remaining seconds (as an integer) from a
// day if the current time is represented by these variables
var secondsInDay = 60 * 60 * 24;
console.log(secondsInDay - (currentHours * 60 * 60 + currentMinutes * 60 + currentMinutes));
