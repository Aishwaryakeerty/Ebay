import java.sql.ResultSet;
import javax.jws.WebService;

@WebService
public class Order 
{
	public int getCount() throws Exception
	{
		int count = 0;
		ResultSet rs = MySQL.fetchResultSet("select count(*)as count from orders");
		while(rs.next())
			count =  rs.getInt(1);
		return count;
	}
	
	public String getOrders(String urlHash)
	{
		return MySQL.fetchData("select * from orders where urlHash='"+urlHash+"'");
	}
	
	public int insertOrder(String customerInfo,String orderInfo, String products, String urlHash,String email,String amount)
	{
		return MySQL.updateData("insert into orders(customerInfo,orderInfo,products,urlHash,email,amount) VALUES('"+customerInfo+"','"+orderInfo+"','"+products+"','"+urlHash+"','"+email+"',"+amount+")");
	}
}
