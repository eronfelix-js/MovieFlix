package com.felixDev.movieFliex.Service;

import com.felixDev.movieFliex.Entity.Category;
import com.felixDev.movieFliex.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category criarCategoria(Category category){
        return categoryRepository.save(category);
    }

    public List<Category> listarTodasCategoria(){
       return categoryRepository.findAll();

    }

    public Optional<Category> listarPorID(long id){
      Optional<Category> categoriaExistente = categoryRepository.findById(id);
      return categoriaExistente;
    }

    public void deletarCategoria(long id){
        categoryRepository.deleteById(id);
    }

    public Category alterarCategoria(long id, Category category){
       Optional<Category> categoriaExistente = categoryRepository.findById(id);
        if (categoriaExistente.isPresent()) {

        }
        return null;
    }

}
