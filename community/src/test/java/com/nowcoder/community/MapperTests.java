package com.nowcoder.community;


import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MapperTests {


    @Autowired
    UserMapper userMapper;
    @Autowired
    DiscussPostMapper discussPostMapper;
    @Autowired
    LoginTicketMapper loginTicketMapper;
    @Test
    public void testselectMapper(){
       User user = userMapper.selectById(101);
       System.out.println(user);

       user = userMapper.selectByEmail("nowcoder101@sina.com");
       System.out.println(user);

       user = userMapper.selectByName("liubei");
       System.out.println(user);

    }

    @Test
    public void testinsertMapper(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("nowcoder101@sina.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/100t.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(user.getId());
        System.out.println(row);


    }

    @Test
    public void testupdateMapper(){
        int row = userMapper.updateStatus(150,1);
        System.out.println(row);

        row = userMapper.updateHeader(150,"http://images.nowcoder.com/head/102.png");
        System.out.println(row);

        row = userMapper.updatePassword(150,"333666");
        System.out.println(row);



    }
    @Test
    public void testselectPosts(){
        List<DiscussPost> discussPostList = discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost disc: discussPostList){
            System.out.println(disc);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }
    @Test
    public void  testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis()+ 1000 * 60 * 10 ));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc",1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

}
