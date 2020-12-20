package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.Category;
import mk.finki.das.rotax.repository.CategoryRepository;
import mk.finki.das.rotax.service.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {

    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    void findAll() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(Category.builder().categoryId(1L).build());
        categoryList.add(Category.builder().categoryId(2L).build());

        when(categoryRepository.findAll()).thenReturn(categoryList);

        Set<Category> categories = categoryService.findAll();
        assertEquals(categories.size(), 2);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Category category = Category.builder().categoryId(1L).build();

        when(categoryRepository.findById(anyLong())).thenReturn(Optional.of(category));

        Category categoryReturned = categoryService.findById(1L);
        assertNotNull(categoryReturned);
        verify(categoryRepository).findById(anyLong());
        verify(categoryRepository, never()).findAll();
    }

    @Test
    void deleteById() {
        categoryService.deleteById(1L);
        verify(categoryRepository, times(1)).deleteById(anyLong());
    }

}