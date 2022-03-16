package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.GoodsVo;
import com.example.seckill.vo.OrderDetailVo;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author yipeng
 * 广告
 */
public interface IOrderService extends IService<Order> {
    /**
     * 秒杀
     * @param user
     * @param goods
     * @return
     */
    Order seckill(User user, GoodsVo goods);
    /**
     * 订单详情
     *
     * @param orderId
     * @return
     */
    OrderDetailVo detail(Long orderId);
    /**
     * 获取秒杀地址
     *
     * @param user
     * @param goodsId
     * @return
     */
    String createPath(User user, Long goodsId);
    /**
     * 校验秒杀地址
     *  @param user
     * @param goodsId
     * @param path
     */
    boolean checkPath(User user, long goodsId, String path);
    /**
     * 校验验证码
     *
     * @param user
     * @param goodsId
     * @param captcha
     * @return
     */
    boolean checkCaptcha(User user, Long goodsId, String captcha);
}
