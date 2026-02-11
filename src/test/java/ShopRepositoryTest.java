import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void deletingOneProductById() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 10_000);
        Product product2 = new Product(2, "хлеб", 50);
        Product product3 = new Product(3, "компьютер", 100_000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void deletingOneProductWithANonExistentId() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 10_000);
        Product product2 = new Product(2, "хлеб", 50);
        Product product3 = new Product(3, "компьютер", 100_000);
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(123));
    }
}
