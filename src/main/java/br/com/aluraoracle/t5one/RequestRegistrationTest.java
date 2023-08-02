package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.CustomerDAO;
import br.com.aluraoracle.t5one.dao.ProductDAO;
import br.com.aluraoracle.t5one.dao.RequestDAO;
import br.com.aluraoracle.t5one.model.Customer;
import br.com.aluraoracle.t5one.model.ItemOrdered;
import br.com.aluraoracle.t5one.model.Product;
import br.com.aluraoracle.t5one.model.Request;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class RequestRegistrationTest {
    public static void main(String[] args) {

    }
    private void insertRequest() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(entityManager);

        entityManager.getTransaction().begin();
        Product product = productDAO.searchById(1);
        Customer customer1 = new Customer("Paulo Henrique Santana de Souza",
                "10090739744");
        Request request1 = new Request(customer1);
        request1.addItem(new ItemOrdered(10, request1, product));
        RequestDAO requestDAO = new RequestDAO(entityManager);
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        customerDAO.insert(customer1);
        requestDAO.insert(request1);
        entityManager.getTransaction().commit();
    }
}
