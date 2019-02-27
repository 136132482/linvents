package com.example.netty.websocket.controller;

import com.example.netty.websocket.util.ApiReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

    @Controller
    @RequestMapping("/ ")
    public class CheckCenterController {

        //页面请求
        @GetMapping("/socket/{cid}")
        public ModelAndView socket(@PathVariable String cid) {
            ModelAndView mav=new ModelAndView("/socket");
            mav.addObject("cid", cid);
            return mav;
        }

        @RequestMapping("/socket")
        public String Index() {
            return "forward:/index.html";
        }

        //推送数据接口
        @ResponseBody
        @RequestMapping("/socket/push/{cid}")
        public Object pushToWeb(@PathVariable String cid,String message) {
            try {
                WebSocketServer.sendInfo(message,cid);
            } catch (IOException e) {
                e.printStackTrace();
                return ApiReturnUtil.error(cid+"#"+e.getMessage());
            }
            return ApiReturnUtil.success(cid);
        }
    }
