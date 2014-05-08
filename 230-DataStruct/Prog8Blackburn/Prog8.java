import java.util.Scanner;

public class Prog8{
	public static void main(String[] args){
		int menu2 = 0;
		int compareCount = 0, assignCount = 0, len = 0;
		menu2 = menu2();

		while(menu2 != 2){
			switch(menu2){
				case 1:
					Sorter sort = new Sorter();
					int menu1 = 0;
					Scanner input  = new Scanner(System.in);
					System.out.println("Please enter the filename, with extension, of the file you would like to sort (i.e. filename.txt): ");
					String filename = input.nextLine();
					String[] list = WordReader.read(filename);
					len = list.length;
					for(int i = 0; i < list.length; i++){
						System.out.println(list[i]);
					}
					System.out.println("Please select a sort method to implement:");
					menu1 = menu1();
					
					switch(menu1){
						case 1:
							sort.selectionSort(list);
							compareCount = sort.getCountCompares();
							assignCount = sort.getCountAssigns();
							break;
						case 2:
							sort.bubbleSort(list);
							compareCount = sort.getCountCompares();
							assignCount = sort.getCountAssigns();
							break;
						case 3:
							sort.mergeSort(list);
							compareCount = sort.getCountCompares();
							assignCount = sort.getCountAssigns();
							break;
						case 4: 
							sort.quickSort(list);
							compareCount = sort.getCountCompares();
							assignCount = sort.getCountAssigns();
							break;
						default:
					}
					System.out.println("Sorted list:");
					for(int j = 0; j < list.length; j++){
						System.out.println(list[j]);
					}
					break;
				default:
			}
			System.out.println("Number of compares: " + compareCount);
			System.out.println("Number of assigns: " + assignCount);
			System.out.println("Number of items in list: " + len);
			menu2 = menu2();
		} 
		
	}
	public static int menu1(){
			int sel = 0;
			boolean isValid = false;
	        Scanner entry = new Scanner(System.in);
			
			while (isValid == false){
				System.out.println("");
				System.out.println("1. Selection Sort");
				System.out.println("2. Bubble Sort");
				System.out.println("3. Merge Sort");
				System.out.println("4. Quick Sort");
				System.out.print("Please enter a number, 1-4: ");
				System.out.println("");
				sel = entry.nextInt();
				if ((sel >=1) && (sel <= 6))
					isValid = true;
				else System.out.println("Invalid choice.  Please enter a number between 1 and 6, or 0 to exit.");
			}		
			return sel;
	}

	public static int menu2(){
		int sel = 0;
		boolean isValid = false;
		Scanner entry = new Scanner(System.in);

		while (isValid == false){
			System.out.println("");
			System.out.println("1. Pick a sort");
			System.out.println("2. Quit");
			System.out.println("Make a selction, 1 or 2?");
			sel = entry.nextInt();
			if((sel > 0) && (sel < 3)){
				isValid = true;
			}
			else{
				System.out.println("Invlaid selection. Please pick 1 or 2.");
			}
		}
		return sel;
	}
}