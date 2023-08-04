package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.CustomerDAO;
import br.com.aluraoracle.t5one.dao.ProductDAO;
import br.com.aluraoracle.t5one.dao.RequestDAO;
import br.com.aluraoracle.t5one.model.ItemOrdered;
import br.com.aluraoracle.t5one.model.Request;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class RequestInsertTest {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        CustomerDAO customerDAO = new CustomerDAO(entityManager);
        Request requestPaulo = new Request(customerDAO.searchById(1));
        Request requestGabriela = new Request(customerDAO.searchById(2));
        Request requestAnaRafaela = new Request(customerDAO.searchById(3));
        Request requestMaria = new Request(customerDAO.searchById(4));

        ProductDAO  productDAO = new ProductDAO(entityManager);
        RequestDAO requestDAO = new RequestDAO(entityManager);

        requestPaulo.addItem(new ItemOrdered(2, requestPaulo,
                productDAO.searchById(1)));
        requestPaulo.addItem(new ItemOrdered(1, requestPaulo,
                productDAO.searchById(5)));
        requestPaulo.addItem(new ItemOrdered(2, requestPaulo,
                productDAO.searchById(9)));
        requestPaulo.addItem(new ItemOrdered(2, requestPaulo,
                productDAO.searchById(13)));

        requestGabriela.addItem(new ItemOrdered(1, requestGabriela,
                productDAO.searchById(2)));
        requestGabriela.addItem(new ItemOrdered(2, requestGabriela,
                productDAO.searchById(6)));
        requestGabriela.addItem(new ItemOrdered(1, requestGabriela,
                productDAO.searchById(10)));
        requestGabriela.addItem(new ItemOrdered(1, requestGabriela,
                productDAO.searchById(14)));

        requestAnaRafaela.addItem(new ItemOrdered(2, requestAnaRafaela,
                productDAO.searchById(3)));
        requestAnaRafaela.addItem(new ItemOrdered(1, requestAnaRafaela,
                productDAO.searchById(7)));
        requestAnaRafaela.addItem(new ItemOrdered(3, requestAnaRafaela,
                productDAO.searchById(11)));
        requestAnaRafaela.addItem(new ItemOrdered(1, requestAnaRafaela,
                productDAO.searchById(15)));

        requestMaria.addItem(new ItemOrdered(1, requestMaria,
                productDAO.searchById(4)));
        requestMaria.addItem(new ItemOrdered(1, requestMaria,
                productDAO.searchById(8)));
        requestMaria.addItem(new ItemOrdered(1, requestMaria,
                productDAO.searchById(12)));
        requestMaria.addItem(new ItemOrdered(1, requestMaria,
                productDAO.searchById(16)));

        entityManager.getTransaction().begin();

        requestDAO.insert(requestPaulo);
        requestDAO.insert(requestGabriela);
        requestDAO.insert(requestAnaRafaela);
        requestDAO.insert(requestMaria);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
