var soap = require('soap');
var baseURL = "http://localhost:8080/Calc_Lab3_Server/services";

var result = 0; 
exports.calc = function(req, res){
	res.render('calc',{"result":result});
};

exports.calculate = function (req,res)
{
	var oper = req.param("oper");
	var num1= req.param('num1');
	var num2= req.param('num2');
	num1 = parseInt(num1);
	num2 = parseInt(num2);
	console.log(oper);
	
	var option = {
			ignoredNamespaces : true	
		};
	 var url = baseURL+"/calculator?wsdl";
	  var args = {"num1": num1,"num2": num2,"oper":oper};
	  soap.createClient(url,option, function(err, client) {
	      client.calculate(args, function(err, result) {
	    	  console.log(result.calculateReturn);
	    	  result = result.calculateReturn;
	    	  console.log(result);
	    	  res.render('calc',{"result":result});
	      });
	  });
} ;



