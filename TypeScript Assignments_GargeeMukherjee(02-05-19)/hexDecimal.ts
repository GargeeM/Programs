//  Write a program which prints the hex-decimal equivalent of a decimal number entered at runtime

import * as readline from 'readline';

let inputVal = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
// let val: number;

inputVal.question("Enter a number : ", function (answer) {
    var num = parseInt(answer);
    var num1 = "";
    while (num != 0) {
        switch (num % 16) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                num1 += num % 16;
                break;
            case 10:
                num1 += "A";
                break;
            case 11:
                num1 += "B";
                break;
            case 12:
                num1 += "C";
                break;
            case 13:
                num1 += "D";
                break;
            case 14:
                num1 += "E";
                break;
            case 15:
                num1 += "F";
                break;
        }
        num = Math.floor(num / 16);
    }
    num1 += "x0";
    var hexVal = "";
    for (var i = num1.length - 1; i >= 0; --i) {
        hexVal += num1[i];
    }
    console.log("Hexadecimal Value is: " + hexVal);
    inputVal.close();
});
