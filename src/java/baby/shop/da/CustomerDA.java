/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.da;

import baby.shop.biz.Cart;
import baby.shop.entity.Customer;
import baby.shop.entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author viquy
 */
public class CustomerDA {
    public List<Customer> ListCustomer() throws ClassNotFoundException, NamingException {
        List<Customer> list = new LinkedList<>();
        try {

            String sql = "SELECT * FROM dbo.customer";
            PreparedStatement ps = DBConnection.makeConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("address"), rs.getFloat("total")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public boolean checkOut(String name,String phone,String address, float total) throws ClassNotFoundException, NamingException {
        int result = 0;
        try {
            String sql = "INSERT dbo.customer( name, phone, address, total )VALUES  (?,?,?, ?)";
            PreparedStatement ps = DBConnection.makeConnection().prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setFloat(4, total);
            result = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CustomerDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result > 0;

    }
}
