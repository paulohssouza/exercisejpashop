package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.RequestDAO;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SearchRequestTest {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        RequestDAO requestDAO = new RequestDAO(entityManager);
        System.out.println("Valor total das vendas: " + requestDAO.totalValueSold());

        List<Object[]> salesReport = requestDAO.generateSalesReport();
        for (Object[] object: salesReport) {
            System.out.println(object[0]);
            System.out.println(object[1]);
            System.out.println(object[2]);
        }
    }
}
