package com.example.api.myapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@NoRepositoryBean
public interface AbstractRepository<T, ID> extends CrudRepository<T, ID>, PagingAndSortingRepository<T, ID> {
	Page<T> findAll(Specification<T> specification, Pageable pageable);
	
	List<T> findAll();
	
	List<T> findAll(Specification<T> specification);
	
	Class<T> getPersistentClass();
}
