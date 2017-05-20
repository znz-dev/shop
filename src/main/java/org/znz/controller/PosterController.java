package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.znz.dto.common.View;
import org.znz.entity.Poster;
import org.znz.service.PosterService;

@CrossOrigin
@Controller
@RequestMapping("/poster")
public class PosterController {

    @Autowired
    private PosterService posterService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View create(@ModelAttribute Poster poster) {
        return posterService.createPosterByParams(poster);
    }

    @RequestMapping(value = "/{posterId}", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View destroy(@PathVariable("posterId") Integer posterId) {
        return posterService.deletePosterByParams(posterId);
    }

    @RequestMapping(value = "/posterList", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View index(@ModelAttribute Poster poster) {
        return posterService.getPostersByParams();
    }

}
