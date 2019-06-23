package com.koovs.web_automation.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class archiveExtentReport {
	public static void main(String[] args) throws IOException {

		InputStream inStream = null;
		OutputStream outStream = null;

		if (new File(System.getProperty("user.dir") + "\\extentreport.html") != null) {
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

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
