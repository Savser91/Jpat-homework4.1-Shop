package com.company.payment;

import com.company.client.Client;

public interface Pay {
    public boolean clientPayment(Client client, int amount);
}
