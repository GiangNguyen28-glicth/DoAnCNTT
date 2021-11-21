package com.example.projectshoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Category")
@Table(name = "category")
public class CategoryModel extends AbstractModel<CategoryModel> implements Serializable {

  @Column(name = "code")
  private String code;

  @OneToMany(mappedBy = "category",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<ProductModel> products = new ArrayList<>();

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public List<ProductModel> getProducts() {
    return products;
  }

  public void setProducts(List<ProductModel> products) {
    this.products = products;
  }

}
