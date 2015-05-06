
function codecA(a, b)
{
    'use strict';
    /*jshint bitwise: false*/
    if (a & b) {
        return a + b;
    } else {
        return a;
    }
}
function codecB(a, b)
{
    'use strict';
    if (a && b) {
        return a + b;
    } else {
        return a + ',' + b;
    }
}
function codecC(a, b)
{
    'use strict';
    /*jshint eqeqeq: false*/
    return a == b;
}
function codecD(a, b)
{
    'use strict';
    return a === b;
}

codecA(1,2);
codecB(1,2);
codecC(1,2);
codecD(1,2);