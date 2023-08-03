package br.com.aluraoracle.t5one.vo;

import java.time.LocalDate;

public class SalesReportVo {
    private String nameProduct;
    private Long salesQuantity;
    private LocalDate lastSaleDate;

    public SalesReportVo() {
    }

    public SalesReportVo(String nameProduct, Long salesQuantity, LocalDate lastSaleDate) {
        this.nameProduct = nameProduct;
        this.salesQuantity = salesQuantity;
        this.lastSaleDate = lastSaleDate;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Long getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Long salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public LocalDate getLastSaleDate() {
        return lastSaleDate;
    }

    public void setLastSaleDate(LocalDate lastSaleDate) {
        this.lastSaleDate = lastSaleDate;
    }

    @Override
    public String toString() {
        return "SalesReportVo{" +
                "nameProduct= '" + nameProduct + '\'' +
                ", dalesQuantity= " + salesQuantity +
                ", lastSaleDate= " + lastSaleDate +
                '}';
    }
}
