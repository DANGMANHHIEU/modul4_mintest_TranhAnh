package com.example.tranh.repository;

import com.example.tranh.model.Category;
import com.example.tranh.model.Painting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
//    List<Painting> findByNameCategory(Category category);
}
