package com.example.tranh.controller;

import com.example.tranh.model.Category;
import com.example.tranh.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Category>> findAll(){
      Iterable<Category> categoryList =categoryService.findAll();
      return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
      return new ResponseEntity<>(categoryService.save(category),HttpStatus.CREATED);
    }

      @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id){
     Optional<Category> category = categoryService.findById(id);
    return new ResponseEntity<>(category,HttpStatus.OK);
      }

      @PutMapping("/{id}")
    public ResponseEntity<Optional<Category>> updateCategory(@PathVariable Long id,@RequestBody Category category){
      Optional<Category> category1 = categoryService.findById(id);
      if(!category1.isPresent()){
       return new ResponseEntity<>(HttpStatus.OK);
      }
        category.setId(category1.get().getId());
      categoryService.save(category);
      return new ResponseEntity<>(HttpStatus.OK);
      }

      @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Category>> deleteCategory(@PathVariable Long id){
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
      }

}
