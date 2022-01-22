package com.company.payment;
import com.company.client.Client;

public class PayImpl implements Pay{
    @Override
    public boolean clientPayment(Client client, int amount) {
        if (client.getMoneyLeft() >= amount) {
            client.setMoneyLeft(client.getMoneyLeft() - amount);
            return true;
        } else
            return false;
    }
}
