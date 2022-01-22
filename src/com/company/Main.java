package com.company;
import com.company.payment.*;
import com.company.buy.*;
import com.company.client.Client;
import com.company.payment.PayImpl;
import com.company.products.*;
import java.util.*;

// По итогам соблюдено:
// отсутствуют магические числа (Magics)
// отсутствует повторяющийся код (DRY)
// 1 принцип  SOLID - принцип единственной ответственности соблюден
// все классы выполняют только те функции, для которых они были созданы
// 2 принцип SOLID - принцип открытости/закрытости соблюден.
//
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client1 = new Client(450);
        Pay pay = new PayImpl();
        Buy buy = new BuyImpl();
        Map<Product, Integer> haveBought = new HashMap<>();
        List<Product> productList = new ArrayList(Arrays.asList(
                new Product("apple", 95, 53),
                new Product("milk", 70, 105),
                new Product("meat", 300, 10),
                new Product("eggs", 90, 56),
                new Product("cheese", 150, 1)));
        System.out.println("Список возможных товаров для покупки: ");

        // Принцип избегания магических чисел. В цикле указываем не число, а размерность листа
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(String.format("%-2s", i + 1) + " " + productList.get(i).toString());
        }
        buyingProcess(client1, buy, scanner, pay, productList, haveBought);
        output(client1, haveBought);
        System.out.println("Конец работы программы");
    }

    public static void buyingProcess(Client client, Buy buy, Scanner scanner,
                                     Pay pay, List<Product> list, Map<Product, Integer> haveBought)  {
        boolean nameMatch = false;
        while (true) {
            System.out.println("Введите желаемую покупку в формате 'тип продукта' 'количество'. Для расчета введите 'end'");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] strings = input.split(" ");
            if (strings.length != 2) {
                System.out.println("Ошибка ввода продукта.");
                continue;
            }
            String nameProduct = strings[0];
            int countProduct = Integer.parseInt(strings[1]);

            for (Product p: list) {
                if (p.getName().equals(nameProduct)) {
                    nameMatch = true;
                    int amount = p.getPrice() * countProduct;
                    if (!buy.buyingProduct(p, countProduct)) {
                        System.out.printf("Товара " + p.getName() + " нет в наличии");
                        continue;
                    }
                    if (!pay.clientPayment(client, amount)) {
                        System.out.println("На счете клиента не хватает " + (amount - client.getMoneyLeft()) + " рублей");
                        continue;
                    }
                    if (haveBought.containsKey(p)) {
                        int tempCount = haveBought.get(p);
                        haveBought.replace(p, tempCount, tempCount + countProduct);
                    } else {
                        haveBought.put(p, countProduct);
                    }
                }
            }

            if (!nameMatch) {
                System.out.println("Ошибка ввода продукта.");
            }
            nameMatch = false;
        }

    }

    public static void output(Client client, Map<Product, Integer> haveBought) {
        System.out.println("Ваша корзина:");
        int amount = 0;
        for (Map.Entry<Product, Integer> entry : haveBought.entrySet()) {
            String str = entry.getKey().getName() + " " + entry.getValue() + " шт.";
            System.out.println(str);
            amount += entry.getValue() * entry.getKey().getPrice();
        }
        System.out.println("Сумма покупки = " + amount);
        System.out.println("Остаток средств на счету клиента: " + client.getMoneyLeft());
    }

}
