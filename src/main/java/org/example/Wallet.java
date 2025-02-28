package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private String owner;
    private final List<String> cards;
    private List<Integer> banknotes;
    private List<Integer> coins;
    public Wallet() {
        this.owner = null;
        this.cards = new ArrayList<>();
        this.banknotes = new ArrayList<>();
        this.coins = new ArrayList<>();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void addCard(String card) {
        this.cards.add(card);
    }

    public List<String> getCards() {
        return cards;
    }
    public boolean takeCard(String card) {
        return cards.remove(card);
    }

    public void addMoney(int amount) {
        if (amount >= 1000) {
            banknotes.add(amount);
        } else {
            coins.add(amount);
        }
    }

    public boolean withdrawMoney(int amount) {
        if (getTotalMoney() < amount) {
            return false;
        }

        int remaining = amount;
        while (remaining >= 1000 && !banknotes.isEmpty()) {
            remaining -= banknotes.remove(0);
        }
        while (remaining > 0 && !coins.isEmpty()) {
            remaining -= coins.remove(0);
        }

        return true;
    }

    public int getTotalMoney() {
        int total = 0;
        for (int money : banknotes) {
            total += money;
        }
        for (int money : coins) {
            total += money;
        }
        return total;
    }

}
