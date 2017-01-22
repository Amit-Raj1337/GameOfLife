import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoL {
char original[][]=new char[7][7];
char tempgrid[][]=new char[7][7];
int rowlength;
int columnlength;
int count;
int x;
int y;
String xinput;
String yinput;

	public GoL() //constructor
	{
		
	rowlength=0;
	columnlength=0;
	count=0;
	}


	public void initializeValues() //used to initialize the entire grid with 'dead cells'
	{
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				original[i][j]='o';
				tempgrid[i][j]='o';
			}
		}

	}
	
	public void copyGrid()
	{
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				original[i][j]=tempgrid[i][j];
			}
		}
		
	}
	
	public void printGrid()
	{ 
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				System.out.print(tempgrid[i][j]+" ");
			
			}
			System.out.println();
		}
		
	}
	
	
	public void insertLivingCells(int countOfLiving) throws IOException
		{
			for(int i=0;i<countOfLiving;i++)
			{
				
				System.out.println("Enter the coordinates (X) and (Y) for value  " +(i+1));
				InputStreamReader rd =new InputStreamReader(System.in);
				BufferedReader br=new BufferedReader(rd);
				xinput=br.readLine();
				x=Integer.parseInt(xinput); //getting the x co-ordinate
				//System.out.println("Enter the coordinates (y) for value  " +(i+1));
				yinput=br.readLine();
				y=Integer.parseInt(yinput); //getting the y co-ordinate
				
				original[x][y]='X';
				tempgrid[x][y]='X';
				
				System.out.println();
			}
				
			System.out.println("Insertion Complete");
		
		}
	
	public void nextInstanceOfGoL()
		{
		rowlength=7;
		columnlength=7;
		int counter=0;
		for(int i=0;i<7;i++)
		{
			for(int j=0;j<7;j++)
			{
				
				if((i==0)||(i==(rowlength-1))||(j==0)||(j==(columnlength-1)))//if element is present in either edges (rows or columns)
				{	
					if((i==0)||(i==(rowlength-1))&&(j==0)||(j==(columnlength-1))) //if it's one of the four corner values
					{
						
						if(i==0&&j==0)//top left corner
						{
							
							if(original[i][j]=='o')//checking for dead cell
							{
								if((original[i][j+1]=='X')&&(original[i+1][j]=='X')&&(original[i+1][j+1]=='X'))
								{
									tempgrid[i][j]='X'; // Bringing the cell to life
								}
																	
							}
							else // the cell is alive
							{
								if(original[i][j+1]=='X')
								counter++;
								if(original[i+1][j]=='X')
									counter++;
								if(original[i+1][j+1]=='X')
									counter++;
								
								if((counter!=2)&&(counter!=3))
										{
									tempgrid[i][j]='o'; //alive
									    } 
							}
						}
						
						if(i==0&&j==(columnlength-1))//top right corner
						{
							
							if(original[i][j]=='o')//checking for dead cell
							{
								if((original[i][j-1]=='X')&&(original[i+1][j-1]=='X')&&(original[i+1][j]=='X'))
								{
									tempgrid[i][j]='X'; // Bringing the cell to life
								}
																	
							}
							else // the cell is alive
							{
								if(original[i][j-1]=='X')
								counter++;
								if(original[i+1][j-1]=='X')
									counter++;
								if(original[i+1][j]=='X')
									counter++;
								
								if((counter!=2)&&(counter!=3))
										{
									tempgrid[i][j]='o'; //alive
									    } 
							}
						}
						
						
						if(i==(rowlength-1)&&j==0)//bottom left corner
						{
							
							if(original[i][j]=='o')//checking for dead cell
							{
								if((original[i][j+1]=='X')&&(original[i-1][j]=='X')&&(original[i-1][j+1]=='X'))
								{
									tempgrid[i][j]='X'; // Bringing the cell to life
								}
																	
							}
							else // the cell is alive
							{
								if(original[i][j+1]=='X')
								counter++;
								if(original[i-1][j]=='X')
									counter++;
								if(original[i-1][j+1]=='X')
									counter++;
								
								if((counter!=2)&&(counter!=3))
										{
									tempgrid[i][j]='o'; //alive
									    } 
							}
						}
						
						
						if(i==0&&j==(columnlength-1))//bottom right corner
						{
							
							if(original[i][j]=='o')//checking for dead cell
							{
								if((original[i][j-1]=='X')&&(original[i-1][j-1]=='X')&&(original[i-1][j]=='X'))
								{
									tempgrid[i][j]='X'; // Bringing the cell to life
								}
																	
							}
							else // the cell is alive
							{
								if(original[i][j-1]=='X')
								counter++;
								if(original[i-1][j-1]=='X')
									counter++;
								if(original[i-1][j]=='X')
									counter++;
								
								if((counter!=2)&&(counter!=3))
										{
									tempgrid[i][j]='o'; //alive
									    } 
							}
						}
						
						
												
						
					}//end of corner logic
					
					else
					{
						
						if(j==0)//left column elements that are not in the corner
						{
							counter=0;
							
								if(original[i-1][j]=='X') //counting the generic no. of live cells
								counter++;
								if(original[i-1][j+1]=='X')
									counter++;
								if(original[i][j+1]=='X')
									counter++;
								if(original[i+1][j]=='X')
									counter++;
								if(original[i+1][j+1]=='X')
									counter++;								
															
								if(original[i][j]=='o')//if it's a dead cell
								{
									if(counter==3)
										tempgrid[i][j]='X'; //bring it to life
									}
								else //if it's a live cell
								{
									if((counter!=2)&&(counter!=3))
										tempgrid[i][j]='o'; //turn it to a dead cell
								}
								
						}// end of left column
						
						if(j==(columnlength-1))//right column elements that are not in the corner
						{
							counter=0;
							
								if(original[i-1][j]=='X') //counting the generic no. of live cells
								counter++;
								if(original[i-1][j-1]=='X')
									counter++;
								if(original[i][j-1]=='X')
									counter++;
								if(original[i+1][j]=='X')
									counter++;
								if(original[i+1][j-1]=='X')
									counter++;								
															
								if(original[i][j]=='o')//if it's a dead cell
								{
									if(counter==3)
										tempgrid[i][j]='X'; //bring it to life
									}
								else //if it's a live cell
								{
									if((counter!=2)&&(counter!=3))
										tempgrid[i][j]='o'; //turn it to a dead cell
								}
								
						}// end of right column
						
						if(i==0)//top row elements that are not in the corner
						{
							counter=0;
							
								if(original[i][j-1]=='X') //counting the generic no. of live cells
								counter++;
								if(original[i+1][j-1]=='X')
									counter++;
								if(original[i+1][j]=='X')
									counter++;
								if(original[i+1][j+1]=='X')
									counter++;
								if(original[i+1][j]=='X')
									counter++;								
													
								if(original[i][j]=='o')//if it's a dead cell
								{
									if(counter==3)
										tempgrid[i][j]='X'; //bring it to life
									}
								else //if it's a live cell
								{
									if((counter!=2)&&(counter!=3))
										tempgrid[i][j]='o'; //turn it to a dead cell
								}
								
						}// end of top row
						
						if(i==(rowlength-1))//bottom row elements that are not in the corner
						{
							counter=0;
							
								if(original[i][j-1]=='X') //counting the generic no. of live cells
								counter++;
								if(original[i-1][j-1]=='X')
									counter++;
								if(original[i-1][j]=='X')
									counter++;
								if(original[i-1][j+1]=='X')
									counter++;
								if(original[i-1][j]=='X')
									counter++;								
															
								if(original[i][j]=='o')//if it's a dead cell
								{
									if(counter==3)
										tempgrid[i][j]='X'; //bring it to life
									}
								else //if it's a live cell
								{
									if((counter!=2)&&(counter!=3))
										tempgrid[i][j]='o'; //turn it to a dead cell
								}
								
						}// end of bottom row
						
						
					}// end of else 
					
				} //end of edge logic
				
				else//logic for remaining elements
				{
					
					counter=0;
					
					if(original[i-1][j-1]=='X') //counting the generic no. of live cells
					counter++;
					if(original[i-1][j]=='X')
						counter++;
					if(original[i-1][j+1]=='X')
						counter++;
					if(original[i][j+1]=='X')
						counter++;
					if(original[i+1][j+1]=='X')
						counter++;								
					if(original[i+1][j]=='X')
						counter++;
					if(original[i+1][j-1]=='X')
						counter++;
					if(original[i][j-1]=='X')
						counter++;
				
					if(original[i][j]=='o')//if it's a dead cell
					{
						if(counter==3)
							tempgrid[i][j]='X'; //bring it to life
						}
					else //if it's a live cell
					{
						if((counter!=2)&&(counter!=3))
							tempgrid[i][j]='o'; //turn it to a dead cell
					}
					
					
				}
			}
		}	
		
		}
	
	}

