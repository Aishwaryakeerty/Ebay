import javax.jws.WebService;

@WebService
public class Catalog 
{
	public String getBrandProduct(String query)
	{
		return MySQL.fetchData(query);
	}
	
	public String getCatalog()
	{
		return MySQL.fetchData("select * from catalog");
	}
}
