/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var largestLocal = function(grid) {
    let result = Array(grid.length-2).fill(0).map(()=>Array(grid.length-2));
    for (let i=0;i<result.length;i++){
        for (let j=0;j<result[0].length;j++){
            result[i][j] = findTheMaxNumber(i,j,grid);
        }
    }
    return result;
};

var findTheMaxNumber = function(i,j,grid){
    var manNumber = 0;
    for (let k=i;k<=i+2;k++){
        for (let m = j;m<=j+2;m++){
            manNumber = Math.max(manNumber,grid[k][m]);
        }
    }
    return manNumber;
}