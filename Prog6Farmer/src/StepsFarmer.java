/**
 * 
 * @author Logan Farmer <br>
 * This is the steps class
 *
 */
public class StepsFarmer 
{
	/**
	 * Instance variable for step width
	 */
	private int myStepWidth;
	/**
	 * Instance variable for the number of steps
	 */
	private int myNumSteps;
	/**
	 * Instance variable for fill style for steps
	 */
	private char myFillStyle;
	
	/**
	 * @param stepWidth (The new step width)
	 * @param numSteps (The new number of steps)
	 * @param fillStyle (The new fill style) 
	 */
	public StepsFarmer(int stepWidth, int numSteps, char fillStyle)
	{
		myStepWidth = stepWidth;
		myNumSteps = numSteps;
		myFillStyle = fillStyle;
	}//steps
	/**
	 * Empty constructor for StepsFarmer
	 */
	public StepsFarmer()
	{
		myStepWidth = 2;
		myNumSteps = 5;
		myFillStyle = '*';
	}//empty constructor
	
	
	/**
	 * Setter for step width
	 * @param stepWidth (incoming new step width)
	 */
	public void setStepWidth(int stepWidth)
	{
		myStepWidth = stepWidth;
	}//setStepWidth
	
	/**
	 * Setter for number of steps
	 * @param numSteps (incoming new number of steps)
	 */
	public void setNumSteps(int numSteps)
	{
		myNumSteps = numSteps;
	}//setNumSteps
	
	/**
	 * Setter for fill style
	 * @param fillStyle (incoming new fill style)
	 */
	public void setFillStyle(char fillStyle)
	{
		myFillStyle = fillStyle;
	}//setFillStyle
	
	/**
	 * Getter for step width
	 * @return step width
	 */
	public int getStepWidth()
	{
		return myStepWidth;
	}//getStepWidth
	
	/**
	 * Getter for number of steps
	 * @return number of steps
	 */
	public int getNumSteps()
	{
		return myNumSteps;
	}//getNumSteps
	
	/**
	 * Getter for fill style
	 * @return fill style 
	 */
	public char getFillStyle()
	{
		return myFillStyle;
	}//getFillStyle
	
	/**
	 * Method to calculate the area of stairs
	 * @return integer containing area of stairs
	 */
	public int calcArea()
	{
		int area = 0, k = 1, j = 1;
		for (k = 1; k <= myNumSteps; k++)
			for (j = 1; j <= myStepWidth * k; j++)
				area++;
		return area;
	}//calcArea
	
	/**
	 * toString method to keep track of all variables
	 * @return string containing information on all variables
	 */
	public String toString()
	{
		String result;
		result = "Step Width: " + myStepWidth + "\n";
		result += "Number of Steps: " + myNumSteps + "\n";
		result += "Fill Style: " + myFillStyle + "\n";
		return result;
	}//toString
	
	/**
	 * method to draw steps
	 */
	public void drawSteps()
	{
		int i = 0, o = 0;
		for (i = 1; i <= myNumSteps; i++)
		{
			for (o = 1; o <= myStepWidth * i; o++)
				System.out.print(myFillStyle);
			System.out.println();
		}//for
		
	}//drawSteps
	
}//StepsFarmer
