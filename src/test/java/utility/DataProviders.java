package utility;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {

        String path = "C:\\Users\\dilmaya\\eclipse-workspace\\Project\\testData\\Login_new.xlsx";

        ExcelUtility xlutil = new ExcelUtility(path);

        int totalrows = xlutil.getRowCount("login");   // last row index
        int totalcols = xlutil.getCellCount("login", 0); // header row

        Object[][] logindata = new Object[totalrows][totalcols];

        for (int i = 1; i < totalrows; i++) { 
        	// this to skip empty row 
        	String firstCell = xlutil.getCellData("login", i, 0);
            if (firstCell == null || firstCell.trim().isEmpty()) {
                continue;
            }
        	
            for (int j = 0; j < totalcols; j++) {

                logindata[i - 1][j] = xlutil.getCellData("login", i, j);

                // Debug print (VERY IMPORTANT while testing)
                System.out.println("Row " + i + " Col " + j + " = " + logindata[i - 1][j]);
            }
        }

        return logindata;
    }
}