/*
 * (c) Copyright 2015 EVRYTHNG Ltd London / Zurich
 * www.evrythng.com
 */
package com.evrythng.thng.resource.model.store;

/**
 * Abstract structure to represent the possible shortId templates to be used in BatchPopulatingTask
 */
public abstract class ShortIdTemplate {

	private Type type;
	public static final String FIELD_TYPE = "type";
	
	private Integer length;
	public static final String LENGTH = "length";

	public static enum Type {

		SEQUENTIAL, PSEUDO_RANDOM, THNG_ID
	}

	public Type getType() {

		return type;
	}

	public void setType(final Type type) {

		this.type = type;
	}

	public Integer getLength() {

		return length;
	}

	public void setLength(final Integer length) {

		this.length = length;
	}
}
