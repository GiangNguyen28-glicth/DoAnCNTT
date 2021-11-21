package com.example.projectshoes.dao;

import com.example.projectshoes.model.RoleModel;

public interface IRoleDAO extends GenericDAO<RoleModel> {

    void insertRole(RoleModel roleModel);

    RoleModel findRoleById(Long id);


}
