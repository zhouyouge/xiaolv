package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.AreaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class AreaController {

    @Resource(name = "areaService")
    private AreaService areaService;

    /**
     * 区域信息分页
     * @param parameter
     * @param model
     * @return
     */
    @RequestMapping(value = "areaList",method = RequestMethod.GET)
    public String getAreaList(AreaParameter parameter, Model model){
        AreaPage page = areaService.getAreaPage(parameter);
        model.addAttribute("area",page);
        return "areaPage";
    }

    /**
     * 添加区域信息
     * @param model
     * @return
     */
    @RequestMapping(value = "addArea",method = RequestMethod.GET)
    public String addArea(Model model){
        return "addArea";
    }
    @ResponseBody
    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    public Object addAreas(Area area){
        ResponseResult rs = areaService.addArea(area);
        return JSON.toJSONString(rs);
    }

    /**
     * 修改区域信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "updateArea/{id}",method = RequestMethod.GET)
    public String getUpdateArea(@PathVariable("id")int id, Model model){
        Area area = areaService.getArea(id);
        model.addAttribute("area",area);
        return "updateArea";
    }
    @ResponseBody
    @RequestMapping(value = "/updateArea",method = RequestMethod.POST)
    public Object updateArea(Area area){
        ResponseResult rs = areaService.updateArea(area);
        return JSON.toJSONString(rs);
    }
    /**
     * 删除区域信息
     * @param area
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteArea",method = RequestMethod.GET)
    public Object deleteArea(Area area){
        ResponseResult rs = areaService.deleteArea(area);
        return JSON.toJSONString(rs);
    }

    /**
     * 跳转
     * @return
     */
    @RequestMapping(value = "AC",method = RequestMethod.GET)
    public String AC(){
        return "Tucabinet";
    }
    @ResponseBody
    @RequestMapping(value = "AreaCab",method = RequestMethod.POST)
    public Object AreaCab(){
        return areaService.getACList();
    }

    @ResponseBody
    @RequestMapping(value = "AreaL",method = RequestMethod.GET)
    public Object AB(){
        return areaService.Arealist();
    }
}
