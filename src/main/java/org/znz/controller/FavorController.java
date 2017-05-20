package org.znz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.znz.dto.common.View;
import org.znz.entity.Favor;
import org.znz.service.FavorService;

@CrossOrigin
@Controller
@RequestMapping("/favor")
public class FavorController {
    @Autowired
    private FavorService favorService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View create(@ModelAttribute Favor favor) {
        return favorService.createFavorByParams(favor);
    }

    @RequestMapping(value = "/{favorId}", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View destroy(@PathVariable("favorId") Integer favorId) {
        return null;
    }
}
