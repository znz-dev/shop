package org.znz.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.znz.dto.common.View;
import org.znz.entity.User;

import java.io.File;
import java.io.IOException;


/**
 * Created by zhangbin on 17-5-5.
 */
public class JsonTest {
    @Test
    public void testJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();


        User user = new User();
        user.setUsername("lls");
        View<User> userView = new View<User>(user);

        mapper.writeValue(new File("result.json"), userView);
//// or:
//        value = mapper.readValue(new URL("http://some.com/api/entry.json"), MyValue.class);
//// or:
//        value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);
    }
}
