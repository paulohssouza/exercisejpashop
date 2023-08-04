package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.ProductDAO;
import br.com.aluraoracle.t5one.dao.RequestDAO;
import br.com.aluraoracle.t5one.model.Request;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        //  Visualization of problems caused by lazy behavior in queries.
        Request request = entityManager.find(Request.class, 1L);
//        entityManager.close();
//        System.out.println(request.getCustomer().getName());

        RequestDAO requestDAO = new RequestDAO(entityManager);
        request = requestDAO.searchRequestWithCustomer(1L);
        entityManager.close();
        System.out.println(request.getCustomer().getName());

        entityManager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(entityManager);
        System.out.println(productDAO.searchWithCriteria("Xiaomi Redmi 12", null, null));
    }
}
