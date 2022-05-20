// JavaScript source code(intervalDay.js)
Date.prototype.intervalDay = function (that) {
    if (this > that) {
        intervalMili = this.getTime() - that.getTime();
    } else {
        intervalMili = that.getTime() - this.getTime();
    }
    var day = intervalMili / (1000 * 60 * 60 * 24);
    return Math.trunc(day);
};