// Write a program which take a key from user at runtime and then checks whether it exists in the tuple. If it is found, prints it's corresponding value

import * as readline from 'readline';

let inputVal = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let array: number[] = [56, 78, 94, 85, 34, 62, 90, 21, 67];

inputVal.question('Please enter a number: ', (value) => {
     
     for (let i = 0; i < array.length; i++) {
         if(array[i] == parseInt(value))
             console.log("Key found! Corresponding value in tuple: " + array[i+1]);
     }     
     inputVal.close();
}); 