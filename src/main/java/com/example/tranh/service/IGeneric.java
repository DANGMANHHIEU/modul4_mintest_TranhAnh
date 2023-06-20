package com.example.tranh.service;

import java.util.List;
import java.util.Optional;

public interface IGeneric<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
