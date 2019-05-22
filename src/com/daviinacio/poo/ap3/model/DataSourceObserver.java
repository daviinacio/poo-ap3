package com.daviinacio.poo.ap3.model;

public interface DataSourceObserver<E extends BaseModel> {
	void changed(DataSource<E> dao);
}
