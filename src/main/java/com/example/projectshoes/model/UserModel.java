package com.example.projectshoes.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NaturalId;

@Entity(name = "User")
@Table(name = "user")
public class UserModel extends AbstractModel<UserModel> implements Serializable {

  @Column(name = "username")
  @NaturalId
  private String username;
  @Column(name = "password")
  private String password;
  @Transient
  private String repassword;
  @Column(name = "email")
  private String email;
  @Column(name = "status")
  private String status;
  @Column(name = "avatar")
  @Lob
  private String avatar;
  @Column(name = "role_id")
  private Long roleId;

  @OneToOne(mappedBy = "user")
  private CustomerModel customer;

  @OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
  private SaledetailModel saleDetail;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  @Cascade(value = {CascadeType.REMOVE, CascadeType.PERSIST})

  Set<RoleModel> roles = null;

  @Transient
  private RoleModel role = new RoleModel();

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public RoleModel getRole() {
    return role;
  }

  public void setRole(RoleModel role) {
    this.role = role;
  }

  public String getRepassword() {
    return repassword;
  }

  public void setRepassword(String repassword) {
    this.repassword = repassword;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Set<RoleModel> getRoles() {
    if (roles == null) {
      roles = new HashSet<RoleModel>();
    }
    return roles;
  }

  public void setRoles(Set<RoleModel> roles) {
    this.roles = roles;
  }

  public CustomerModel getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerModel customer) {
    this.customer = customer;
  }

  public SaledetailModel getSaleDetail() {
    return saleDetail;
  }

  public void setSaleDetail(SaledetailModel saleDetail) {
    this.saleDetail = saleDetail;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "UserModel{" +
        "username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", repassword='" + repassword + '\'' +
        ", email='" + email + '\'' +
        ", avatar='" + avatar + '\'' +
        ", roleId=" + roleId +
        ", customer=" + customer +
        ", saleDetail=" + saleDetail +
        ", roles=" + roles +
        ", role=" + role +
        '}';
  }
}
