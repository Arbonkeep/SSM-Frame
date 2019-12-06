package com.arbonkeep.controller;

import com.arbonkeep.domain.Account;
import com.arbonkeep.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2019/12/6 - 10:39
 * 账户的web层
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("findAll方法执行了。。。");
        //调用方法
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts",accounts);//将对象存入model
        return "list";
    }

    /**
     * 保存
     * @param account
     * @return
     */
    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("saveAccount方法执行了");
        //调用保存方法
        accountService.saveAccount(account);
        //重定向跳转页面(相当于保存了数据后直接去查询)
        response.sendRedirect(request.getContextPath() + "/account/findAll");
        return ;
    }
}
