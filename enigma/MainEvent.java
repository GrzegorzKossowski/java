package com.grze.enigma;

import java.util.EventObject;

public class MainEvent<T, V, V2> extends EventObject {
	
	private T source;
	private V value;
	private V2 value2;
	
	public MainEvent(T source) {
		super(source);
	}
	
	public MainEvent(T source, V value) {
		super(source);
		this.source = source;
		this.value = value;
	}

	public MainEvent(T source, V value, V2 value2) {
		super(source);
		this.source = source;
		this.value = value;
		this.value2 = value2;
	}
	
	public T getSource() {
		return source;
	}

	public void setSource(T source) {
		this.source = source;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public V2 getValue2() {
		return value2;
	}

	public void setValue2(V2 value2) {
		this.value2 = value2;
	}

	@Override
	public String toString() {
		return "MainEvent [source=" + source + ", value=" + value + ", value2=" + value2 + "]";
	}	
	
}
