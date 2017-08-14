import static java.lang.System.out;
/**
 * 
 * @author scrotumsimon
 * This is the model of the MVC, whatever the input typed in the input will be converted here
 *
 */
public class CeaserShift {
	char alpha_list[] = new char[] 
			{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	char holder[], Pholder[];
	String ToUpper;
	int Size, Shift;
	
	CeaserShift(String input)
	{
		ToUpper = input.toUpperCase();
		Size = ToUpper.length();
		holder = ToUpper.toCharArray();
		Pholder = new char[Size];
	}
	
	public void convert(int shift_sz)
	{
		for(int i = 0;  i< Size; i++)
		{
			for(int j = 0; j < 26; j++)
			{
				   if(holder[i] == alpha_list[j])
				   {
					   Pholder[i] = alpha_list[solution(j, shift_sz)];
				   }
				   else if(holder[i] == ' ')
				   {
					   Pholder[i] = ' ';
				   }
				   else if(holder[i] == ',')
				   {
					   Pholder[i] = ',';
				   }
				   else if(holder[i] == '"')
				   {
					   Pholder[i] = '"';
				   }
			}
		}
		
	}
	
	public static int solution(int a, int b)
	{
		int c = a;
		int d = b;
		int sol = 0;
		
		if(c+d > 25)
		{
			int alot = c + d;
			alot = alot - 25;
			if(alot > 25)
			{
				alot = alot - 25;
				if ( alot == 1 ){
					sol = 0;
				}
			}
			sol = alot - 1;
		} 
		else 
		{
			sol = c + d;
		}
		
		return sol;
	}
	
	public String printShift()
	{
		return new String(Pholder);
	}
	
	public String multiply()
	{
		String conc = "";
		String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
		
		for(int x = 0; x<26; x++)
		{
			convert(x);
			conc = conc + "Shift " + numbers[x] + "\n"+ printShift()+"\n\n";
		}
		return conc;
	}
	
}
