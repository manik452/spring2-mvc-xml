package com.mkyong.common.controller.database;

import com.mkyong.common.controller.model.LoginModel;
import com.mkyong.common.controller.model.LoginResponseModel;
import org.springframework.stereotype.Component;

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

    public void insert(LoginModel customer) {

        String sql = "INSERT INTO SSL_REQUEST_ACTIVITY " +
                "(merchant_key,sslRef_id,merchant_name,product_price) VALUES (?, ?, ?,?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getMerchantKey());
            ps.setString(2, customer.getSslRefId());
            ps.setString(3, customer.getMerchantName());
            ps.setDouble(4, customer.getProductPrice());
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

    public LoginModel findByCustomerId(String referenceID, String merchantKey) {

        String sql = "SELECT * FROM SSL_REQUEST_ACTIVITY WHERE sslRef_id = ? AND merchant_key = ?";

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, referenceID);
            ps.setString(2, merchantKey);
            LoginModel customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new LoginModel();
               /* customer = new LoginResponseModel(
                        rs.getInt("CUST_ID"),
                        rs.getString("NAME"),
                        rs.getInt("Age")
                );*/
            }
            rs.close();
            ps.close();
            return customer;
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