package com.boxin.base.webmodel;

import java.util.Date;

/**
 * 文件信息记录
 * <p>
 *
 * </p>
 * Created by rff on 2015/5/9.
 */
public class FileInfo {
	private long id;	// 自增ID
	private String fileId; // 文件ID
	private long userId; // 上传用户ID
	private String path; // 文件相对路径
	private long size;  // 文件大小
	private int status; // 文件状态
	private int delFlag; // 删除标志
	private String hash;  // 文件 hash
	private String remark;  // 描述信息
	private Date createTime; // 创建时间

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
