package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.CustomerDAO;
import br.com.aluraoracle.t5one.model.Customer;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class CustomerInsertTest {
    public static void main(String[] args) {
        Customer paulo = new Customer("Paulo Henrique",
                "10090739744");
        Customer gabriela = new Customer("Gabriela Santiago",
                "99999999999");
        Customer anaRafaela = new Customer("Ana Rafaela",
                "03621277260");
        Customer maria = new Customer("Maria Sabina",
                "99999999999");
        Customer ademir = new Customer("Ademir de Souza",
                "23376686572");
        Customer daniel = new Customer("Daniel",
                "99999999999");

        EntityManager entityManager = JPAUtil.getEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);

        entityManager.getTransaction().begin();

        customerDAO.insert(paulo);
        customerDAO.insert(gabriela);
        customerDAO.insert(anaRafaela);
        customerDAO.insert(maria);
        customerDAO.insert(ademir);
        customerDAO.insert(daniel);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
