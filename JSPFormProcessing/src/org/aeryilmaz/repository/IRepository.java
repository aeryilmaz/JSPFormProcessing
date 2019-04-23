package org.aeryilmaz.repository;

import java.util.Optional;

public interface IRepository<E, ID> {
	<T extends E> T save(T t);
	Iterable<? extends E> findAll();
	Optional<E> findById(ID id);
	//...
}
