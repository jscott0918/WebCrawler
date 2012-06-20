import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;


public class DownloadRepository {

	private static DownloadRepository instance;
	private String dir;
	private DownloadRepository(){
		dir = new String();
	}
	public static DownloadRepository getInstance(){
		if(instance == null){
			instance = new DownloadRepository();
		}
		return instance;
	}
	
	public void setDir(String d){
		dir = d;
	}
	
	public void writeElement(WebElement w) {

		//Initialize values
		String curLine = new String();
		
		BufferedReader br = null;
		InputStream is = null;
		PrintStream ps = null;

		//Generate file name
		String webAddress = new String(w.getLocation().toString());
		String[] webAddressSplit = webAddress.split("/");
		webAddress = webAddressSplit[webAddressSplit.length];
		webAddress = dir + webAddress;
		
		//Open file to print
		File outFile = new File(webAddress);

		try {
			//Try to get file contents from URL
			is = w.getLocation().openStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			curLine = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Buffered Reader Failed Exception");
		}

		//Try to open destination file
		try {
			ps = new PrintStream(outFile);
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			
		}

		//Write contents of URL to File
		while(curLine != null){
			ps.print(curLine);
			try {
				curLine = br.readLine();
			} catch (IOException e) {
				System.out.println("Bad line");
				curLine = null;
			}
		}
	}
}
