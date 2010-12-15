package rtorres.bbhelloworld;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class HelloWorldScreen extends MainScreen
{
	public HelloWorldScreen(HelloWorldRepository repository){
		super();
		String message = repository.getMessage();
		LabelField title = new LabelField(message,
				LabelField.USE_ALL_WIDTH | LabelField.ELLIPSIS);
		setTitle(title);
	}
}
