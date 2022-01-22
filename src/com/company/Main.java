package com.company;
import com.company.buy.*;
import com.company.client.Client;
import com.company.products.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client1 = new Client(450);
        Buy buy = new BuyImpl();
        List<Product> productList = new ArrayList(Arrays.asList(
                new Product ("apple", 95, 53),
                new Product("milk", 70, 105),
                new Product("meat", 300, 10),
                new Product("eggs", 90, 56),
                new Product("cheese", 150, 1)));
        System.out.println("Список возможных товаров для покупки: ");

        for (int i = 0; i < productList.size(); i++) {
            System.out.println(String.format("%-2s", i + 1) + " " + productList.get(i).toString());
        }


        buyingProcess(client1, buy, scanner, productList);
    }

    public static void buyingProcess(Client client, Buy buy, Scanner scanner, List<Product> list)  {
        System.out.println("Введите желаемую покупку в формате 'тип продукта' 'количество'");

    }

}
