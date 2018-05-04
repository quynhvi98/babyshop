/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;

import baby.shop.biz.Cart;
import baby.shop.da.ProductManager;
import baby.shop.entity.Product;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author viquy
 */
public class removeProductCart extends ActionSupport {
    
    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public removeProductCart() {
    }

    public String execute() throws Exception {
        Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
        Product p = new ProductManager().getProductById(productId);
        if (cart != null) {
            cart.removeProduct(p);
            return SUCCESS;
        }else{
            return ERROR;
        }
    }
    
}
