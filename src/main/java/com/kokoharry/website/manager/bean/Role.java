package com.kokoharry.website.manager.bean;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 */
public class Role extends BaseDomain implements Serializable{


    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建方式 0 默认 数据库
     */
    private int createType;

    /**
     * 更新方式 默认0 数据库
     */
    private int updateType;


    private Menu menu;

    /**
     * 角色编码 取值方法get
     * @return roleCode
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 角色编码 賦值方法set
     * @param roleCode
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 角色名称 取值方法get
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名称 賦值方法set
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 创建方式 0 默认 数据库 取值方法get
     * @return createType
     */
    public int getCreateType() {
        return createType;
    }

    /**
     * 创建方式 0 默认 数据库 賦值方法set
     * @param createType
     */
    public void setCreateType(int createType) {
        this.createType = createType;
    }

    /**
     * 更新方式 默认0 数据库 取值方法get
     * @return updateType
     */
    public int getUpdateType() {
        return updateType;
    }

    /**
     * 更新方式 默认0 数据库 賦值方法set
     * @param updateType
     */
    public void setUpdateType(int updateType) {
        this.updateType = updateType;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}