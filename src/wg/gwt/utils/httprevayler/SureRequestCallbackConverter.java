package wg.gwt.utils.httprevayler;



import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

public class SureRequestCallbackConverter implements RequestCallback {
	private final SureRequestCallback _handler;

	public SureRequestCallbackConverter(SureRequestCallback handler) {
		_handler = handler;
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		_handler.onResponseReceived(request, new DecodedResponse(response));
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert(exception.getMessage());
	}
}