package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.Category;
import mk.finki.das.rotax.model.Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ObjectRepositoryTest {

    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    CategoryRepository categoryRepository;

    Object object;

    @BeforeEach
    void setUp() {
        Category category = Category.builder().name("Category1").build();
        Category savedCategory = categoryRepository.save(category);
        object = Object.builder()
                .name("Object1")
                .address("Street 21, City")
                .category(savedCategory)
                .smokingType(true)
                .outdoorSeating(true)
                .build();
        objectRepository.save(object);
    }

    @Test
    void findByNameContaining() {
        String name = "obj";
        Set<Object> objects = objectRepository.findByNameIgnoreCaseContaining(name);

        assertEquals(objects.size(), 1);
    }

    @Test
    void findByAddressContaining() {
        String address = "city";
        Set<Object> objects = objectRepository.findByAddressIgnoreCaseContaining(address);

        assertEquals(objects.size(), 1);
    }

    @Test
    void findByCategoryName() {
        String name = "category1";
        Set<Object> objects = objectRepository.findByCategoryNameIgnoreCase(name);

        assertEquals(objects.size(), 1);
    }

    @Test
    void findBySmokingType() {
        Set<Object> objects = objectRepository.findBySmokingType(true);
        Set<Object> objectNull = objectRepository.findBySmokingType(false);

        assertEquals(objects.size(), 1);
        assertTrue(objectNull.isEmpty());
    }

    @Test
    void findByOutdoorSeating() {
        Set<Object> objects = objectRepository.findByOutdoorSeating(true);
        Set<Object> objectNull = objectRepository.findByOutdoorSeating(false);

        assertEquals(objects.size(), 1);
        assertTrue(objectNull.isEmpty());
    }
}