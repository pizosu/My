package com.example.ssmp_lib;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ssmp_lib.Mapper.BookMapper;
import com.example.ssmp_lib.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SSMPLibApplicationTests {

    @Autowired
    BookMapper bookMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAll(){
        System.out.println(bookMapper.selectList(null));
    }

    //分页操作 必须使用拦截器
    @Test
    void testPage(){
        IPage page = new Page(1,5);
        bookMapper.selectPage(page,null);
    }

    @Autowired
    IBookService bookService;

    @Test
    void testGet(){
        System.out.println(bookService.getById(1));
    }

}
