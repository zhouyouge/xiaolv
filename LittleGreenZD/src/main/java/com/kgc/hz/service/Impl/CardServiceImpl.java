package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.CardDao;
import com.kgc.hz.entity.Card;
import com.kgc.hz.entity.CardPage;
import com.kgc.hz.entity.CardParameter;
import com.kgc.hz.entity.ResponseResult;
import com.kgc.hz.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("cardService")
public class CardServiceImpl implements CardService {
    @Autowired
    private CardDao cardDao;

    @Override
    public List<Card> getCardList() {
        return cardDao.getCardList();
    }

    /**
     * 添加IC卡信息
     * @param card
     * @return
     */
    @Override
    public ResponseResult addCards(Card card) {
        ResponseResult rs = new ResponseResult();
        if(StringUtils.isEmpty(card)){
            rs.setFlag(0);
            rs.setData("传参为空");
        }
        if(StringUtils.isEmpty(card.getId())){
            rs.setFlag(1);
            rs.setData("卡号为空");
        }
        if(StringUtils.isEmpty(card.getICUserName())){
            rs.setFlag(2);
            rs.setData("IC卡用户名为空");
        }
        if(StringUtils.isEmpty(card.getICIntegral())){
            rs.setFlag(3);
            rs.setData("积分余额为空");
        }
        if(StringUtils.isEmpty(card.getPhone())){
            rs.setFlag(4);
            rs.setData("IC卡用户电话为空");
        }
        if(StringUtils.isEmpty(card.getUserAddress())){
            rs.setFlag(5);
            rs.setData("IC卡用户住址为空");
        }
        if(StringUtils.isEmpty(card.getCreateTime())){
            rs.setFlag(6);
            rs.setData("IC卡办理时间为空");
        }
        if(cardDao.addCards(card)>0){
            rs.setFlag(7);
            rs.setData("添加IC卡信息成功");
            rs.setResult(true);
        }
        return rs;
    }

    @Override
    public CardPage getCard(CardParameter parameter) {
        if(StringUtils.isEmpty(parameter)){
            parameter=new CardParameter();
        }
        parameter.setPageIndex((parameter.getCurPage()-1)*parameter.getPageSize());
        int count = cardDao.getCardCount(parameter);
        List<Card> list = cardDao.getCardPage(parameter);
        CardPage page = new CardPage();
        page.setTotalCount(count);
        page.setCardLists(list);
        page.setCurPage(parameter.getCurPage());
        page.setPageSize(parameter.getPageSize());
        page.setTotalPageCount((count/page.getPageSize())+((count%page.getPageSize())==0?0:1));
        return page;
    }

    @Override
    public Card getCard(int id) {
        return cardDao.getCard(id);
    }

    @Override
    public ResponseResult updateCard(Card card) {
        int flag = cardDao.updateCard(card);
        ResponseResult rs = new ResponseResult();
        if(flag>0){
            rs.setResult(true);
            rs.setFlag(1);
        }else {
            rs.setFlag(2);
        }
        return rs;
    }

    @Override
    public ResponseResult delCard(int id) {
        int flag = cardDao.delCard(id);
        ResponseResult rs = new ResponseResult();
        if(flag>0){
            rs.setResult(true);
            rs.setFlag(1);
        }else {
            rs.setFlag(2);
        }
        return rs;
    }
}
