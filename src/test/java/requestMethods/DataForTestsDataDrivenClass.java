package requestMethods;

import org.testng.annotations.DataProvider;

public class DataForTestsDataDrivenClass {
	@DataProvider(name = "CreateData")
	public Object CreateDataByDataDriven() {
//		Object data[][] = new Object[10][10];
//		data[0][0] = "Alish";
//		data[0][1] = "Khan";
//		data[0][2] = 12;
//		
//		data[1][0] = "Aahil";
//		data[1][1] = "Khan";
//		data[1][2] = 20;
//		
//		data[1][0] = "Arsh";
//		data[1][1] = "Khan";
//		data[1][2] = 25;
//		
//		return data;
		
		return new Object[][] {
			{"Alisha", "Khan", 33},
			{"Aahil", "Khan", 44},
			{"Arsh", "Khan", 55},
			{"Noor", "Pari", 66}
		};
	}
	//@DataProvider(name = "DeleteData")
	public Object DeleteDataByDataDriven() {
		return new Object[] {
				4,5,7
		};
	}
}
