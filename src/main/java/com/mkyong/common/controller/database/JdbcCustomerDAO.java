package com.mkyong.common.controller.database;

import com.mkyong.common.controller.model.LoginDataModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;


public class JdbcCustomerDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(LoginDataModel loginDataModel) {

        String sql = "INSERT INTO SSL_REQUEST_ACTIVITY " +
                "(merchant_key,sslRef_id,merchant_name,product_price) VALUES (?, ?, ?,?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, loginDataModel.getMerchantKey());
            ps.setString(2, loginDataModel.getSslRefId());
            ps.setString(3, loginDataModel.getMerchantName());
            ps.setDouble(4, loginDataModel.getProductPrice());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public LoginDataModel findByCustomerId(String referenceID, String merchantKey) {

        String sql = "SELECT * FROM SSL_REQUEST_ACTIVITY WHERE sslRef_id = ? AND merchant_key = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, referenceID);
            ps.setString(2, merchantKey);
            LoginDataModel dataModel = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dataModel = new LoginDataModel(
                        rs.getString("merchant_key"),
                        "",
                        rs.getString("sslRef_id"),
                        rs.getDouble("product_price"),
                        rs.getString("merchant_name")
                        );
            }
            rs.close();
            ps.close();
            return dataModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}