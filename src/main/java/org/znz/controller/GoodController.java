package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.znz.dto.common.View;
import org.znz.dto.good.GoodDetail;
import org.znz.dto.good.GoodList;
import org.znz.entity.Custom;
import org.znz.entity.Good;
import org.znz.service.CustomService;
import org.znz.service.GoodService;


@CrossOrigin
@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private CustomService customService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<GoodDetail> create(@ModelAttribute Good good){

        return  goodService.createGoodByParams(good);
    }

    @RequestMapping(value = "/goodList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<GoodList> index(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "6") Integer size,
                                @ModelAttribute Good good){
        return goodService.getGoodsByParams(good, page, size);
    }

    /**
     *
     * @param goodId
     * @return
     */
    @RequestMapping(value = "/{goodId}", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View<GoodDetail> show(@PathVariable("goodId")int goodId){
       return goodService.getGoodById(goodId);
    }

    /**
     *
     * 删除指定商品
     */
    @RequestMapping(value = "/{goodId}", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View destroy(@PathVariable("goodId")int goodId){
        return goodService.deleteGoodById(goodId);
    }

    /**
     *
     * 修改指定商品
     */
    @RequestMapping(value = "/{goodId}", method = RequestMethod.PUT, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View update(@PathVariable("goodId")int goodId,
                       @ModelAttribute Good good){
        return goodService.updateGoodByParams(goodId, good);
    }

    @RequestMapping(value = "/{goodId}/custom", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View createCustom(@PathVariable("goodId") Integer goodId,
                             @ModelAttribute Custom custom){
        return customService.createCustomByParams(goodId, custom);
    }

    @RequestMapping(value = "/{goodId}/custom/{customId}", method = RequestMethod.PUT, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View updateCustom(@PathVariable("customId") Integer customId,
                             @ModelAttribute Custom custom){
        return customService.updateCustomByParams(customId, custom);
    }

    @RequestMapping(value = "/{goodId}/custom/{customId}", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View deleteCustom(@PathVariable("customId") Integer customId){
        return customService.deleteCustomById(customId);
    }
}
