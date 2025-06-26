package com.felixDev.movieFliex.Controller;

import com.felixDev.movieFliex.Controller.Request.CategoryRecord;
import com.felixDev.movieFliex.Controller.Response.CategoryResponse;
import com.felixDev.movieFliex.Entity.Category;
import com.felixDev.movieFliex.Mapper.CategoryMapper;
import com.felixDev.movieFliex.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/criar")
    public ResponseEntity<CategoryResponse> criarCategoria(@Valid @RequestBody CategoryRecord request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category saveCategory = categoryService.criarCategoria(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toResponse(saveCategory));
    }

    @GetMapping("/listartodos")
    public List<CategoryResponse> listarTodos() {
        List<Category> categories = categoryService.listarTodasCategoria();
        return categories.stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<CategoryResponse> listarPorId(@PathVariable long id) {
        return categoryService.listarPorID(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toResponse(category)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> Deletar(@PathVariable long id) {
        categoryService.deletarCategoria(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletado com sucesso");
    }
}
