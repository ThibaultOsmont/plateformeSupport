package fr.eni.nsy103.plateformeSupport.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.Repository;

public interface CrudRepository<T,ID extends Serializable> extends Repository<T,ID> {
	public <S extends T> S save(S entity);
	public T findOne(ID primaryKey);
	public List<T> findAll();
	public Long count();
	public void delete(T entity);
	public boolean exists(ID primaryKey);
}
