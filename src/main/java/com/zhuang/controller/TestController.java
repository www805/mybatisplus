package com.zhuang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhuang.domian.User;
import com.zhuang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("success")
    public String success(HttpServletRequest request){

        return "error";
    }


    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable("id") int id){
        userMapper.deleteById(id);
        return "redirect:/list";
    }

    @GetMapping(value = "/save")
    public String saveView() {
        return "save";
    }

    @PostMapping(value = "/save")
    public String save(HttpServletRequest request, User user) {

        if(!StringUtils.isEmpty(user.getName()) || !StringUtils.isEmpty(user.getAddress())){

            int result = userMapper.insert(user);
            request.setAttribute("result", request);
        }

        return "redirect:/list";
    }

    @RequestMapping(value = "/list")
    public ModelAndView testCon(){

        ModelAndView view = new ModelAndView();

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        List<User> users = userMapper.selectList(wrapper);

        view.addObject("users",users);

        view.setViewName("list");

        return view;
    }

}
