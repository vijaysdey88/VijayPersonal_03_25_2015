function Spinner() {
	var counter = 0;
	this.increment = function() {
		counter++;
	};
	this.decrement = function() {
		counter--;
	};
	this.getCount = function() {
		return counter;
	};
}
