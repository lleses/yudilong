package com.dl.modules.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户
 */
@Data
//@TableName("eds2_tv_user")
public class Eds2TvUser {

//    private static final long serialVersionUID = 1L;

    /** 用户ID */
//    @TableId(value = "user_id", type = IdType.ID_WORKER)
    @TableId(type = IdType.ID_WORKER)
    private Long userId;
    /** 手机号 */
    private String mobile;
    /** 店铺id */
    private String storeId;
    /** 激活时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    /** user_id  jwt转码  token */
    private String accessToken;
    /** 机器码 */
    @TableField("machineCode")
    private String machineCode;

}
