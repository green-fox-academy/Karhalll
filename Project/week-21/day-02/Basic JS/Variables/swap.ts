'use strict';

// Swap the values of these variables
let numberToSwap1: number = 123;
let numberToSwap2: number = 526;

let numberHolder: number = numberToSwap1;
numberToSwap1 = numberToSwap2;
numberToSwap2 = numberHolder;

console.log(numberToSwap1);
console.log(numberToSwap2);