package mk.finki.das.rotax.bootstrap;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import mk.finki.das.rotax.model.Category;
import mk.finki.das.rotax.model.Object;
import mk.finki.das.rotax.repository.CategoryRepository;
import mk.finki.das.rotax.repository.ObjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    private final ObjectRepository objectRepository;

    public DataLoader(CategoryRepository categoryRepository, ObjectRepository objectRepository) {
        this.categoryRepository = categoryRepository;
        this.objectRepository = objectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        readCsvFile();
    }

    private void readCsvFile(){
        // createCategories
        Category cafe = Category.builder().name("Cafe").build();
        Category restaurant = Category.builder().name("Restaurant").build();
        Category market = Category.builder().name("Market").build();
        Category other = Category.builder().name("Other").build();

        // save to db
        categoryRepository.save(cafe);
        categoryRepository.save(restaurant);
        categoryRepository.save(market);
        categoryRepository.save(other);

        // read file
        try {

            Resource resource = new ClassPathResource("static/newfiltered.csv");

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(resource.getURI()));

            // create csv reader
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            // read one record at a time
            String[] record;
            while ((record = csvReader.readNext()) != null) {
                Object object = new Object();
                object.setLongitude(record[1]);
                object.setLatitude(record[2]);
                object.setName(record[3]);

                Optional<Category> category = categoryRepository.findByNameIgnoreCase(record[4]);
                if(category.isPresent()){
                    object.setCategory(category.get());
                } else {
                    object.setCategory(other);
                }

                object.setPhone(record[5]);
                object.setWebsite(record[6]);
                if(record[7].equals("yes")){
                    object.setSmokingType(true);
                } else {
                    object.setSmokingType(false);
                }
                if(record[8].equals("yes")){
                    object.setOutdoorSeating(true);
                } else {
                    object.setOutdoorSeating(false);
                }
                object.setOpeningHours(record[9]);
                object.setAddress(record[10]);
                object.setCuisine(record[11]);

                objectRepository.save(object);
            }

            // close readers
            csvReader.close();
            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
