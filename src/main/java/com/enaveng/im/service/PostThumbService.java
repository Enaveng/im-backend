package com.enaveng.im.service;

import com.enaveng.im.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.enaveng.im.model.entity.User;

/**
 * 帖子点赞服务
 *
 *  
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 点赞
     *
     * @param postId    帖子 ID
     * @param loginUser 登录用户
     * @return int
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 帖子点赞（内部服务）
     *
     * @param userId 用户 ID
     * @param postId 帖子 ID
     * @return int
     */
    int doPostThumbInner(long userId, long postId);
}
