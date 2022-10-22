package com.example.ssmp_lib.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.ssmp_lib.POJO.Book;
import com.example.ssmp_lib.service.IBookService;
import com.example.ssmp_lib.controller.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

    @PostMapping
    public R save(@RequestBody Book book){
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功^_^":"添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R deleteById(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    @GetMapping("{currentPage}/{PageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int PageSize,Book book){

        IPage<Book> page = bookService.getPage(currentPage, PageSize,book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), PageSize,book);
        }
        return new R(true,page);
    }

}
