package net.evrythng.thng.api.result;

import org.apache.http.HttpResponse;

public abstract class ThngContentResult<K> extends ThngResult {

	private K content;
	
	public ThngContentResult(HttpResponse httpResponse, K content) {
		super(httpResponse);
		this.content = content;
	}

	public K getContent() {
		return content;
	}

	protected void setContent(K content) {
		this.content = content;
	}

}