package hwst.domain.users;

import hwst.domain.users.UsersEnum.UserSection;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.stereotype.Repository;


@Repository("UsersVo")
public class UsersVo{
	private int userNo;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String postCode;
	private String address;
	private UserSection userSection;
	
	
	public UsersVo() {}

	public UsersVo(int userNo, String id, String pw, String name,
			String phone, String postCode, String address, UserSection userSection) {
		this.userNo = userNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.postCode = postCode;
		this.address = address;
		this.userSection = userSection;
	}
	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserSection getUserSection() {
		return userSection;
	}

	public void setUserSection(UserSection userSection) {
		this.userSection = userSection;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.MULTI_LINE_STYLE
				);
	}
}
