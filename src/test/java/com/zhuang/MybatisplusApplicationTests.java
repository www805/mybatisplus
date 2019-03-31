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

    /***
     * @TableName() 表名
     *   value  指定名称
     * @TableId() 主键
     *   type   枚举 IdType.AUTO
     *   value  指定名称
     * @TableField() 成员字段
     *   exist  是否存在
     *   value  指定名称
     *
     *
     *
     * 以上都可以在全局配置xml中配置
     *
     *
     * curd
     * 插入数据库
     * insert() 方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到sql语句中
     * insertAllColumn() 方法在插入时，不管属性是否为空，属性所对应的字段搜会出现到sql语句中
     *
     * updateById() 更新的时候会做非空判断
     * updateAllColumnById() 更新的时候不做非空判断，会把全部字段修改
     *
     * selectById()  根据id查询数据
     * selectOne()   根据条件构造器查询数据
     * selectBatchIds()  根据集合批量查询
     * selectByMap()  根据字段名，值去查询（key要写成数据库的字段）
     * selectPath()   分页 new Path()
     *
     *
     */

}
