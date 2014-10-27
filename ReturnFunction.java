class ReturnFunction {

int N=0;
int N1=0;
int N2=1;
int counter=0;

	void reset(){
		N=0;
		N1=0;
		N2=1;
		counter=0;
	} //reset() ends
	
	int getNext(){
		counter++;
		return N;
	} //getNext() ends
	
	int getCounter(){
		return counter;
	} //addCounter() ends
	
} //end class