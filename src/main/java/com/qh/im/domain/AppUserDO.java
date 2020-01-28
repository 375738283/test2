package com.qh.im.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author sfsfsfs
 * @email 24242423423@qq.com
 * @date 2019-07-23 22:39:51
 */
public class AppUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String mobile;
	//
	private String nikeName;
	//
	private String password;
	//
	private String qq;
	//
	private String weChat;
	//性别 0：男，1:女
	private Integer sex;
	//
	private Integer status;
	//
	private Integer authStatus;
	//
	private String token;
	//城市
	private String city;
	//星座
	private String constellation;
	//经度
	private BigDecimal x;
	//维度
	private BigDecimal y;
	//身高
	private Integer height;
	//体重
	private Integer weight;
	//性别 0：非vip，1:vip
	private Integer vip;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：
	 */
	public void setNikeName(String nikeName) {
		this.nikeName = nikeName;
	}
	/**
	 * 获取：
	 */
	public String getNikeName() {
		return nikeName;
	}
	/**
	 * 设置：
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：
	 */
	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}
	/**
	 * 获取：
	 */
	public String getWeChat() {
		return weChat;
	}
	/**
	 * 设置：性别 0：男，1:女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别 0：男，1:女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setAuthStatus(Integer authStatus) {
		this.authStatus = authStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getAuthStatus() {
		return authStatus;
	}
	/**
	 * 设置：
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * 获取：
	 */
	public String getToken() {
		return token;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：星座
	 */
	public void setConstellation(String constellation) {
		this.constellation = constellation;
	}
	/**
	 * 获取：星座
	 */
	public String getConstellation() {
		return constellation;
	}
	/**
	 * 设置：经度
	 */
	public void setX(BigDecimal x) {
		this.x = x;
	}
	/**
	 * 获取：经度
	 */
	public BigDecimal getX() {
		return x;
	}
	/**
	 * 设置：维度
	 */
	public void setY(BigDecimal y) {
		this.y = y;
	}
	/**
	 * 获取：维度
	 */
	public BigDecimal getY() {
		return y;
	}
	/**
	 * 设置：身高
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * 获取：身高
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * 设置：体重
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	/**
	 * 获取：体重
	 */
	public Integer getWeight() {
		return weight;
	}
	/**
	 * 设置：性别 0：非vip，1:vip
	 */
	public void setVip(Integer vip) {
		this.vip = vip;
	}
	/**
	 * 获取：性别 0：非vip，1:vip
	 */
	public Integer getVip() {
		return vip;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
