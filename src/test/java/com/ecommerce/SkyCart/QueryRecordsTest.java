package com.ecommerce.SkyCart;

import com.ecommerce.SkyCart.domain.Product;
import org.junit.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootTest
public class QueryRecordsTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence
                .createEntityManagerFactory("Ecommerce-PU");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        entityManagerFactory.close();
    }

    @Before
    public void setUp() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @Test
    public void searchByIdentifier() {
        Product product = entityManager.find(Product.class, 1);
        Integer identifier = 1;

        Assert.assertEquals(product.getIdProduct(), identifier);
        Assert.assertNotNull(product);
    }
    @Test
    public void searchByIdentifierNotNull() {
       Product product = entityManager.find(Product.class, 1);

        Assert.assertNotNull(product);
    }

    @Test
    public void searchByIdentifierForName() {
        Product product = entityManager.find(Product.class, 1);

        Assert.assertEquals("Kindle", product.getName());
    }

    @Test
    public void testUpdateReference() {
        Product product = entityManager.find(Product.class, 1);
        product.setName("Nintendo");
        entityManager.refresh(product);
        Assert.assertEquals("Kindle", product.getName());

    }
}