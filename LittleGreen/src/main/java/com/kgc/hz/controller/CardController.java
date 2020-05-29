package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CardController {

    @Autowired
    private CardService cardService;

    @RequestMapping(value = "addCard",method = RequestMethod.GET)
    public String getAddCard(Model model){
        List<Card> list = cardService.getCardList();
        model.addAttribute("cardList",list);
        return "addCard";
    }
    /**
     * 添加IC卡信息
     */
    @ResponseBody
    @RequestMapping(value = "/card",method = RequestMethod.POST)
    public Object addCard(Card card, HttpSession session){
        ResponseResult rs = new ResponseResult();
        rs = cardService.addCards(card);
        return JSON.toJSONString(rs);
    }

    /**
     * 分页查询
     */
    @RequestMapping(value = "cardlist",method = RequestMethod.GET)
    public String getCard(CardParameter parameter,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)) {
            parameter.setICUserName(user.getUserName());
            CardPage page = cardService.getCard(parameter);
            rs.setResult(true);
            rs.setFlag(1);
            rs.setData(page);
            rs.setCardList(page.getCardLists());
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        model.addAttribute("cardList", rs);
        return "cardlist";
    }
    /**
     * 修改IC卡信息
     */
    @RequestMapping(value = "/updateCard",method = RequestMethod.GET)
    public String  updateCard(@RequestParam("id") Integer id,Model model){
        ResponseResult rs = new ResponseResult();
        Card card = cardService.getCard(id);
        List<Card> cardList = cardService.getCardList();
        model.addAttribute("card",card);
        model.addAttribute("cardLists",cardList);
        return "updateCard";

    }

    @ResponseBody
    @RequestMapping(value = "/updateCards",method = RequestMethod.POST)
    public Object updateCards(Card card, HttpSession session){
        ResponseResult rs =  cardService.updateCard(card);
        return JSON.toJSONString(rs);
    }
/**
 * 删除IC卡信息
 */
    @ResponseBody
    @RequestMapping(value = "/delCard",method = RequestMethod.GET)
    public Object delCard(@RequestParam("id") Integer id,HttpSession session){
        ResponseResult rs = new ResponseResult();
        rs = cardService.delCard(id);
        return JSON.toJSONString(rs);
    }
}
