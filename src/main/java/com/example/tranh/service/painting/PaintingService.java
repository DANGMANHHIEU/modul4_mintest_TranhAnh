package com.example.tranh.service.painting;

import com.example.tranh.model.Category;
import com.example.tranh.model.Painting;
import com.example.tranh.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaintingService implements IPaintingService {
    @Autowired
    private PaintingRepository paintingRepository;
    @Override
    public Iterable<Painting> findAll() {
        return paintingRepository.findAll();
    }

    @Override
    public Optional<Painting> findById(Long id) {
        return paintingRepository.findById(id);
    }

    @Override
    public Painting save(Painting painting) {
        return paintingRepository.save(painting);
    }

    @Override
    public void remove(Long id) {
     paintingRepository.deleteById(id);
    }

    // tìm kiếm theo tên
    @Override
    public Iterable<Painting> findByName(String name){
        return paintingRepository.findByName(name);
    }

    @Override
    public Iterable<Painting> findAllByCategoryList(Category category) {
        return paintingRepository.findAllByCategoryList(category);
    }
}
