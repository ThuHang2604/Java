/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hang.registration;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class CartObj implements Serializable {
    private String customerId;
    private Map<String, Integer> items;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
    
    public void addItemToCart(String title) {
        if(this.items == null) {
            this.items = new HashMap<String, Integer>();
        }
        int quantity = 1;
        if(this.items.containsKey(title)) {
            quantity = this.items.get(title) + 1;
        }
        this.items.put(title, quantity);
    }
    
    public void removeItemFromCart(String title) {
        if(this.items == null) {
            return;
        }
        if(this.items.containsKey(title)) {
            this.items.remove(title);
            if(this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
