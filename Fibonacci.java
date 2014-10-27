class Fibonacci extends ReturnFunction {
	
	@Override
	int getNext(){	
		N = N1 + N2;
		N1 = N2;
		N2=N;
		counter++;
		return N;
	} //getNext() ends
	
} //class ends