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

		public static UserSection valueOf(int value){
			switch(value){
				case 2: return UserSection.BUYER;
				case 3: return UserSection.SELLER;
				case 4: return UserSection.ADMIN;
				default : throw new AssertionError("Unknown userSection: " + value);
			}
		}
        
	};
	
}
