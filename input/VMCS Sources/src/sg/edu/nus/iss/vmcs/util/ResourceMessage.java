package sg.edu.nus.iss.vmcs.util;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceMessage {
	
	private ResourceBundle mybundle;
	
	public ResourceMessage(String code, String country)
	{
		Locale.setDefault(new Locale(code, country));
		mybundle = ResourceBundle.getBundle("MyLabels");    
	}
	
	public String GetMessage(String key) {
		return mybundle.getString(key);
	}
}
