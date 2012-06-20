
public class WebCrawler {

	public static DownloadRepository dr = DownloadRepository.getInstance();
	public static void main(String args[]){
		DownloadRepository.getInstance().setDir(args[1]);
		
	}
}
