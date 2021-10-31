package com.example.projectshoes.mapper;

import com.example.projectshoes.model.SaledetailModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaledetailMapper implements RowMapper<SaledetailModel>{

    @Override
    public SaledetailModel mapRow(ResultSet rs) {
        SaledetailModel saledetailModel = new SaledetailModel();
        try {
            saledetailModel.setId(rs.getLong("id"));
            saledetailModel.setUserId(rs.getLong("user_id"));
            saledetailModel.setProductId(rs.getLong("product_id"));
            saledetailModel.setDeliveryId(rs.getLong("delivery_id"));
            saledetailModel.setQuantity(rs.getInt("quantity"));
            saledetailModel.setTotal(rs.getFloat("total"));
            saledetailModel.setStatus_delivery(rs.getString("status_delivery"));
            saledetailModel.setCreatedDate(rs.getTimestamp("createddate"));
            saledetailModel.setCreatedBy(rs.getString("createdby"));
            saledetailModel.setModifiedBy(rs.getString("modifiedby"));
            saledetailModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            return saledetailModel;
        }
        catch(SQLException e) {
            return null;
        }
    }
}
