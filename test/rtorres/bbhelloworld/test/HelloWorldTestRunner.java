package rtorres.bbhelloworld.test;

import net.rim.device.api.ui.UiApplication;

public class HelloWorldTestRunner extends UiApplication
{
	public HelloWorldTestRunner()
	{
		HelloWorldRepositoryTest repositoryTest = new HelloWorldRepositoryTest();
		try {
			repositoryTest.test(0);
        } catch (Throwable ex) {
            System.out.println("---> " + ex.toString());
            ex.printStackTrace();
        }
        
        pushScreen(new UnitTestResultsScreen());
	}
}
