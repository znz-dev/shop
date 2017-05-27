package org.znz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.znz.dao.MessageDao;
import org.znz.dto.common.View;
import org.znz.dto.message.MessageDetail;
import org.znz.dto.message.MessageList;
import org.znz.entity.Message;
import org.znz.service.MessageService;

import java.util.List;

/**
 * Created by zhangbin on 17-5-8.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public View createMessageByParams(Message message) {
        int count = messageDao.createMessageByParams(message);
        if (count <= 0) {
            return new View(false, "信息发送失败");
        }
        return new View(true, "");
    }

    public View<MessageDetail> getMessageById(int messageId, int userId) {
        try {
            Message message = messageDao.queryMessageById(messageId);
            if (message == null) {
                return new View<MessageDetail>(false, "该信息不存在");
            }
            if (message.getTo().getUserId() == userId) {
                messageDao.updateMessageStatus(messageId, 2);
            }
            return new View<MessageDetail>(new MessageDetail(message));
        } catch (Exception e){
            return new View<MessageDetail>(false, e.getMessage());
        }


    }

    public View destroyMessageById(int messageId) {
        return null;
    }

    public View<MessageList> getMessagesByParams(Message message, int userId, int page, int size) {
        if (page <= 0) {
            page = 1;
        }
        if (size<= 0) {
            size = 6;
        }
        int offset = (page -1)*size;
        try {
            List<Message> messageList = messageDao.queryMessagesByParams(message, userId, offset, size);
            int count = messageDao.queryMessagesCountByParams(message, userId);
            int pages = (count + size - 1) / size;
            return new View<MessageList>(new MessageList(pages, messageList));
        } catch (Exception e) {
            return new View<MessageList>(false, e.getMessage());
        }
    }
}
