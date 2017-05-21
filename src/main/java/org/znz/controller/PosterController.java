package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.znz.dto.common.View;
import org.znz.entity.Poster;
import org.znz.service.PosterService;

import java.io.File;
import java.io.IOException;

@CrossOrigin
@Controller
@RequestMapping("/poster")
public class PosterController {

    @Autowired
    private PosterService posterService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public View create(@ModelAttribute Poster poster,
                       @RequestParam("file") CommonsMultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            String rootPath = System.getProperty("shop.webRootPath");
            String filePath = "/upload/" + file.getOriginalFilename();
            String path = rootPath + filePath;
            file.transferTo(new File(path));
            poster.setPicture(filePath);
        }
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
