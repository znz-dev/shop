package org.znz.service;

import org.znz.dto.common.View;
import org.znz.dto.message.MessageDetail;
import org.znz.dto.message.MessageList;
import org.znz.entity.Message;


/**
 * Created by zhouxin on 17-5-8.
 */
public interface MessageService {

    View createMessageByParams(Message message);

    View<MessageDetail> getMessageById(int messageId, int userId);

    View destroyMessageById(int messageId);

    View<MessageList> getMessagesByParams(Message message, int userId, int page, int size);
}
