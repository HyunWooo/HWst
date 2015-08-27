package hwst.domain.users;

public enum Grade {

	UNREGISTER(1),
	GENERAL(2), 
	SILVER(3),
	GOLD(4);
	
	private int value;

    private Grade(int value) {
            this.value = value;
    }

	public int getValue() {
		return value;
	}
}
