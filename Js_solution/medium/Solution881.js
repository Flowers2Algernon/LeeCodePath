/**
 * @param {number[]} people
 * @param {number} limit
 * @return {number}
 */
var numRescueBoats = function(people, limit) {
    var i=0;
    var j = people.length-1;
    var boats = 0;
    people.sort(function (a, b) {return a - b; });
    while (i<=j){
        if (people[i]+people[j]<=limit){
            i++;
        }
        j--;
        boats++;
    }
    return boats;

};