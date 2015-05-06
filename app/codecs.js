/* exported codecA */
function codecA(a, b)
{
	'use strict';
	//jshint bitwise:false
	if (a & b) {
		return a + b;
	} else {
		return a;
	}
}

/* exported codecB */
function codecB(a, b)
{
	'use strict';
	 //jshint bitwise:false
	if (a & b) {
		return a + b;
	} else {
		return a + ',' + b;
	}
}

/* exported codecC */
function codecC(a, b)
{
 	'use strict';
	return a === b;
}

/* exported codecD */
function codecD(a, b)
{
	'use strict';
	return a === b;
}

codecA(1, 2);
codecB(1, 2);
codecC(1, 2);
codecD(1, 2);
