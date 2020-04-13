package sg.edu.nus.iss.vmcs.maintenance;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import sg.edu.nus.iss.vmcs.Vmcs;
import sg.edu.nus.iss.vmcs.util.ResourceMessage;

public class LanguagePanel {

	
	public LanguagePanel() {}
	
	public void LoadLanguagePanel(Panel tp1)
	{
        /////////
		CheckboxGroup cbg1=new CheckboxGroup ();
		Checkbox ckEnglish;
		ckEnglish=new Checkbox ("English",cbg1,true);
		ckEnglish.addItemListener (new ItemListener () {
			  public void itemStateChanged(ItemEvent e) {               
		           if (e.getStateChange()==1)
		           {
		        	   System.out.println("English");
		        	   Vmcs.rm=new ResourceMessage("en", "SG");
		           }
		       }  
		}); 
		tp1.add(ckEnglish);
		///
		Checkbox ckChinese; 
		ckChinese=new Checkbox ("Chinese",cbg1,false);
		ckChinese.addItemListener (new ItemListener () {
			public void itemStateChanged(ItemEvent e) {               
		    if (e.getStateChange()==1)
		    {
		    	System.out.println("Chinese");
		    	Vmcs.rm=new ResourceMessage("zh", "CN");
		    }
		}  });
		tp1.add(ckChinese);
		//
		Checkbox ckJapnese;
		ckJapnese=new Checkbox ("Japnese",cbg1,false);
		ckJapnese.addItemListener (new ItemListener () {
			 public void itemStateChanged(ItemEvent e) {               
		         if (e.getStateChange()==1)
		         {
		        	 System.out.println("Japnese");
		        	 Vmcs.rm=new ResourceMessage("ja", "JP");
		         }
		     }  
		});
		tp1.add(ckJapnese);
	}
}
