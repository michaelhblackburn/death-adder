public class Sorter{
	private static int countCompares;
	private static int countAssigns;

	public Sorter(){
		countCompares = 0;
		countAssigns = 0;
	}

	public void setCountCompares(int c){
		countCompares = c;
	}

	public int getCountCompares(){
		return countCompares;
	}

	public void setCountAssigns(int a){
		countAssigns = a;
	}

	public int getCountAssigns(){
		return countAssigns;
	}

	private void swap(String[] data, int index1, int index2){
		String temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	public  void bubbleSort(String[] data){
		String[] temp = data;
		countCompares = 0;
		countAssigns = 0;
		for(int i = 0; i < data.length - 1; i++){
			for(int j = data.length - 1; j > i; j--){;
				countCompares++;
				if(data[j - 1].compareToIgnoreCase(data[j]) > 0 ){
					swap(data, j - 1, j);
					countAssigns += 3;
				}
			}
		}
	}

	public void selectionSort(String[] data){
		int leastIndex;
		countCompares = 0;
		countAssigns = 0;
		for(int i = 0; i < data.length - 1; i++){
			leastIndex = i;
			for(int j = i + 1; j < data.length; j++){
				countCompares++;
				if(data[j].compareToIgnoreCase(data[leastIndex]) < 0){
					leastIndex = j;
					swap(data, i, leastIndex);
					countAssigns += 3;
				}
				
			}
			
		}
	}

	public void insertionSort(String[] data){
	}

	public void heapSort(String[] data){
	}

	public void mergeSort(String[] data){
		mergeSort(data, 0, (data.length - 1));
	}

	private void mergeSort(String[] data, int low, int high){
		int mid = 0;
		if(low < high){
			mid = (low + high) / 2;
			mergeSort(data, low, mid);
			mergeSort(data, mid + 1, high);
			merge(data, low, mid, high);
		}
	}

	private void merge(String[] data, int low, int mid, int high){
		String[] dest = new String[data.length];
		int s1 = low;
		int s2 = mid + 1;
		int d = low;
		while((s1 <= mid) && (s2 <= high)){
			if(data[s1].compareToIgnoreCase(data[s2]) < 0){
				dest[d++] = data[s1++];
			}
			else if(data[s1].compareToIgnoreCase(data[s2]) > 0){
				dest[d++] = data[s2++];
			}
		}
		if(s1 <= mid){
			do{
				dest[d++] = data[s1++];
			}
			while(s1 <= mid);
		}
		else{
			do{
				dest[d++] = data[s2++];
			}
			while(s2 <= high);
		}
		for(int i = 0; i < data.length; i++){
			data[i] = dest[i];
		}
	}

	public void quickSort(String[] data){
		quickSort(data, 0, data.length - 1);
	}

	public void quickSort(String[] data, int low, int high){

		if(low < high){
			int pivotIndex = partition(data, low, high);
			
			if(low < pivotIndex){
				quickSort(data, low, pivotIndex - 1);
			}
			if(high > pivotIndex){
				quickSort(data, pivotIndex + 1, high);
			}
		}
	}

	private int partition(String[] data, int low, int high){
		String pivotValue = data[low];
		countAssigns++;
		
		while(low < high){
			countCompares++;
			while((pivotValue.compareToIgnoreCase(data[high]) < 0) && (low < high)){
				high--;
				countAssigns++;
				countCompares++;
			}
			if(high != low){
				data[low] = data[high];
				low++;
				countAssigns += 2;
			}
			countCompares++;
			while((pivotValue.compareToIgnoreCase(data[low]) > 0)&& (low < high)){
				low++;
				countAssigns++;
				countCompares++;
			}
			if(high != low){
				data[high] = data[low];
				high--;
				countAssigns += 2;
			}
			countCompares += 2;
		}
		data[high] = pivotValue;
		countAssigns++;
		return high;
	}
}