package com.kgc.hz.dao;

import com.kgc.hz.entity.Card;
import com.kgc.hz.entity.CardParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CardDao")
public interface CardDao {
    List<Card> getCardList();
    /**
     * 添加IC卡信息
     */
    int addCards(Card card);

    /**
     * 分页查询
     */
    List<Card> getCardPage(CardParameter parameter);

    int getCardCount(CardParameter parameter);


    Card getCard(@Param("id") int id);

    /**
     * 修改IC卡信息
     */

    int updateCard(Card card);

    /**
     * 删除IC卡信息
     */

    int delCard(@Param("id") int id);
}
