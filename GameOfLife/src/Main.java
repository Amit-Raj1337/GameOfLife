import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		GoL obj=new GoL();
		int flag=1;
		char s;
		String input;
		int countOfLivingCells;
		
	System.out.println("Welcome to the game of life");
	System.out.println("Please enter the blocks you wish to insert a living 'cell' into  (By default all cells are dead)");
	
	obj.initializeValues();
	obj.printGrid();
	
	System.out.println("Please enter the number of living cells to be inserted");
	InputStreamReader rd =new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(rd);
	input=br.readLine();
	countOfLivingCells=Integer.parseInt(input); //converting the string value to integer.
	
	obj.insertLivingCells(countOfLivingCells); //calling the function which will insert the living cells.
	
	
	
	System.out.println();
	
	
	System.out.println("This is the First Instance of the grid after insertion before processing:");
	
	obj.printGrid();
	
	System.out.println();
	while(flag!=0)
	{
	System.out.println("This is the next instance:");
	
	obj.nextInstanceOfGoL();
	
	obj.printGrid();
	
	System.out.println("Would you like to continue? Enter 'Y' or 'N' ");
	input=br.readLine();
	s=input.charAt(0);
	
	if((s=='y'||s=='Y'))
	{
		obj.copyGrid();
	
		
		
		}
	else{
		flag=0;
	}
	
	}
		
	
	}

}
