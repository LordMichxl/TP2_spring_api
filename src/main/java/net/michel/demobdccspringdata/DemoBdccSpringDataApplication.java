package net.michel.demobdccspringdata;

import net.michel.demobdccspringdata.entities.Product;
import net.michel.demobdccspringdata.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoBdccSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBdccSpringDataApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args ->{
            Product p1 = new Product();
            p1.setName("Computer");
            p1.setPrice(3400);
            p1.setQuantity(2);
            Product p2 = new Product(null, "Printer", 1200,13);
            Product p3 = Product.builder()
                    .name("Smart phone").price(1300).quantity(4)
                    .build();
            productRepository.save(p1);
            productRepository.save(p2);
            productRepository.save(p3);

            List<Product> products = productRepository.findAll();
            products. forEach (p->{
                System.out.println(p.toString());

            });

        };
    }

}
