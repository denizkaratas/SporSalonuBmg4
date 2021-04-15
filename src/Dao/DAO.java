package Dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cypher
 */
public interface DAO<T> {
	void create(T o);
	void update(T o);
	ArrayList<T> list();
	List<T> pagedList(int page,int lic);
	void delete(T o);
	T detail(Long id);
}




