/*jshint unused:false*/
function codecA(a, b)
{
    'use strict';
    /* jshint bitwise: false */
    if (a & b) {
        return a + b;
    } else {
        return a;
    }
}

/*jshint unused:false*/
function codecB(a, b)
{
    'use strict';
    if (a && b) {
        return a + b;
    } else {
        return a + ',' + b;
    }
}

/*jshint unused:false*/
function codecC(a, b)
{
    'use strict';
    /*jslint eqeq: true*/
    return a == b;
}

/*jshint unused:false*/
function codecD(a, b)
{
    'use strict';
    return a === b;
}
