package br.com.chainpass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MailController {

    @Autowired

    @PostMapping("/teste")
    public void testaEmail(){

    }
}
