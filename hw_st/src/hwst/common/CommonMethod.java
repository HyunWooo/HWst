package hwst.common;

public class CommonMethod {

	//하나의 CUD기능 완료 체크 후 T/F반환
	public static boolean isSuccessOneCUD(int stat){
		if(stat == 1){
			return true;
		}
		return false;
	}
	
	//여러 CUD기능 완료 체크 후 T/F반환
	public static boolean isSuccessManyCUD(int stat, int count){
		if(stat == count){
			return true;
		}
		return false;
	}
	
	public static boolean isEqualValues(Object one, Object two){
		return (one==two);
	}
}
