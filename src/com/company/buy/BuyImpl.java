package com.company.buy;
import com.company.client.Client;
import com.company.products.Product;

public class BuyImpl implements Buy {
    @Override
    public boolean clientPayment(Client client, int amount) {
        if (client.getMoneyLeft() >= amount) {
            client.setMoneyLeft(client.getMoneyLeft() - amount);
            return true;
        } else
            return false;
    }

    @Override
    public boolean buyingProduct(Product product, int count) {
        if (product.getRemain() >= count) {
            product.setRemain(product.getRemain() - count);
            return true;
        } else
        return false;
    }
}
