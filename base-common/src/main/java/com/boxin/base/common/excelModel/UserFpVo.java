package com.boxin.base.common.excelModel;

import com.boxin.base.common.util.ExcelVOAttribute;


public class UserFpVo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.real_name
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "真实姓名", column = "A")
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.phone
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "联系电话", column = "B")
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.name
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "用户名", column = "C")
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.email
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "电子邮件", column = "D")
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.product_line
     *
     * @mbggenerated
     */
    
    private Integer productLine;
    
    @ExcelVOAttribute(name = "产品线", column = "E")
    private String product;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.corporation
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "公司名称", column = "F")
    private String corporation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.region
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "区域", column = "G")
    private String region;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.branch
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "子公司", column = "H")
    private String branch;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.buss_dept
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "营业部", column = "I")
    private String bussDept;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.divisions
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "分部", column = "J")
    private String divisions;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.team
     *
     * @mbggenerated
     */
    @ExcelVOAttribute(name = "团队", column = "K")
    private String team;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ezg_user_fp.grade
     *
     * @mbggenerated
     */
    private Integer grade;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.id
     *
     * @return the value of ezg_user_fp.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.id
     *
     * @param id the value for ezg_user_fp.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.real_name
     *
     * @return the value of ezg_user_fp.real_name
     *
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.real_name
     *
     * @param realName the value for ezg_user_fp.real_name
     *
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.phone
     *
     * @return the value of ezg_user_fp.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.phone
     *
     * @param phone the value for ezg_user_fp.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.name
     *
     * @return the value of ezg_user_fp.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.name
     *
     * @param name the value for ezg_user_fp.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.email
     *
     * @return the value of ezg_user_fp.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.email
     *
     * @param email the value for ezg_user_fp.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.product_line
     *
     * @return the value of ezg_user_fp.product_line
     *
     * @mbggenerated
     */
    public Integer getProductLine() {
        return productLine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.product_line
     *
     * @param productLine the value for ezg_user_fp.product_line
     *
     * @mbggenerated
     */
    public void setProductLine(Integer productLine) {
        this.productLine = productLine;
    }

    public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.corporation
     *
     * @return the value of ezg_user_fp.corporation
     *
     * @mbggenerated
     */
    public String getCorporation() {
        return corporation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.corporation
     *
     * @param corporation the value for ezg_user_fp.corporation
     *
     * @mbggenerated
     */
    public void setCorporation(String corporation) {
        this.corporation = corporation == null ? null : corporation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.region
     *
     * @return the value of ezg_user_fp.region
     *
     * @mbggenerated
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.region
     *
     * @param region the value for ezg_user_fp.region
     *
     * @mbggenerated
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.branch
     *
     * @return the value of ezg_user_fp.branch
     *
     * @mbggenerated
     */
    public String getBranch() {
        return branch;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.branch
     *
     * @param branch the value for ezg_user_fp.branch
     *
     * @mbggenerated
     */
    public void setBranch(String branch) {
        this.branch = branch == null ? null : branch.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.buss_dept
     *
     * @return the value of ezg_user_fp.buss_dept
     *
     * @mbggenerated
     */
    public String getBussDept() {
        return bussDept;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.buss_dept
     *
     * @param bussDept the value for ezg_user_fp.buss_dept
     *
     * @mbggenerated
     */
    public void setBussDept(String bussDept) {
        this.bussDept = bussDept == null ? null : bussDept.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.divisions
     *
     * @return the value of ezg_user_fp.divisions
     *
     * @mbggenerated
     */
    public String getDivisions() {
        return divisions;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.divisions
     *
     * @param divisions the value for ezg_user_fp.divisions
     *
     * @mbggenerated
     */
    public void setDivisions(String divisions) {
        this.divisions = divisions == null ? null : divisions.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.team
     *
     * @return the value of ezg_user_fp.team
     *
     * @mbggenerated
     */
    public String getTeam() {
        return team;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.team
     *
     * @param team the value for ezg_user_fp.team
     *
     * @mbggenerated
     */
    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ezg_user_fp.grade
     *
     * @return the value of ezg_user_fp.grade
     *
     * @mbggenerated
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ezg_user_fp.grade
     *
     * @param grade the value for ezg_user_fp.grade
     *
     * @mbggenerated
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}