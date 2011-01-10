package wg.gwt.utils.httprevayler.client;



import java.util.Map;

import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.URL;

public class SureRequest {
	
	private final String _url;
	private final Method _method;

	public SureRequest(String url, Method method) {
		_url = url;
		_method = method;
	}
	
	public void makeRequest(Map<String, String> params, SureRequestCallback requestCallback) throws RequestException {
		RequestBuilder requestBuilder = 
			new RequestBuilder(_method, requestUrl(params));

		setHeaders(requestBuilder);
		
		requestBuilder.sendRequest(requestData(params),
			new SureRequestCallbackConverter(requestCallback));
		
	}

	private String requestUrl(Map<String, String> params) {
		if (_method == RequestBuilder.GET || _method == RequestBuilder.DELETE)
			return _url + "?" + processParams(params);
		
		return _url;
	}

	private String requestData(Map<String, String> params) {
		if (_method == RequestBuilder.POST)
			return processParams(params);
		
		return null;
	}
	
	private void setHeaders(RequestBuilder requestBuilder) {
		if (_method == RequestBuilder.POST)
			requestBuilder.setHeader("Content-type",	"application/x-www-form-urlencoded; charset=utf-8");
	}
	
	private String processParams(Map<String, String> params) {
		String result = "";
		if (params == null) return result;
		
		for (String key : params.keySet())
			result += (result.isEmpty() ? "" : "&") + key + "=" + URL.encodeComponent(params.get(key));
		
		return result;
	}
	
}