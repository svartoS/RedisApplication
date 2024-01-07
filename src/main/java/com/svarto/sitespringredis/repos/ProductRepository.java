package com.svarto.sitespringredis.repos;

import com.svarto.sitespringredis.Product;
import com.svarto.sitespringredis.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByTitle(String title);
    List<Product> findByUser_id(Long id);

}