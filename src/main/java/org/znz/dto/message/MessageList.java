package org.znz.dto.message;

import org.znz.entity.Message;

import java.util.List;

/**
 * Created by zhouxin on 17-5-8.
 */
public class MessageList {

    private int pages;

    private List<Message> messageList;

    public MessageList(int pages, List<Message> messageList) {
        this.pages = pages;
        this.messageList = messageList;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
