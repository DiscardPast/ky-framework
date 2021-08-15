package com.kunyuesoft.model.domain;


import lombok.Data;
import com.kunyuesoft.model.dtos.admin.base.BaseEntity;

/**
 * 菜单信息对象 sys_menu
 * 
 * @author kunyuesoft
 * @date Fri Aug 13 15:27:32 CST 2021
 */
@Data
public class SysMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 菜单Id */
    private Integer menuId;

    /** 菜单名称 */
    private String menuName;

    /** 父级菜单名称 */
    private int parentId;

    /** 排序顺序 */
    private String orderNum;

    /** 路径 */
    private String path;

    /** 内容 */
    private String component;

    /** 是否是框架 */
    private String isFrame;

    /** 菜单类型 */
    private String menuType;

    /** 是否可见 */
    private String visible;

    /** 状态 */
    private String status;

    /** 所属权限 */
    private String perms;

    /** 图标 */
    private String icon;

}
