package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.List;

public class ResponseResult implements Serializable {
    private boolean result;
    private Object data;
    private Integer flag;
    private List<Card> CardList;

    public List<Card> getCardList() {
        return CardList;
    }

    public void setCardList(List<Card> cardList) {
        CardList = cardList;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
