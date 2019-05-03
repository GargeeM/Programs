//  Calculate, print the addition of first 100 numbers

let sum: number = 0;
function firstHundred() {
    for (let i = 0; i < 100; i++) {
        sum = sum + i;    
    }
    console.log(sum);
}

//calling the function to view sum
firstHundred();