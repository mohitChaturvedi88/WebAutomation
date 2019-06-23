package com.koovs.web_automation.Rough;

//Java program to illustrate renaming and 
//moving a file permanently to a new loaction 
import java.io.*;

public class Test {
	public static void main () {

		InputStream inStream = null;
		OutputStream outStream = null;

		try {

			File afile = new File(System.getProperty("user.dir") + "\\extentreport.html");

			File bfile = new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\archiveReports\\extentreport.html");

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();

			System.out.println("File is copied successful!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
