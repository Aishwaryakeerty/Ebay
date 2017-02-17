import javax.jws.WebService;

@WebService
public class User 
{
	public String getAllUsers()
	{
		return MySQL.fetchData("select * from users");
	}
	
	public String get_orders(String user_id)
	{
		return MySQL.fetchData("select orders.*,users.name,users.mobile from orders join users on users.id="+user_id+" AND users.email = orders.email");
	}
	
	public String userAuth(String email)
	{
		return MySQL.fetchData("select * from users where email='"+email+"'");
	}
}
