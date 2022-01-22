package com.company.buy;
import com.company.client.Client;
import com.company.products.Product;

public interface Buy {
    public boolean clientPayment(Client client, int amount);
    public boolean buyingProduct(Product product, int count);
}
