private int binarySearch(String keyValue, myList){
	int low = 0;
	int high = myCount - 1;
	int middle;
	
	while(low <= high){
		middle = (low + high0 / 2;
		if(keyValue.equals(myList[middle].getName())){
			return middle;
		}
		else if(keyValue.compareTo(myList[middle].getName()) < 0){
			high = middle - 1;
		}
		else{
			low = middle + 1;
		}
	}
	return -1;
}