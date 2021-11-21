package com.example.projectshoes.dao.impl;

import com.example.projectshoes.dao.IRoleDAO;
import com.example.projectshoes.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {

    @Override
    public void insertRole(RoleModel roleModel) {
        System.out.println("Insert: " + save(roleModel));
    }

    @Override
    public RoleModel findRoleById(Long id) {
        setType(RoleModel.class);
        return findById(id);
    }

}
