package wg.gwt.utils.httprevayler;


import java.util.Map;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.user.client.Window;

public abstract class SimpleRequest {

	public SimpleRequest(String uri, Method method, Map<String, String> params) {
		try {
			new SureRequest("/" + uri, method).makeRequest(params, new SureRequestCallback() {
				@Override
				public void onResponseReceived(Request request, DecodedResponse response) {
					SimpleRequest.this.onResponseReceived(request, response);
				}
			});
		} catch (RequestException e) {
			Window.alert(e.getMessage());
		}
	}

	protected void onResponseReceived(Request request, DecodedResponse response) {
		onResponseReceived(response.getText());
	}

	protected void onResponseReceived(String text) {
		onResponseReceived();
	}

	protected void onResponseReceived() {}

}
