package com.example.projectshoes.service;

import com.example.projectshoes.model.RoleModel;

public interface IRoleService {

    Long save(RoleModel role);

    RoleModel findRoleById(Long id);
}
