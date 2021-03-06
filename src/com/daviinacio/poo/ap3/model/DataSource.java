package com.daviinacio.poo.ap3.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import com.daviinacio.poo.ap3.Program;

public class DataSource <E extends BaseModel> {
	private File storage;
	private List<E> items;
	private List<DataSourceObserver<E>> dataSourceObservers;
	
	public DataSource(File dataSourceFile) {
		this.storage = dataSourceFile;
		this.items = new ArrayList<>();
		this.dataSourceObservers = new ArrayList<>();
	}
	
	public DataSource<E> init() {
		// Read objects from file
		this.read();
		
		// Call listeners
		this.throwChanged();
		
		return this;
	}
	
	private void read() {
		try {
			if(!storage.exists())
				storage.createNewFile();
			
			this.items.clear();
			
			FileInputStream fis = new FileInputStream(this.storage);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Object obj = new Object();
			
			while(obj != null) {
				obj = ois.readObject();
				this.items.add((E) obj);
				
				// Debug
				//System.out.println(obj);
			}
			
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		catch (java.io.EOFException e) { }
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	private void write() {
		try {
			if(!storage.exists())
				storage.createNewFile();
			
			FileOutputStream fos = new FileOutputStream(this.storage);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for(E e : this.items)
				oos.writeObject(e);
			
			fos.close();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void insert(E e) {
		//this.throwInserted(e);
		
		// find a  available id
		for (int i = 1; true; i++) {
			if(this.selectById(i) == null) {
				e.setId(i);
				break;
			}
		}
		
		this.items.add(e);
		
		this.throwChanged();
		
		this.write();
	}

	public void update(E e) {
		//this.throwUpdated(e);
		
		this.items.set(this.items.indexOf(this.selectById(e.getId())), e);
		
		this.throwChanged();
		
		this.write();
	}

	public void delete(E e) {
		//this.throwDeleted(e);
		
		this.items.remove(e);
		
		this.throwChanged();
		
		this.write();
	}
	
	public void deleteById(int id) {
		this.delete(this.selectById(id));
	}

	public E selectById(int id) {
		for(E a : this.items)
			if(a.getId() == id)
				return a;
		return null;
	}

	public List<E> selectByNome(String nome) {
		List<E> result = new ArrayList<>();
		for(E e : this.items) {
			if(e.getNome().toLowerCase().contains(nome.toLowerCase()))
				result.add(e);
		}
		return result;
	}
	
	public List<E> list(){
		return this.items;
	}

	public int count() {
		return this.items.size();
	}
	
	// Listeners
	public synchronized void addDataSourceObserver(DataSourceObserver<E> listener) {
		if(!this.dataSourceObservers.contains(listener))
			this.dataSourceObservers.add(listener);
	}
	
	public synchronized void throwChanged() {
		for(DataSourceObserver<E> observer : this.dataSourceObservers)
			observer.changed(this);
	}
}
