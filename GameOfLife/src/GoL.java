import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GoL {

	
	JFrame frame=new JFrame("The Game Of Life");
	
	JButton [][] grid=new JButton[20][20];
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JButton startButton=new JButton("Start");
	JButton nextButton=new JButton("Next");
	JButton resetButton=new JButton("Reset");
	
	
	char original[][]=new char[20][20];
	char tempgrid[][]=new char[20][20];
	int rowlength;
	int columnlength;
	int count;
	int x;
	int y;
	String xinput;
	String yinput;
	
	
	
	public GoL() //constructor
	{
		
	rowlength=20;
	columnlength=20;
	count=0;
	
	}

	
	
	
	public void LayoutGenerator()
	{
		nextButton.setEnabled(false);
		
		p1.setLayout(new GridLayout(rowlength, columnlength));

		
		frame.setLayout(new GridLayout(0,1));
					
		
		for(int i=0;i<rowlength;i++)
		{
			for(int j=0;j<columnlength;j++)
			{
				
				grid[i][j]=new JButton(i+","+j);
				grid[i][j].setBackground(Color.darkGray);
				p1.add(grid[i][j]);		
			
			}
			
		}
		
		p2.add(startButton);
		p2.add(nextButton);
		p2.add(resetButton);
		
		frame.add(p1);
		frame.add(p2);
		
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
	} //end of layout Generator
    
	
	public void gridbuttonLogic()
	{
		
		// action Listener for the grid of buttons in panel 1
			for(int x=0; x<rowlength; x++){
				for(int y=0; y<columnlength; y++){
                                                                                                                                             
                           grid[x][y].addActionListener(new ActionListener()
                           {
                             public void actionPerformed(ActionEvent e)
                             {
                           	 
                           	JButton temp= (JButton) e.getSource();
                           	
                           	temp.setText("X");
                           	temp.setBackground(Color.RED);
                           	
                             for(int x=0; x<rowlength; x++){
                                 for(int y=0; y<columnlength; y++){
                                 
                                 	if(temp==grid[x][y])
                                 	{
                                 		                         		
                                 		//System.out.println("X: "+x+"  Y: "+y);
                                 		original[x][y]='X';
                        				tempgrid[x][y]='X';
                                 		
                                 	}
                                 }}
                           	
                           	
            
                             }
                           }); //end of action listener for the grid
                           
                           
         				} 
	 				}//end of nested loop
			
					
			
		} // end of button logic method
	
	
	public void StartButtonLogic()
	{
		startButton.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				
				JButton temp= (JButton) e.getSource();
				
				if(temp.getText().equals("Start"))
				{
					temp.setText("Game already started");
					
					nextButton.setEnabled(true);
					
					temp.setEnabled(false);
					
					nextInstanceOfGoL();
					
					printGrid();
					
					//nextButton.setEnabled(true);
					
				}
				else
				{
					temp.setText("Start");	
				nextButton.setEnabled(false);
				}
				
			}
		});
		
	} //end of start button logic
	
	public void nextButtonLogic()
	{
		
		nextButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				//initializeValues();
				
				//printGrid();
				nextInstanceOfGoL();
				
				
				printGrid();
				
				copyGrid();
				
				
				
				//System.out.println("-----------------------");
				//printGrid();
				
				
				
			}
		});


	}// end of next button logic
	
	public void resetButtonLogic()
	{
		
		
		resetButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				JButton temp= (JButton) e.getSource();
				
				if(startButton.getText().equals("Game already started"))
				{
					startButton.setText("Start");
					startButton.setEnabled(true);
					
					for(int x=0; x<rowlength; x++){
						for(int y=0; y<columnlength; y++){
		                                                                                                                                             
		                         
		                           	grid[x][y].setText(x+","+y);
		                           	grid[x][y].setBackground(Color.darkGray);
		                           			                            		                           			                           	
		            
		                            
		                           //end of action listener for the grid
		                           
		                           
		         				} 
			 				}// end of nested loop
					
						initializeValues();
					
					}// end of if
				else
				{} // do nothing
				
				
			}
			});
		
		
		
	}// end of reset button logic
	
	
	
	public void nextInstanceOfGoL()
	{
	int counter=0;
	for(int i=0;i<rowlength;i++)
	{
		for(int j=0;j<columnlength;j++)
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
	
	

	

	public void initializeValues() //used to initialize the entire grid with 'dead cells'
	{
		for(int i=0;i<rowlength;i++)
		{
			for(int j=0;j<columnlength;j++)
			{
				original[i][j]='o';
				tempgrid[i][j]='o';
			}
		}

	}
	
	public void copyGrid()
	{
		for(int i=0;i<rowlength;i++)
		{
			for(int j=0;j<columnlength;j++)
			{
				original[i][j]=tempgrid[i][j];
			}
		}
		
	}
	
	
	 public void printGrid()
		{ 
		 
		 
		 for(int x=0; x<rowlength; x++){
				for(int y=0; y<columnlength; y++){
                                                                                                                                          
                      
                        	grid[x][y].setText(x+","+y);
                        	grid[x][y].setBackground(Color.darkGray);
                        			                            		
                        	if(tempgrid[x][y]=='X')
	                         {
	                        	 
	                        	 grid[x][y].setText("X");
	                        	  	grid[x][y].setBackground(Color.cyan);
	                         }
         
                         
                        
                        
                        
      				} 
	 		}
		 /*
		 	System.out.println("TEMP GRID");
			for(int i=0;i<rowlength;i++)
			{
				for(int j=0;j<columnlength;j++)
				{
					System.out.print(tempgrid[i][j]+" ");
				
				}
				System.out.println();
			}
			
			System.out.println("ORIGINAL GRID");
			for(int i=0;i<rowlength;i++)
			{
				for(int j=0;j<columnlength;j++)
				{
					System.out.print(original[i][j]+" ");
				
				}
				System.out.println();
			}*/
			
			
		}// end of print grid
	
		
	
}// end of class
