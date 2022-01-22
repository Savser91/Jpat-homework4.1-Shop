package com.company.buy;
import com.company.products.Product;

public class BuyImpl implements Buy {

    @Override
    public boolean buyingProduct(Product product, int count) {
        if (product.getRemain() >= count) {
            product.setRemain(product.getRemain() - count);
            return true;
        } else
        return false;
    }
}
