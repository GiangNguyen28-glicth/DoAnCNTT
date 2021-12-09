package com.example.projectshoes.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity(name = "Product")
@Table(name = "product")
public class ProductModel extends AbstractModel<ProductModel> implements Serializable {
  @Column(name = "name")
  private String name;
  @Column(name = "price")
  private Float price;
//  @Column(name = "category_id")
  @Transient
  private Long categoryId;
  @Column(name = "size")
  private int size;
  @Column(name = "quantity")
  private int quantity;

  @Override
  public String getAvatar() {
    return avatar;
  }

  @Override
  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  @Column(name = "avatar")
  @Lob
  private String avatar;

  @ManyToOne(targetEntity = CategoryModel.class, fetch = FetchType.EAGER)
  @JoinColumn(name = "category_id")
  private CategoryModel category;

  @OneToMany(mappedBy = "product",
          cascade = CascadeType.ALL,
          orphanRemoval = true)
  private List<SaledetailModel> saledetails = new ArrayList<>();

  public List<SaledetailModel> getSaledetails() {
    return saledetails;
  }
  public void setSaledetails(List<SaledetailModel> saledetails) {
    this.saledetails = saledetails;
  }
  public CategoryModel getCategory() {
    return category;
  }

  public void setCategory(CategoryModel category) {
    this.category = category;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

}
