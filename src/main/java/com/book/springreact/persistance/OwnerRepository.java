package com.book.springreact.persistance;

import com.book.springreact.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
