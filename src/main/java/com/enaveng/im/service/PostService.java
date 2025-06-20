package com.enaveng.im.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.enaveng.im.model.dto.post.PostQueryRequest;
import com.enaveng.im.model.entity.Post;
import com.enaveng.im.model.vo.PostVO;

/**
 * 帖子服务
 *
 *  
 */
public interface PostService extends IService<Post> {

    /**
     * 校验
     *
     * @param post 发布
     * @param add  加
     */
    void validPost(Post post, boolean add);

    /**
     * 获取查询条件
     *
     * @param postQueryRequest 发布查询请求
     * @return {@link QueryWrapper}<{@link Post}>
     */
    QueryWrapper<Post> getQueryWrapper(PostQueryRequest postQueryRequest);

    /**
     * 从 ES 查询
     *
     * @param postQueryRequest 发布查询请求
     * @return {@link Page}<{@link Post}>
     */
    Page<Post> searchFromEs(PostQueryRequest postQueryRequest);

    /**
     * 获取帖子封装
     *
     * @param post    发布
     * @return {@link PostVO}
     */
    PostVO getPostVO(Post post);

    /**
     * 分页获取帖子封装
     *
     * @param postPage 帖子页面
     * @return {@link Page}<{@link PostVO}>
     */
    Page<PostVO> getPostVOPage(Page<Post> postPage);
}
