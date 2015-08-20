package hwst.domain.users;

public class UsersEnum {

	public enum UserSection{
		UNREGISTER(1),
		BUYER(2), 
		SELLER(3),
		ADMIN(4);
		
		private int value;
 
        private UserSection(int value) {
                this.value = value;
        }

		public int getValue() {
			return value;
		}

	};
	
	
	public enum Grade{
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

	};
}
