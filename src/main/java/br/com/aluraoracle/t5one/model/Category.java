package br.com.aluraoracle.t5one.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbcategory")
public class Category {
    @EmbeddedId
    private CategoryID categoryID;

    public Category() {
    }

    public Category(String name) {
        this.categoryID = new CategoryID(name);
    }

    public CategoryID getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(CategoryID categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "\n" + this.categoryID +
                "\n---------------------------------";
    }
}
