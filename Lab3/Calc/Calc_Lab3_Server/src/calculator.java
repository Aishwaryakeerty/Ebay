import javax.jws.WebService;

@WebService
public class calculator 
{
	public int calculate(int num1,int num2,String oper)
	{
		try
		{
			if(oper.equals( "add"))
			{
				System.out.println(num1 + num2);
				return num1 + num2 ;
			}
			else if(oper.equals("sub"))
			{
				return num1 - num2 ;
			}
			else if(oper.equals("mul"))
			{
				return num1 * num2 ;
			}
			else if(oper.equals("div"))
			{
				if(num2 == 0)
					return -1;
				return num1 / num2 ;
			}
			else
			{
				return -1;
			}
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return -1;
		}
	}
}
