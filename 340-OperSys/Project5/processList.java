/*
 * processList.java
 * Michael Blackburn
 * process a list of strings and split each into two,
 * an integer and a string 
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class processList{
	public static void main(String[] args) throws IOException {
		final double SEEK = .0085; //in seconds
		final double LATENCY = .00416; //in seconds
		final double RATE = 3000000000.0; //in bytes/sec
		final int BLOCK = 4096; //in bytes
		double total_throughput = 0, throughput = 0;
		int wasted_space = 0;
		int total_seeks = 0;
		int var_block = 0;
		int blocks;
		int under128 = 0, under256 = 0, under512 = 0, under1024 = 0, 
			under2048 = 0, under4096 = 0, over4096 = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		Scanner input = new Scanner(new File("fileByte.txt"));
		PrintWriter output = new PrintWriter("fileSizes2.txt");
		while(input.hasNext()){
			if(input.hasNextInt()){
				list.add(input.nextInt());
			}
			else{
				input.nextLine();
			}
		}

		for(int i = 0; i < list.size(); i++){
			output.println(list.get(i));
		}
		input.close();
		output.close();

		Scanner input2 = new Scanner(new File("fileSizes2.txt"));
		PrintWriter output2 = new PrintWriter("fileGroups2.txt");
		int x = 0;
		while(input2.hasNextInt()){
			x = input2.nextInt();
			if(x >= 1 && x < 128){
				under128++;
			}
			else if(x >= 128 && x < 256){
				under256++;
			}
			else if(x >= 256 && x < 512){
				under512++;
			}
			else if(x >= 512 && x < 1024){
				under1024++;
			}
			else if(x >= 1024 && x < 2048){
				under2048++;
			}
			else if(x >= 2048 && x < 4096){
				under4096++;
			}
			else{
				over4096++;
			}
		}
		output2.println("Group 1 - under 128 = " + under128);
		output2.println("Group 2 - under 256 = " + under256);
		output2.println("Group 3 - under 512 = " + under512);
		output2.println("Group 4 - under 1024 = " + under1024);
		output2.println("Group 5 - under 2048 = " + under2048);
		output2.println("Group 6 - under 4096 = " + under4096);
		output2.println("Group 7 - over 4096 = " + over4096);
		output2.close();

		input2.close();
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) > 0){
				list2.add(list.get(i));
			}
		}
		int sizeList[] = new int[list2.size()];
		for(int i = 0; i < list2.size(); i++){
			sizeList[i] = list2.get(i);
			
		}
		
		PrintWriter thru = new PrintWriter("total_thru.txt");
		PrintWriter ws = new PrintWriter("wasted_space.txt");
		


		for(int j = 9; j < 14; j++){
			total_throughput = 0;
			wasted_space = 0;
			int size = 1;
			for(int i = 0; i < sizeList.length; i++){
				if(sizeList[i] != 0){
					var_block = (int)Math.pow(2, j);
					if(sizeList[i] % var_block != 0){
					 	blocks = (sizeList[i] / var_block) + 1;
					 } 
					 else{
					 	blocks = (sizeList[i] / var_block);
					 }
					 throughput = (sizeList[i] / (SEEK + LATENCY + (var_block / RATE))) * blocks;
					 total_throughput += throughput;
					 wasted_space += (var_block * blocks) - sizeList[i];
					 
				}
			}
			thru.println("Total throughput for " + var_block + " = " + (total_throughput / sizeList.length));
			ws.println("Total wasted space for " + var_block + " = " + wasted_space + " bytes");
		}
		thru.close();
		ws.close();
	}

}