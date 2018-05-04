/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;

import com.opensymphony.xwork2.ActionSupport;
import baby.shop.da.CustomerDA;
import baby.shop.entity.Customer;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
/**
 *
 * @author viquy
 */
public class HistoryTransaction extends ActionSupport {
    
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public HistoryTransaction() {
    }

    public String execute() throws Exception {
        customers = new CustomerDA().ListCustomer();
        if (customers == null) {
            return ERROR;
        }
        return SUCCESS;
    }
    
}
