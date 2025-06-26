package com.felixDev.movieFliex.Mapper;

import com.felixDev.movieFliex.Controller.Request.CategoryRecord;
import com.felixDev.movieFliex.Controller.Response.CategoryResponse;
import com.felixDev.movieFliex.Entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass //classes utilitarias não podem ser instanciada
public class CategoryMapper {

    public static Category toCategory(CategoryRecord categoryRecord){
        return Category
                .builder()
                .name(categoryRecord.name())
                .build();
    }

    public static CategoryResponse toResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
