package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import entity.Title;

public class ExcelUtil {

	public static void createExcel(List<Title> ts) throws Exception{
		
		//InputStream is = new FileInputStream("D://test.xlsx");
		HSSFWorkbook hsswb = new HSSFWorkbook(); 
		
		  HSSFSheet sheet = hsswb.createSheet("a");
		  
		  System.out.print("11111111111111111111");
		  
		  HSSFRow row1 = sheet.createRow(0);
		  HSSFCell[] cells = new HSSFCell[2];
		  String[] names = new String[2];
		  names[0]="姓名";
		  names[1]="年龄";
		  for(int i=0;i<2;i++){
			  cells[i] = row1.createCell(i);
			  cells[i].setCellValue(names[i]);
			  
		  }
		  
		  
		  for(int i =0 ;i<ts.size();i++){
			  
			  HSSFRow row = sheet.createRow(i+1);
			  Title t = ts.get(i);
			  for(int j=0;j<2;j++){
				  
				  HSSFCell name = row.createCell(0);
				  name.setCellValue(t.getName());
				  
				  HSSFCell age = row.createCell(1);
				  age.setCellValue(t.getAge()+"");
				  
			  }
			  
		  }
		  
		    OutputStream out = new FileOutputStream("D://test.xls");
		    hsswb.write(out);
	        out.close();
	        System.out.println("数据库导出成功");
		
	}
}
