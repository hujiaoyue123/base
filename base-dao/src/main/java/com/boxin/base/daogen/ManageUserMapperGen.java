package com.boxin.base.daogen;

import com.boxin.base.model.ManageUser;

public interface ManageUserMapperGen {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_manage_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(int id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_manage_user
     *
     * @mbggenerated
     */
    int insert(ManageUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_manage_user
     *
     * @mbggenerated
     */
    int insertSelective(ManageUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_manage_user
     *
     * @mbggenerated
     */
    ManageUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_manage_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ManageUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table base_manage_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ManageUser record);
}