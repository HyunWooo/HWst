package hwst.domain.users;

public class AdminVo extends UsersVo{
	
	String adminName;


	public AdminVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminVo(int userNo, String id, String pw, String name, String phone,
			int userSection, String postCode, String address) {
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
		StringBuilder builder = new StringBuilder();
		builder.append("AdminVo [adminName=");
		builder.append(adminName);
		builder.append("]");
		return builder.toString();
	}
	
	

}
