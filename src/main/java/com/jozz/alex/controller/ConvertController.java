package com.jozz.alex.controller;

import com.jozz.alex.service.ConvertService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @RequestMapping("/convert")
    public String converFromSrcUrl(String srcUrl){
        if (StringUtils.isEmpty(srcUrl)) {
            return srcUrl;
        }
        String newUrl = convertService.converFromSrcUrl(srcUrl);
        return newUrl;
    }

    @RequestMapping("/{surfix}")
    public void converToSrcUrl(@PathVariable String surfix, HttpServletResponse response){
        if (StringUtils.isEmpty(surfix)) {
            return;
        }
        //TODO surfix进行正则校验
        String srcUrl = convertService.converToSrcUrl(surfix);
        try {
            response.sendRedirect(srcUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
