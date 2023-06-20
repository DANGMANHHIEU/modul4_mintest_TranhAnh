package com.example.tranh.service.painting;

import com.example.tranh.model.Category;
import com.example.tranh.model.Painting;
import com.example.tranh.service.IGeneric;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPaintingService extends IGeneric<Painting> {
    Iterable<Painting> findByName(String name);
    Iterable<Painting> findAllByCategoryList(Category category);
}
