/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;

import baby.shop.biz.Cart;
import baby.shop.da.CustomerDA;
import baby.shop.entity.Customer;
import baby.shop.entity.Product;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author viquy
 */
public class CheckOut extends ActionSupport {
    
    private String name;
    private String phone;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
    private Map<Product, Integer> products;
    private float total;

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public CheckOut() {
    }

    public String execute() throws Exception {
        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        if (cart == null) {
            return ERROR;
        }
        products = cart.getProducts();
        total = cart.getTotalPrice();
        if (new CustomerDA().checkOut(name, phone, address, total)) {
            ActionContext.getContext().getSession().remove("cart");
            return SUCCESS;
        }
        return ERROR;
    }
}
