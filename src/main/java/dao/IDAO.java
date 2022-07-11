package dao;

import java.util.ArrayList;

public interface IDAO <T> {
	public boolean create(T object);
	public ArrayList<T> read();
//	public boolean update(String s, T object);
	public void remove(T object);
}