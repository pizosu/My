package com.example.ssmp_lib.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ssmp_lib.POJO.Book;

public interface IBookService extends IService<Book> {

    Boolean delete(Integer id);

    IPage<Book> getPage(int currentPage,int pageSize);

    IPage<Book> getPage(int currentPage,int pageSize,Book book);
}
