package org.znz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.znz.dto.common.View;
import org.znz.dto.message.MessageDetail;
import org.znz.entity.Message;
import org.znz.service.MessageService;

/**
 * Created by zhangbin on 17-5-8.
 */
@CrossOrigin
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"} )
    @ResponseBody
    public View create(@ModelAttribute Message message) {
        return messageService.createMessageByParams(message);
    }

    @RequestMapping(value = "/{messageId}", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"} )
    @ResponseBody
    public View<MessageDetail> show(@PathVariable("messageId") int messageId,
                                    @RequestParam("userId") Integer userId) {
        return messageService.getMessageById(messageId, userId);
    }

}
