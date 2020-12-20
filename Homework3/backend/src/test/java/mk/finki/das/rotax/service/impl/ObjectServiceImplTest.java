package mk.finki.das.rotax.service.impl;

import mk.finki.das.rotax.model.Category;
import mk.finki.das.rotax.model.Object;
import mk.finki.das.rotax.repository.CategoryRepository;
import mk.finki.das.rotax.repository.ObjectRepository;
import mk.finki.das.rotax.service.ObjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class ObjectServiceImplTest {

    ObjectService objectService;

    @Mock
    ObjectRepository objectRepository;

    @Mock
    CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectService = new ObjectServiceImpl(objectRepository, categoryRepository);
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        Object object = Object.builder().objectId(1L).build();

        when(objectRepository.findById(anyLong())).thenReturn(Optional.of(object));

        Object objectReturned = objectService.findById(1L);
        assertNotNull(objectReturned);
        verify(objectRepository).findById(anyLong());
        verify(objectRepository, never()).findAll();
    }

    @Test
    void saveObject() {
    }

    @Test
    void deleteById() {
        objectService.deleteById(1L);
        verify(objectRepository, times(1)).deleteById(anyLong());
    }

    @Test
    void findByName() {
        Set<Object> objectSet = new HashSet<>();
        objectSet.add(Object.builder().objectId(1L).name("Object1").build());
        objectSet.add(Object.builder().objectId(2L).name("2Object").build());

        when(objectRepository.findByNameIgnoreCaseContaining(anyString())).thenReturn(objectSet);

        Set<Object> objects = objectService.findByName("obj");
        assertNotNull(objects);
        assertEquals(objects.size(), 2);
        verify(objectRepository).findByNameIgnoreCaseContaining(anyString());
    }

    @Test
    void findByCity() {
        Set<Object> objectSet = new HashSet<>();
        objectSet.add(Object.builder().objectId(1L).address("Skopje, 1000").build());
        objectSet.add(Object.builder().objectId(2L).address("1000, skopje").build());

        when(objectRepository.findByAddressIgnoreCaseContaining(anyString())).thenReturn(objectSet);

        Set<Object> objects = objectService.findByCity("skop");
        assertNotNull(objects);
        assertEquals(objects.size(), 2);
        verify(objectRepository).findByAddressIgnoreCaseContaining(anyString());
    }

    @Test
    void findByCategoryName() {
        Category category = Category.builder().categoryId(1L).name("Hotel").build();

        Set<Object> objectSet = new HashSet<>();
        objectSet.add(Object.builder().objectId(1L).category(category).build());
        objectSet.add(Object.builder().objectId(2L).category(category).build());

        when(objectRepository.findByCategory(any())).thenReturn(objectSet);

        Set<Object> objects = objectService.findByCategoryName("hotel");
        assertNotNull(objects);
        assertEquals(objects.size(), 2);
        verify(objectRepository).findByCategory(any());
    }

    @Test
    void findBySmokingType() {
        Set<Object> objectSet = new HashSet<>();
        objectSet.add(Object.builder().objectId(1L).smokingType(true).build());
        objectSet.add(Object.builder().objectId(2L).smokingType(true).build());

        when(objectRepository.findBySmokingType(anyBoolean())).thenReturn(objectSet);

        Set<Object> objects = objectService.findBySmokingType(true);
        assertNotNull(objects);
        assertEquals(objects.size(), 2);
        verify(objectRepository).findBySmokingType(anyBoolean());
    }

    @Test
    void findByOutdoorSeating() {
        Set<Object> objectSet = new HashSet<>();
        objectSet.add(Object.builder().objectId(1L).outdoorSeating(true).build());
        objectSet.add(Object.builder().objectId(2L).outdoorSeating(true).build());

        when(objectRepository.findByOutdoorSeating(anyBoolean())).thenReturn(objectSet);

        Set<Object> objects = objectService.findByOutdoorSeating(true);
        assertNotNull(objects);
        assertEquals(objects.size(), 2);
        verify(objectRepository).findByOutdoorSeating(anyBoolean());
    }
}