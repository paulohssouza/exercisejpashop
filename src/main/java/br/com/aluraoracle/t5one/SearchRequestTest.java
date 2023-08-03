package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.RequestDAO;
import br.com.aluraoracle.t5one.util.JPAUtil;
import br.com.aluraoracle.t5one.vo.SalesReportVo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SearchRequestTest {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        RequestDAO requestDAO = new RequestDAO(entityManager);
        System.out.println("Valor total das vendas: " + requestDAO.totalValueSold());
        System.out.println("-----------------------------------------------");

        List<SalesReportVo> salesReport = requestDAO.generateSalesReport();
        salesReport.forEach(System.out :: println);
    }
}
