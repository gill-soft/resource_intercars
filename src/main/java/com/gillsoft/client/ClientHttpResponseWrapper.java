package com.gillsoft.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class ClientHttpResponseWrapper implements ClientHttpResponse {
	
	private ClientHttpResponse response;
	private String responseBody;
	
	public ClientHttpResponseWrapper(ClientHttpResponse response) {
		this.response = response;
	}

	@Override
	public HttpHeaders getHeaders() {
		return response.getHeaders();
	}

	@Override
	public InputStream getBody() throws IOException {
		if (response.getBody() != null) {
			if (this.responseBody == null) {
				String responseBody = StreamUtils.copyToString(response.getBody(), Charset.defaultCharset());
				int index = responseBody.indexOf("?>");
				if (index > -1) {
					responseBody = responseBody.substring(0, index + 2) + "<data>"
							+ responseBody.substring(index + 2, responseBody.length()) + "</data>";
				}
				this.responseBody = responseBody;
			}
			return new ByteArrayInputStream(this.responseBody.getBytes());
		}
		return response.getBody();
	}

	@Override
	public void close() {
		response.close();
	}

	@Override
	public int getRawStatusCode() throws IOException {
		return response.getRawStatusCode();
	}

	@Override
	public HttpStatus getStatusCode() throws IOException {
		return response.getStatusCode();
	}

	@Override
	public String getStatusText() throws IOException {
		return response.getStatusText();
	}

}
