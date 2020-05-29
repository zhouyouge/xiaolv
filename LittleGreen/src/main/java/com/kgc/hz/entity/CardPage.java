package com.kgc.hz.entity;

import java.util.List;

public class CardPage extends Page {
    private List<Card> cardLists;

    public List<Card> getCardLists() {
        return cardLists;
    }

    public void setCardLists(List<Card> cardLists) {
        this.cardLists = cardLists;
    }
}
