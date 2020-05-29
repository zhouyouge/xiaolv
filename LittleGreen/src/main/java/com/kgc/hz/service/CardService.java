package com.kgc.hz.service;

import com.kgc.hz.entity.Card;
import com.kgc.hz.entity.CardPage;
import com.kgc.hz.entity.CardParameter;
import com.kgc.hz.entity.ResponseResult;

import java.util.List;

public interface CardService {
    List<Card> getCardList();

    ResponseResult addCards(Card card);

    CardPage getCard(CardParameter parameter);

    Card getCard(int id);

    ResponseResult updateCard(Card card);

    ResponseResult delCard(int id);
}
