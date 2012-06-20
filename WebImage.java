import java.net.MalformedURLException;
import java.net.URL;


public class WebImage implements WebElement{

	URL m_url;
	
	public WebImage(String s){
		try {
			m_url = new URL(s);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("Bad URL for Image");
		}
	}
	@Override
	public URL getLocation() {
		// TODO Auto-generated method stub
		return m_url;
	}
	
	public void save(){
		DownloadRepository.getInstance().writeElement(this);
	}

}
