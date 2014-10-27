class Sum extends ReturnFunction{

	@Override
	int getNext(){
		N = N+1;
		counter++;
		return N;
	} // getNext()
} //class ends