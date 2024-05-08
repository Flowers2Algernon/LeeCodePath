/**
 * @param {number[]} score
 * @return {string[]}
 */
var findRelativeRanks = function(score) {
    let copy = score.slice();
    copy.sort(function (a, b) {return a-b})
    var n = score.length;
    let res = new Array(n);

    for(var i =0;i<n;i++){
        var rank = binarySearch(copy,score[i]);
        if (rank===n-3){
            res[i] = "Gold Medal";
        }else if(rank===n-2){
            res[i] = "Silver Medal";
        }else if(rank===n-1){
            res[i]= "Bronze Medal";
        }else {res[i]=String(n-rank)}
    }
    return res;
};

var binarySearch = function(arr,intNumber){
    var low = 0;
    var high = arr.length-1;

    while(low<=high){
        var mid = (low+high)>>1
        var midVal = arr[mid]

        if (midVal<intNumber){
            low = mid +1;
        }else if (midVal>intNumber){
            high = mid -1;
        }else return mid;
    }
    return -(low+1);
}