package com.example.projectshoes.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Saledetail")
@Table(name = "saledetail")
public class SaledetailModel extends AbstractModel<SaledetailModel> implements Serializable{

    @Transient
    private Long userId;
    //  @Column(name = "product_id")
    @Transient
    private Long productId;
    //  @Column(name = "delivery_id")
    @Transient
    private Long deliveryId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "total")
    private Float total;

    @Column(name = "code")
    private Long code;
    @Column(name = "status_delivery")
    private String status_delivery;

    @ManyToOne(targetEntity = UserModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserModel user;

    @ManyToOne(targetEntity = DeliveryModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    private DeliveryModel delivery;

    @ManyToOne(targetEntity = ProductModel.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private ProductModel product;

    public SaledetailModel() {
    }

    public UserModel getUser() {
      if (this.user == null) {
        user = new UserModel();
      }
      return user;
    }

    public void setUser(UserModel user) {
      this.user = user;
    }

    public DeliveryModel getDelivery() {
      if (this.delivery == null) {
        delivery = new DeliveryModel();
      }
      return delivery;
    }

    public void setDelivery(DeliveryModel delivery) {
      this.delivery = delivery;
    }

    public Long getUserId() {
      return userId;
    }

    public void setUserId(Long userId) {
      this.userId = userId;
    }

    public Long getProductId() {
      return productId;
    }

    public void setProductId(Long productId) {
      this.productId = productId;
    }

    public Long getDeliveryId() {
      return deliveryId;
    }

    public int getQuantity() {
      return quantity;
    }

    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }

    public Float getTotal() {
      return total;
    }

    public void setTotal(Float total) {
      this.total = total;
    }

    public String getStatus_delivery() {
      return status_delivery;
    }

    public void setStatus_delivery(String status_delivery) {
      this.status_delivery = status_delivery;
    }

    public void setDeliveryId(Long deliveryId) {
      this.deliveryId = deliveryId;
    }


    public Long getCode() {
      return code;
    }

    public void setCode(Long code) {
      this.code = code;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
  }
