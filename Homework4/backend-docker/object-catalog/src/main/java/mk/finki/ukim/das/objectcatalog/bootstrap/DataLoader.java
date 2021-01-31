package mk.finki.ukim.das.objectcatalog.bootstrap;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import mk.finki.ukim.das.objectcatalog.model.Category;
import mk.finki.ukim.das.objectcatalog.model.Object;
import mk.finki.ukim.das.objectcatalog.repository.CategoryRepository;
import mk.finki.ukim.das.objectcatalog.repository.ObjectRepository;
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

        // if there are no categories in the database, call readCsvFile() function
        if(categoryRepository.findAll().size() == 0){
            readCsvFile();
        }

    }

    private void readCsvFile(){

        // create categories
        Category cafe = Category.builder().name("Cafe").build();
        Category restaurant = Category.builder().name("Restaurant").build();
        Category market = Category.builder().name("Market").build();
        Category other = Category.builder().name("Other").build();

        // save categories to db
        categoryRepository.save(cafe);
        categoryRepository.save(restaurant);
        categoryRepository.save(market);
        categoryRepository.save(other);

        // try to read csv file and save the objects to database, if unsuccessful throw Exception
        try {

            // create a Resource object from the given path
            Resource resource = new ClassPathResource("static/newfiltered.csv");

            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(resource.getURI()));

            // create csv reader
            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

            // read one record at a time
            String[] record;
            while ((record = csvReader.readNext()) != null) {

                // create one Object for every line in the file
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
