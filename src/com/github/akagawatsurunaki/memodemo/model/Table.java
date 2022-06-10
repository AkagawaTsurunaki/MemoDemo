package com.github.akagawatsurunaki.memodemo.model;

import java.util.ArrayList;
import java.util.List;

public class Table<T extends MemoDemoObject> {
	int idCount = 0;
	List<T> dataList = new ArrayList<T>();

	public List<T> getDataList() {
		return dataList;
	}

	public void add(T data) {

		if (cover(data)) {

			int index = getIndexById(data.getId());
			dataList.remove(index);
			dataList.add(index, data);
			return;
		}
		idCount++;
		data.setId(idCount);
		dataList.add(data);
	}

	private boolean cover(T data) {

		T t = findDataById(data.getId());
		if (t == null) {
			return false;
		}
		return true;

	}

	private int getIndexById(int id) {
		int i = 0;
		for (T t : dataList) {
			if (t.getId() == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public T findDataById(int id) {
		for (T t : dataList) {
			if (t.getId() == id) {
				return t;
			}
		}
		return null;
	}

	public boolean removeDataById(int id) {
		return dataList.remove(findDataById(id));
	}

}
