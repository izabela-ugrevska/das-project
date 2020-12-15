package mk.finki.das.rotax.repository;

import mk.finki.das.rotax.model.Category;
import mk.finki.das.rotax.model.Object;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;
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
        Optional<Object> objectOptional = objectRepository.findByNameIgnoreCaseContaining(name);

        assertEquals(object, objectOptional.get());
        assertThat(objectOptional.get().getName(), containsStringIgnoringCase(name));
    }

    @Test
    void findByAddressContaining() {
        String address = "city";
        Optional<Object> objectOptional = objectRepository.findByAddressIgnoreCaseContaining(address);

        assertEquals(object, objectOptional.get());
        assertThat(objectOptional.get().getAddress(), containsStringIgnoringCase(address));
    }

    @Test
    void findByCategoryName() {
        String name = "category1";
        Optional<Object> objectOptional = objectRepository.findByCategoryNameIgnoreCase(name);

        assertThat(objectOptional.get().getCategory().getName(), containsStringIgnoringCase(name));
    }

    @Test
    void findBySmokingType() {
        Optional<Object> objectOptional = objectRepository.findBySmokingType(true);
        Optional<Object> objectNull = objectRepository.findBySmokingType(false);

        assertEquals(object, objectOptional.get());
        assertTrue(objectNull.isEmpty());
    }

    @Test
    void findByOutdoorSeating() {
        Optional<Object> objectOptional = objectRepository.findByOutdoorSeating(true);
        Optional<Object> objectNull = objectRepository.findByOutdoorSeating(false);

        assertEquals(object, objectOptional.get());
        assertTrue(objectNull.isEmpty());
    }
}