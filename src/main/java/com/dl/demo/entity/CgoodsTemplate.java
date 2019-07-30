package com.dl.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CgoodsTemplate {

    /** NULL */
    private Long id;
    /** '模板编号' */
    private String code;
    /** '上级Id' */
    private Long pid;
    /** '名称' */
    private String name;
    /** '排序 升序' */
    private Integer sort;
    /** '是否可以从本模板新建商品' */
    @TableField("canCreate")
    private Integer canCreate;
    /** '添加时间' */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("addDate")
    private LocalDateTime addDate;
    /** '备注' */
    private String remark;
    /** '分类级层' */
    private Integer level;

}
