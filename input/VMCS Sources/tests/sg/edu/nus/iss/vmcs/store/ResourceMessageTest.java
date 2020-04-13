package sg.edu.nus.iss.vmcs.store;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sg.edu.nus.iss.vmcs.util.ResourceMessage;

public class ResourceMessageTest extends TestCase{
	
	private ResourceMessage rm;
	
	@Before
	public void setup() throws Exception{
		
	}
	
	@After
	public void tearDown() throws Exception{
	}
	
	@Test
	public void testEnglishSG() throws Exception{
		rm=new ResourceMessage("en","SG");
		assertNotNull(rm);
		String result=rm.GetMessage("customer_panel_title");
		assertNotNull(result);
		
	}
	
	@Test
	public void testChineseCN() throws Exception{
		rm=new ResourceMessage("zh","CN");
		assertNotNull(rm);
		String result=rm.GetMessage("customer_panel_title");
		assertNotNull(result);
		
	}
	
	@Test
	public void testJapneseJP() throws Exception{
		rm=new ResourceMessage("ja","JP");
		assertNotNull(rm);
		String result=rm.GetMessage("customer_panel_title");
		assertNotNull(result);
		
	}
}
