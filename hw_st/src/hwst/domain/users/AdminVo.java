package hwst.domain.users;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import hwst.domain.users.UserSection;

public class AdminVo extends UsersVo{
	
	String adminName;


	public AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminVo(int userNo, String id, String pw, String name, String phone,
			UserSection userSection, String postCode, String address) {
		super(userNo, id, pw, name, phone, address, postCode, userSection);
		// TODO Auto-generated constructor stub
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(
				this, ToStringStyle.MULTI_LINE_STYLE
				);
	}

	
	

}
