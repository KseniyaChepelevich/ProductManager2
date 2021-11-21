package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }



    @Test
    void removeByNotFoundId() {
        Book java1 = new Book(1, "Java1", 560, "Jason", 564, 2011);
        Book java2 = new Book(7, "Java2", 569, "Jason", 564, 2012);


        repository.save(java1);
        repository.save(java2);




        assertThrows(NotFoundException.class, () -> {
            repository.removeById(5);
        });




    }

    @Test
    void removeById() {
        Book java1 = new Book(1, "Java1", 560, "Jason", 564, 2011);
        Book java2 = new Book(7, "Java2", 569, "Jason", 564, 2012);
        Book java5 = new Book(3, "Java5", 430, "Jason", 448, 2015);

        repository.save(java1);
        repository.save(java2);
        repository.save(java5);

        repository.removeById(1);

        Product[] expected = new Product[]{java2, java5};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}