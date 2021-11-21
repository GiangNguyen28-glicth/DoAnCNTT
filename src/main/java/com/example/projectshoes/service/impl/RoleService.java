package com.example.projectshoes.service.impl;

import com.example.projectshoes.dao.IRoleDAO;
import com.example.projectshoes.model.RoleModel;
import com.example.projectshoes.service.IRoleService;
import javax.inject.Inject;

public class RoleService implements IRoleService {

    @Inject
    IRoleDAO roleDAO;

    @Override
    public Long save(RoleModel role) {
        return roleDAO.save(role);
    }

    @Override
    public RoleModel findRoleById(Long id) {
        return roleDAO.findRoleById(id);
    }
}
