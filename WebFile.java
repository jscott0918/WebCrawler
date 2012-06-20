import java.net.MalformedURLException;
import java.net.URL;


public class WebFile implements WebElement{

	URL m_url;
	
	public WebFile(String s){
		try{
			m_url = new URL(s);
		}catch(MalformedURLException e){
			System.out.println("Bad URL Fed");
		}
		
	}
	
	@Override
	public URL getLocation() {
		return m_url;
	}

	public void save(){
		DownloadRepository.getInstance().writeElement(this);
	}
}
