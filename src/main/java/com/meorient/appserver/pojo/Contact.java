package com.meorient.appserver.pojo;

/**
 * @author sunwanghe
 * @date 2019/6/10 12:01
 */
public class Contact {
	private String companyname;
	private String contactname;
	private String phone;
	private String homephone;
	private String mobile;

	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * @param companyname
	 *                        the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * @return the contactname
	 */
	public String getContactname() {
		return contactname;
	}

	/**
	 * @param contactname
	 *                        the contactname to set
	 */
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *                  the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the homephone
	 */
	public String getHomephone() {
		return homephone;
	}

	/**
	 * @param homephone
	 *                      the homephone to set
	 */
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *                   the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
