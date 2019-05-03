// Write a program in typescript which prints the sum of individual digits of a number entered at runtime

import * as readline from 'readline';

let inputVal = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

inputVal.question('Please enter a number: ', (value) => {
     
     let digitsArray: any[];
     let sum: number = 0;
     digitsArray = (value).split('');
     for (let i = 0; i < digitsArray.length; i++) {
         sum = sum + parseInt(digitsArray[i]);    
     }
     console.log(`Sum of digits of the given number is ${sum}`);       
     inputVal.close();
}); 