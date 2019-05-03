// Write a program which takes a number from user at runtime and then prints it factorial

import * as readline from 'readline';

let inputVal = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
// let val: number;

inputVal.question('Please enter a number: ', (val) => {
    
     let factorial: number = 1;
     for (let i = 1; i <= parseInt(val); i++) {
         factorial = factorial * i;         
     }
     console.log(factorial);     
inputVal.close();
});