package com.book.springreact.persistance;

import com.book.springreact.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrand(String brand);

    List<Car> findByColor(@Param("color") String color);
}