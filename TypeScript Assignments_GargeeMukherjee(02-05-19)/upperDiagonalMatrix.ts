// Write a program which prints the upper diagonal of a matrices array

let array: number[][] = [[6, 7, 8], [ 9, 10, 11], [12, 13, 14]];
console.log(array);

function upperDiagonal(array: number[][]) {
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            if((i+j)<=2)
                //printing array elements
                console.log(array[i][j]);
          }
      }        
    }


upperDiagonal(array);