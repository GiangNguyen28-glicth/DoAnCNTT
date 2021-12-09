package com.example.projectshoes.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity(name = "Delivery")
@Table(name = "delivery")
public class DeliveryModel extends AbstractModel<DeliveryModel> implements Serializable {

  @Column(name = "shipper")
  private String shipper;
  @Column(name = "status")
  private String status;
  @Column(name = "deliverydate")
  private Date deliveryDate;
  @Column(name = "name")
  private String name;
  @Column(name = "address")
  private String address;

  @Column(name = "phonenumber")
  private String phonenumber;

  @Column(name = "fullname")
  private String fullname;

  @OneToMany(mappedBy = "delivery",
          cascade = CascadeType.ALL,
          orphanRemoval = true)
  private List<SaledetailModel> saledetails = new ArrayList<>();

  public List<SaledetailModel> getSaledetails() {
    return saledetails;
  }

  public void setSaledetails(List<SaledetailModel> saledetails) {
    this.saledetails = saledetails;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShipper() {
    return shipper;
  }

  public void setShipper(String shipper) {
    this.shipper = shipper;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }
  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }
}
