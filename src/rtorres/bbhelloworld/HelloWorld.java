package rtorres.bbhelloworld;

import rtorres.bbhelloworld.test.HelloWorldTestRunner;
import net.rim.device.api.ui.UiApplication;

public class HelloWorld extends UiApplication
{
	public static void main(String[] args) 
	{
		boolean startApp = false;
		boolean runTests = false;
		
		for (int i = 0; i < args.length; ++i) 
		{
			if (args[i].equals("helloworld")) startApp = true;
			if (args[i].equals("helloworldtest")) runTests = true;
		}
		
		if (startApp)
		{
		    HelloWorld theApp = new HelloWorld();
		    theApp.enterEventDispatcher();
	    }
		
		if (runTests)
		{
			HelloWorldTestRunner testRunner = new HelloWorldTestRunner();
			testRunner.enterEventDispatcher();
		}
	}
	
	public HelloWorld()
	{
		pushScreen(new HelloWorldScreen(new HelloWorldRepository()));
	}
}
