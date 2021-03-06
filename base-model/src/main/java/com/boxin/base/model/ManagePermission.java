package com.boxin.base.model;

import java.util.ArrayList;

public class ManagePermission {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bx_manage_permission.id
     *
     * @mbggenerated
     */
    private Long id;

    private Long parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bx_manage_permission.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bx_manage_permission.name
     *
     * @mbggenerated
     */
    private String name;

    private Long sort ;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bx_manage_permission.type
     *
     * @mbggenerated
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bx_manage_permission.status
     *
     * @mbggenerated
     */
    private Integer status;

    private ArrayList<ManagePermission> children;

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public ArrayList<ManagePermission> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ManagePermission> children) {
        this.children = children;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bx_manage_permission.id
     *
     * @return the value of bx_manage_permission.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bx_manage_permission.id
     *
     * @param id the value for bx_manage_permission.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bx_manage_permission.code
     *
     * @return the value of bx_manage_permission.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bx_manage_permission.code
     *
     * @param code the value for bx_manage_permission.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bx_manage_permission.name
     *
     * @return the value of bx_manage_permission.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bx_manage_permission.name
     *
     * @param name the value for bx_manage_permission.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bx_manage_permission.type
     *
     * @return the value of bx_manage_permission.type
     *
     * @mbggenerated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bx_manage_permission.type
     *
     * @param type the value for bx_manage_permission.type
     *
     * @mbggenerated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bx_manage_permission.status
     *
     * @return the value of bx_manage_permission.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bx_manage_permission.status
     *
     * @param status the value for bx_manage_permission.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}