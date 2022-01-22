package com.company.products;

public class Product {
    private String name;
    private int price;
    private int remain;

    public Product(String name, int price, int remain) {
        this.name = name;
        this.price = price;
        this.remain = remain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Override
    public String toString() {
        String output = "Название - " + String.format("%-9s", this.name) + " Цена - " + String.format("%-4s", this.price) + " Остаток -" +
                String.format("%-4s", this.remain);
        return output;
    }
}
