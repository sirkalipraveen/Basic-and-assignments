package Week3day2;

import java.util.Arrays;

public class SortingOfCollection {

	public static void main(String[] args) {
	// 1)Declare Input
		String[]input= {"HCL","Wipro","Aspire Systems","CTS"};
	// 2)Get length of array 
		int lengthofArray=input.length;
	// 3)Sort the array
		Arrays.sort(input);
	// 4)Iteration in reverse Order	
		for (int i = input.length-1; i >=0 ; i--) {
	// 5)Print the output		
			System.out.println(input[i]);
		}
		

	}

}
