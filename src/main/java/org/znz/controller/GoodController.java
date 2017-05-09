package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.znz.dto.common.View;
import org.znz.dto.good.GoodDetail;
import org.znz.dto.good.GoodList;
import org.znz.entity.Good;
import org.znz.service.GoodService;

/**
 * Created by zhouxin on 17-5-7.
 */
@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

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
}
