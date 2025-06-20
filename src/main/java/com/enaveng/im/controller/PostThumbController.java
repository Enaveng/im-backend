package com.enaveng.im.controller;

import com.enaveng.im.common.BaseResponse;
import com.enaveng.im.common.ErrorCode;
import com.enaveng.im.common.ResultUtils;
import com.enaveng.im.exception.BusinessException;
import com.enaveng.im.model.dto.postthumb.PostThumbAddRequest;
import com.enaveng.im.model.entity.User;
import com.enaveng.im.service.PostThumbService;
import com.enaveng.im.service.UserService;

import javax.annotation.Resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 帖子点赞接口
 *  
 */
@RestController
@RequestMapping("/post_thumb")
@Slf4j
@Api(tags = "帖子点赞")
public class PostThumbController {

    @Resource
    private PostThumbService postThumbService;

    @Resource
    private UserService userService;

    /**
     * 点赞 / 取消点赞
     *
     * @param postThumbAddRequest 发布拇指添加请求
     * @return resultNum 本次点赞变化数
     */
    @PostMapping("/")
    @ApiOperation(value = "点赞 / 取消点赞")
    public BaseResponse<Integer> doThumb(@RequestBody PostThumbAddRequest postThumbAddRequest) {
        if (postThumbAddRequest == null || postThumbAddRequest.getPostId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 登录才能点赞
        final User loginUser = userService.getLoginUser();
        long postId = postThumbAddRequest.getPostId();
        int result = postThumbService.doPostThumb(postId, loginUser);
        return ResultUtils.success(result);
    }

}
