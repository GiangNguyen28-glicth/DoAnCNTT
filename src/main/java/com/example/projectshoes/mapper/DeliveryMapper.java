package com.example.projectshoes.mapper;

import com.example.projectshoes.model.DeliveryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryMapper implements RowMapper<DeliveryModel>{
    @Override
    public DeliveryModel mapRow(ResultSet rs) {
        DeliveryModel deliveryModel=new DeliveryModel();
        try{
            deliveryModel.setId(rs.getLong("id"));
            deliveryModel.setName(rs.getString("name"));
            deliveryModel.setShipper(rs.getString("shipper"));
            deliveryModel.setStatus(rs.getString("status"));
            deliveryModel.setDeliveryDate(rs.getDate("delivery_date"));
            deliveryModel.setCreatedDate(rs.getTimestamp("createddate"));
            deliveryModel.setCreatedBy(rs.getString("createdby"));
            deliveryModel.setModifiedBy(rs.getString("modifiedby"));
            deliveryModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            return deliveryModel;
        }catch (SQLException e){
            System.out.println("Failed");
            return null;
        }
    }
}
