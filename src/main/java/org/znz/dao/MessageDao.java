package org.znz.dao;

import org.apache.ibatis.annotations.Param;
import org.znz.entity.Message;

import java.util.List;

/**
 * Created by zhouxin on 17-5-8.
 */
public interface MessageDao {

    int createMessageByParams(Message message);

    Message queryMessageById(int messageId);

    int updateMessageStatus(@Param("messageId") int messageId, @Param("status") int status);
//
    List<Message> queryMessagesByParams(@Param("message") Message message, @Param("userId") int userId,
                                        @Param("offset") int offset, @Param("limit") int limit );
    int queryMessagesCountByParams(@Param("message") Message message, @Param("userId") int userId);
}
