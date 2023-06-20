package com.example.tranh.controller;

import com.example.tranh.model.Category;
import com.example.tranh.model.Painting;
import com.example.tranh.service.category.ICategoryService;
import com.example.tranh.service.painting.IPaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/painting")
public class PaintingController {
    @Autowired
    private IPaintingService paintingService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Painting>> findAll(){
        Iterable<Painting> paintingList = paintingService.findAll();
        return new ResponseEntity<>(paintingList, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Painting>> deletePainting(@PathVariable Long id){
        paintingService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Painting> createPainting(@RequestBody Painting painting){
        return  new ResponseEntity<>(paintingService.save(painting),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Painting>> view(@PathVariable Long id){
      Optional<Painting> painting = paintingService.findById(id);
      return new ResponseEntity<>(painting,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Painting>> updatePainting(@PathVariable Long id,@RequestBody Painting painting){
        Optional<Painting> painting1 = paintingService.findById(id);
        if(!painting1.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        painting.setId(painting1.get().getId());
        paintingService.save(painting);
        return new ResponseEntity<>(HttpStatus.OK);
    }

     // tìm kiếm theo tên
    @GetMapping("/search")
    public ResponseEntity<Iterable<Painting>> findByName(@RequestParam String name){
        Iterable<Painting> paintings = paintingService.findByName(name);
        return new ResponseEntity<>(paintings,HttpStatus.OK);
    }

    //tìm kiếm theo danh muc
    @GetMapping("/searchCategory/{id}")
    public ResponseEntity<Iterable<Painting>> findByNameCategory(@PathVariable Long id){
        Category category = categoryService.findById(id).orElse(null);
        if(category != null){
            Iterable<Painting> paintings = paintingService.findAllByCategoryList(category);
            if(paintings != null){
                return new ResponseEntity<>(paintings,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
