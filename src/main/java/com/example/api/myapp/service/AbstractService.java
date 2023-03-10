package com.example.api.myapp.service;

import com.example.api.myapp.repository.AbstractRepository;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;


public interface AbstractService<T, ID, R extends AbstractRepository<T, ID>> {

	public default T create(T entity) {
		return getRepository().save(entity);
	}
	
	public default T findById(ID id) throws NotFoundException {
		Optional<T> object = getRepository().findById(id);
		
		if (object.isEmpty()) {
			throw new NotFoundException(MessageFormat.format("Typed object {0} with identifier {1} cannot be found.", getRepository().getPersistentClass().getSimpleName(), id));
		}
		
		return object.get();
	}
	
	public default boolean existsById(ID id) {
		return getRepository().existsById(id);
	}
	
	public default T updateById(T entity, ID id) throws NotFoundException {
		if (!existsById(id)) {
			throw new NotFoundException(MessageFormat.format("Typed object {0} with identifier {1} cannot be found.", getRepository().getPersistentClass().getSimpleName(), id));
		}
		return getRepository().save(entity);
	}
	
	public default void deleteById(ID id) throws NotFoundException {
		Optional<T> object = getRepository().findById(id);
		
		if (object.isEmpty()) {
			throw new NotFoundException(MessageFormat.format("Typed object {0} with identifier {1} cannot be found.", getRepository().getPersistentClass().getSimpleName(), id));
		}
		getRepository().deleteById(id);
	}
	
	public default Page<T> findAllByOrderByIdAsc(Specification<T> specification, Pageable pageable, Boolean unpaged) {
		if (Boolean.TRUE.equals(unpaged)) {
			pageable = PageRequest.of(0, Integer.MAX_VALUE, pageable.getSort());
		}
		
		return getRepository().findAll(specification,  pageable);
	}
	
	public default List<T> findAllByOrderByIdAsc() {
		return getRepository().findAll();
	}
	
	public default List<T> findAllByOrderByIdAsc(Specification<T> specification) {
		return getRepository().findAll(specification);
	}
	
	public abstract R getRepository();
}
