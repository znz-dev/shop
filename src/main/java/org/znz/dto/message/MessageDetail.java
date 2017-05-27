package org.znz.dto.message;

import org.znz.entity.Message;

/**
 * Created by zhangbin on 17-5-8.
 */
public class MessageDetail {

    private Message message;

    public MessageDetail(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
