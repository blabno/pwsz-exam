function codecA(a, b)
{
    'use strict';
    if (a && b) {
        return a + b;
    } else {
        return a;
    }
}
codecA(1,1);
function codecB(a, b)
{
    'use strict';
    if (a && b) {
        return a + b;
    } else {
        return a + ',' + b;
    }
}
codecB(2, 1);
function codecC(a, b)
{
    'use strict';
    return a === b;
}
codecC(1,2);
function codecD(a, b)
{
    'use strict';
    return a === b;
}
codecD(1,2);