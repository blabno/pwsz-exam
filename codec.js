 function codecA(a, b)
{
'use strict';
- if (a && b) {
+ /*jshint bitwise: false*/
+ if (a & b) {
return a + b;
} else {
return a;
@@ -21,7 +22,8 @@ codecB(2, 1);
function codecC(a, b)
{
'use strict';
- return a === b;
+ /*jshint eqeqeq: false*/
+ return a == b;
}
codecC(1,2);
function codecD(a, b)
