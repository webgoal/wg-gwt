package wg.gwt.utils.httprevayler;


import com.google.gwt.http.client.Request;

public abstract class SureRequestCallback {
	public abstract void onResponseReceived(Request request, DecodedResponse response);
}