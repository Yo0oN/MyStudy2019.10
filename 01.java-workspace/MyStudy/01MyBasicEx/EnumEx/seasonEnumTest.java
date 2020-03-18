package EnumEx;

public class seasonEnumTest {
	public void compareEnum(Season season) {
		if (season.equals(Season.SPRING)) {
			System.out.println("따뜻한 봄날입니다");
		} else if (season.compareTo(Season.WINTER) < 0) {
			System.out.println("최소한 겨울은 아니잖아요");
		} else {
			System.out.println(season.compareTo(Season.WINTER));
		}
	}
}
