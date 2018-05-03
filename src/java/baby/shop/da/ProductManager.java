/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.da;

import baby.shop.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viquy
 */
public class ProductManager {
    private static PreparedStatement searchByNameStatement;
    private static PreparedStatement searchByIdStatement;
    private static PreparedStatement getProduct;
    
    private PreparedStatement getSearchByNameStatement() throws ClassNotFoundException, SQLException{
        if(searchByNameStatement == null){
            Connection connection = DBConnection.getConnection();
            searchByNameStatement = connection.prepareStatement("select id,name,price,description from product where name like ?");
        }
        return searchByNameStatement;
    }
    private PreparedStatement getProduct() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getConnection();
        getProduct = connection.prepareStatement("select id,name,price,description from product");
        return getProduct;
    }
    private PreparedStatement getSearchByIDStatement() throws ClassNotFoundException, SQLException{
        if(searchByIdStatement == null){
            Connection connection = DBConnection.getConnection();
            searchByIdStatement = connection.prepareStatement("select name, price, description from product where id=?");
        }
        return searchByIdStatement;
    }
//    public List<Product> showListProduct(String products){
//        try{
//            PreparedStatement statement = getProduct();
//            ResultSet rs = statement.executeQuery();
//            
//            while(rs.next()){
//                String name = rs.getString("name");
//                float price = rs.getFloat("price");
//                String description = rs.getString("description");
//        }catch(Exception ex){
//            Logger.getLogger(baby.shop.da.ProductManager.class.getName()).log(Level.SEVERE, null, ex);
//            return new LinkedList<Product>();
//        }
//    }
    public List<Product> getProductsByName(String keyword){
        try{
            PreparedStatement statement = getSearchByNameStatement();
            statement.setString(1, "%"+keyword +"%");
            ResultSet rs = statement.executeQuery();
            List<Product> products = new LinkedList<Product>();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                products.add(new Product(id, name, price, description));
            }
            return products;
        }catch(Exception ex){
            Logger.getLogger(baby.shop.da.ProductManager.class.getName()).log(Level.SEVERE, null, ex);
            return new LinkedList<Product>();
        }
    }
    
    public Product getProductByID(int id){
        try{
            PreparedStatement statement = getSearchByIDStatement();
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String description = rs.getString("description");
                return new Product(id, name, price, description);
            }
        }catch(Exception ex){
            Logger.getLogger(baby.shop.da.ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Product(0, "", 0, "");
    }
}
