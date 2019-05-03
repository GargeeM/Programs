//  Write a program which takes a string from user at runtime and checks, prints the number of repeating vowels in the string

import * as readline from 'readline';

let inputVal = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let a: number = 0;
let e: number = 0;
let i: number = 0;
let o: number = 0;
let u: number = 0;

inputVal.question('Please enter a String: ', (userString) => {
     
     let array: string[] = userString.toLowerCase().split('');
     for (let j = 0; j < array.length; j++) {
        if (array[j]=='a')
            a++;
        if (array[j]=='e')
            e++;
        if (array[j]=='i')
            i++;
        if (array[j] == 'o')
            o++;
        if (array[j] == 'u')
            u++;        
     }

     console.log(`a occured ${a} times.\ne occured ${e} times.\ni occured ${i} times.\no occured ${o} times.\nu occured ${u} times.\n`);
          
     inputVal.close();

});