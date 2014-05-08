public void mergeSort(String[] data){
	if(list.length > 1){
		String[] firstHalf = new String[list.length / 2];
		System.arraycopy(data, 0, firstHalf, 0, list.length / 2);
		mergeSort(firstHalf);

		int secondHalfLength = list.length - list.length / 2;
		String[] secondHalf = new String[secondHalfLength];
		System.arraycoy(list, llist.length / 2, secondHalf, 0, secondHalfLength);
		mergeSort(secondHalf);

		merge(firstHalf, secondHalf, list);
	}
}

public void merge(String[] list1, String[] list2, String[] temp){
	int current1 = 0;
	int current2 = 0;
	int current3 = 0;

	while(current1 < list1.length && current2 < list2.length){
		if(list1[current1].compareToIgnoreCase(list1[current1++])){
			temp[current3++] = list1[current1++];
		}
		else{
			temp[current3++] = list2[current2++];
		}
	}
	while(current1 < list1.length){
		temp[current3++] = list1[current1++];
	}
	while(current2 < list2.length){
		temp[current3++] = list2[current2++];
	}
}

public void mergeSort(String[] data){
		mergeSort(data, 0, data.length - 1);
	}

	private void mergeSort(String[] data, int low, int high){
		int mid;
		if(low < high){
			mid = low + (high - low) / 2;
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