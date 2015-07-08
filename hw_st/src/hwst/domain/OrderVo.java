package hwst.domain;

public class OrderVo {

	private int orCode;
	private int userCode;
	private int proCode;
	private int orAmount;
	private String orTime;
	private int depositStat;
	
	public OrderVo(){}
	
	public OrderVo(int orCode, int userCode, int proCode,
			int orAmount, String orTime, int depositStat) {
		super();
		this.orCode = orCode;
		this.userCode = userCode;
		this.proCode = proCode;
		this.orAmount = orAmount;
		this.orTime = orTime;
		this.depositStat = depositStat;
	}

	public int getOrCode() {
		return orCode;
	}

	public void setOrCode(int orCode) {
		this.orCode = orCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public int getProCode() {
		return proCode;
	}

	public void setProCode(int proCode) {
		this.proCode = proCode;
	}

	public int getOrAmount() {
		return orAmount;
	}

	public void setOrAmount(int orAmount) {
		this.orAmount = orAmount;
	}

	public String getOrTime() {
		return orTime;
	}

	public void setOrTime(String orTime) {
		this.orTime = orTime;
	}

	public int getDepositStat() {
		return depositStat;
	}

	public void setDepositStat(int depositStat) {
		this.depositStat = depositStat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderVo [orCode=");
		builder.append(orCode);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", proCode=");
		builder.append(proCode);
		builder.append(", orAmount=");
		builder.append(orAmount);
		builder.append(", orTime=");
		builder.append(orTime);
		builder.append(", depositStat=");
		builder.append(depositStat);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
