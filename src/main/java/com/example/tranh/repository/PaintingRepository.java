package com.example.tranh.repository;

import com.example.tranh.model.Category;
import com.example.tranh.model.Painting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaintingRepository extends CrudRepository<Painting,Long> {

    List<Painting> findAllByCategoryList(Category category);

    //tìm kiếm theo tên
    @Query("SELECT p FROM Painting p WHERE p.namePainting like %:name%")
    List<Painting> findByName(@Param("name") String name);
}
