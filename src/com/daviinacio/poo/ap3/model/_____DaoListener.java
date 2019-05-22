package com.daviinacio.poo.ap3.model;

import java.util.EventListener;

@Deprecated
public interface _____DaoListener<E extends BaseModel> extends EventListener {
	void inserted(_____DaoEvent<E> event);
	void updated(_____DaoEvent<E> event); 
	void deleted(_____DaoEvent<E> event);
}
