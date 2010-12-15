package rtorres.bbhelloworld.test;

import rtorres.bbhelloworld.HelloWorldRepository;

import jmunit.framework.blackberry.Assertion;
import jmunit.framework.blackberry.AssertionFailedException;

public class HelloWorldRepositoryTest
{
	public void testShouldGetHelloWorldMessage() throws AssertionFailedException
	{
		HelloWorldRepository repository = new HelloWorldRepository();
		String message = repository.getMessage();
		Assertion.assertEquals("Hello World", message);
	}
	
	public void test(int testNumber) throws Throwable
	{
		switch(testNumber)
		{
			case 0: testShouldGetHelloWorldMessage(); break;
			default: break;
		}
	}
}
