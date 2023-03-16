package dev.wcs.nad.tariffmanager.customer;

import dev.wcs.nad.tariffmanager.customer.model.Customer;
import dev.wcs.nad.tariffmanager.customer.importing.CustomerImporter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerImporterTest {

    @Test
    public void shouldImportCsvToCustomerObjectModelNoSpringContext() {
        File customerCsv = new File("src/test/resources/testdata/customer.csv");
        // We are manually instantiating the CustomerImporter here as we have no Spring
        // context in plain Unit tests
        CustomerImporter customerImporter = new CustomerImporter(15, 10);
        List<Customer> importedCustomers = customerImporter.importCustomers(customerCsv);
        assertThat(importedCustomers.get(2).calculateDiscountedPrice(10)).isEqualTo(9);
        // Challenge: After adding the Property with value 10, this test should succeed
        // assertThat(importedCustomers.get(0).calculateDiscountedPrice(100)).isEqualTo(90);
    }

    @Test
    public void shouldMapObjectsToDto() {
        // Challenge: Add the Entity to Dto mapping here.
        // We are manually instantiating the CustomerImporter here as we have no Spring
        // context in plain Unit tests
        CustomerImporter customerImporter = new CustomerImporter(15, 10);
        List<Customer> importedCustomers = customerImporter
                .importCustomers(new File("src/test/resources/testdata/customer.csv"));
        assertThat(importedCustomers.get(1).calculateDiscountedPrice(100)).isEqualTo(90);
    }

}