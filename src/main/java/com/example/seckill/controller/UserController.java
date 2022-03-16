package com.example.seckill.controller;


import com.example.seckill.pojo.User;
import com.example.seckill.rabbitmq.MQSender;
import com.example.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 * 广告
 *
 * @author yipeng
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MQSender mqSender;

    /***
     * 用户信息(测试)
     * @return
     */
    @RequestMapping("/info")
    public RespBean info(User user) {
        return RespBean.success(user);
    }

    ///**
    // * 测试发送RabbitMQ消息
    // */
    //@RequestMapping("/mq")
    //public void mq01() {
    //    mqSender.send("Hello");
    //}
    //
    ///**
    // * fanount模式
    // */
    //@RequestMapping("/mq/fanout")
    //public void fanount() {
    //    mqSender.send("Hello,Faount");
    //}
    //
    ///**
    // * Direct模式
    // */
    //@RequestMapping("/mq/direct01")
    //public void mq02() {
    //    mqSender.send01("Hello,Red");
    //}
    //
    ///**
    // * Direct模式
    // */
    //@RequestMapping("/mq/direct02")
    //public void mq03() {
    //    mqSender.send02("Hello,Green");
    //}
    //
    ///**
    // * Topic模式
    // */
    //@RequestMapping("/mq/topic01")
    //public void mq04() {
    //    mqSender.send03("Hello,Green");
    //}
    //
    ///**
    // * Topic模式
    // */
    //@RequestMapping("/mq/topic02")
    //public void mq05() {
    //    mqSender.send04("Hello,Green");
    //}
    ///**
    // * Header模式
    // */
    //@RequestMapping("/mq/header01")
    //public void mq06() {
    //    mqSender.send05("Hello,Header01");
    //}
    ///**
    // * Header模式
    // */
    //@RequestMapping("/mq/header02")
    //public void mq07() {
    //    mqSender.send06("Hello,Header02");
    //}
}


