import java.awt.Desktop;
import java.net.URL;


public class openWebPage {
	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		openWebpage("http://google.com");
	}
}