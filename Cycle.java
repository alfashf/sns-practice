class Cycle extends ReturnFunction {
//test
int[] series = {1, 10, 6, 11, 99};
int i=0;
int counter=series.length;
	
	@Override
	int getNext(){
		while(i<counter){
			N = (series[i]+1)%counter;
			i++;
			break;
		} //end while
		
		if(i==counter)
			i=0;
		
		super.counter++;		
		return N;

	} // getNext() ends
} //class ends
