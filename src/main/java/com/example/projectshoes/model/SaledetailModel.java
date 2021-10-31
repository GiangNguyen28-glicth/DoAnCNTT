package com.example.projectshoes.model;

public class SaledetailModel extends AbstractModel<SaledetailModel>{
    private Long userId;
    private Long productId;
    private Long deliveryId;
    private int quantity;
    private Float total;
    private String status_delivery;
    private UserModel user = new UserModel();
    private DeliveryModel delivery= new DeliveryModel();

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public DeliveryModel getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryModel delivery) {
        this.delivery = delivery;
    }

    public Long getUserId() {return userId;}

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

}
