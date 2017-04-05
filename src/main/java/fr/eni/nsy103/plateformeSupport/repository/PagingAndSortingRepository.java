package fr.eni.nsy103.plateformeSupport.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface PagingAndSortingRepository<T,ID extends Serializable> extends CrudRepository<T,ID>{
	List<T> findAll(Sort sort);
	Page<T> findAll(Pageable pageable);
}
