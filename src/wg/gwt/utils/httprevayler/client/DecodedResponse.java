package wg.gwt.utils.httprevayler.client;

import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class DecodedResponse {
	private final Response _response;

	public DecodedResponse(Response response) {
		_response = response;
	}

	public JSONValue getJsonValue() {
		return JSONParser.parse(getText());
	}

	public String getText() {
		return URL.decodeComponent(_response.getText());
	}

	public int getStatusCode() {
		return _response.getStatusCode();
	}
}