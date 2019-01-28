import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sales");
        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();
        Product product = new Product();
        product.setName("product");

        Customer customer = new Customer();
        customer.setName("Gosho");
        customer.setEmail("email1");
        customer.setCreditCardNumber("12344554234");


        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName("location1");


        Sale sale1 = new Sale();
        sale1.setCustomer(customer);
        sale1.setProduct(product);
        sale1.setStoreLocation(storeLocation);

        Sale sale2 = new Sale();
        sale2.setCustomer(customer);
        sale2.setProduct(product);
        sale2.setStoreLocation(storeLocation);

        em.persist(sale1);
        em.persist(sale2);

        em.getTransaction().commit();
        em.close();


    }
}
