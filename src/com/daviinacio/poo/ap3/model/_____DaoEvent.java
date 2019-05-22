package com.daviinacio.poo.ap3.model;

import java.util.EventObject;

@Deprecated
public class _____DaoEvent<E extends BaseModel> extends EventObject {
	private E model;

	public _____DaoEvent(DataSource<E> source, E model) {
		super(source);
		this.model = model;
	}
	
	public int getId() {
		return model.getId();
	}
	
	public String getNome() {
		return model.getNome();
	}
	
	public DataSource<E> getSource(){
		return (DataSource<E>) this.source;
	}
}
