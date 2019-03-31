package com.zhuang;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xerces.internal.util.EntityResolverWrapper;
import com.zhuang.domian.User;
import com.zhuang.mapper.UserMapper;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByAll(){


        IPage<User> page = userMapper.selectPage(new Page<>(1, 2), null);

        List<User> list = page.getRecords();

        System.out.println(list);
//        for (User user : list) {
//            System.out.println(user);
//        }

    }

    @Test
    public void selectOneTest(){

        User user = new User();

        user.setId(2L);
        user.setName("aaa");

        QueryWrapper<User> wrapper = new QueryWrapper<User>(user);


        QueryWrapper<User> id = new QueryWrapper<User>().eq("id", "1");

        User result = userMapper.selectOne(id);

        System.out.println(result);

    }

    @Test
    public void contextLoads() {

        User user = new User();

        user.setName("林海峰");
        user.setAddress("今天我，明天我");
//        User user = userMapper.selectById(1);
//        System.out.println(user);

        int insert = userMapper.insert(user);
        System.out.println(insert);

        System.out.println(user);

//        userMapper.selectList()

        log.info("完成添加");

    }

}
