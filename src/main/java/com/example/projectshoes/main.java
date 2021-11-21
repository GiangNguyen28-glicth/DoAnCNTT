package com.example.projectshoes;

import com.example.projectshoes.model.SaledetailModel;
import com.example.projectshoes.service.ISaledetailService;

import javax.inject.Inject;
import java.util.List;

public class main {
    @Inject
    ISaledetailService saledetailService;
    public void main(String[] args) {
        List<SaledetailModel> saledetailModels=saledetailService.gettop3();
        System.out.println(saledetailModels);
    }
}