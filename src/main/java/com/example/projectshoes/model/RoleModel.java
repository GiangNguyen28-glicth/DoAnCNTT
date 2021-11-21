package com.example.projectshoes.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Role")
@Table(name = "role")
public class RoleModel extends AbstractModel<RoleModel> implements Serializable {

  @Column(name = "name")
  private String name;
  @Column(name = "code")
  private String code;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "RoleModel{" +
        "name='" + name + '\'' +
        ", code='" + code + '\'' +
        '}';
  }
}
