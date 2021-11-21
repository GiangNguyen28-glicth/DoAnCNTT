package com.example.projectshoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "Stock")
@Table(name = "stock")
public class StockModel extends AbstractModel<StockModel> implements Serializable {

  //  @Column(name = "product_id")
  @Transient
  private Long productId;
  @Column(name = "amount")
  private Integer amount;

  @OneToMany(mappedBy = "stock",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<ProductModel> product = new ArrayList<>();

  public List<ProductModel> getProduct() {
    return product;
  }

  public void setProduct(List<ProductModel> product) {
    this.product = product;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

}
