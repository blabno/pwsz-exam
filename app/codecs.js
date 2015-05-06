function codecA(a, b)
{
	if (a && b) {
		return a + b;
	} else {
		return a;
	}
}


function codecB(a, b)
{
	if (a && b) {
		return a + b;
	} else {
		return a + ',' + b;
	}
}

function codecC(a, b)
{
	return a === b;
}

function codecD(a, b)
{
	return a === b;
}

codecA(1, 2);
codecB(1, 2);
codecC(1, 2);
codecD(1, 2);
