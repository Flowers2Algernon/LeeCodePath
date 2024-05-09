/**
 * @param {number[]} happiness
 * @param {number} k
 * @return {number}
 */
var maximumHappinessSum = function(happiness, k) {
    var sum = 0;
    var numbers = happiness.sort((a,b)=>{return a-b});
    var length = happiness.length;
    for(var i = 0;i<k;i++){
        if (numbers[length-i-1]-i>=0){
            sum += numbers[length-i-1]-i;
        }else sum += 0;
    }
    return sum;
};