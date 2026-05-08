// 日付クラスDay【第３版】
package challenge01;

public class Day {
	private int year = 1; // 年
	private int month = 1; // 月
	private int date = 1; // 日

	// -- コンストラクタ --// 改良
	public Day() {
	}

	public Day(int year) {
		this.year = year;
	}

	public Day(int year, int month) {
		this(year);
		this.month = month;
	}

	public Day(int year, int month, int date) {
		this(year, month);
		this.date = date;
	}

	public Day(Day d) {
		this(d.year, d.month, d.date);
	}
	// ここまでコンストラクタ
	
	// --- 年・月・日を取得 ---//
	public int getYear() {
		return year;
	} // 年を取得

	public int getMonth() {
		return month;
	} // 月を取得

	public int getDate() {
		return date;
	} // 日を取得

	// --- 年・月・日を設定 ---//
	public void setYear(int year) {
		this.year = year;
	} // 年を設定

	public void setMonth(int month) {
		this.month = month;
	} // 月を設定

	public void setDate(int date) {
		this.date = date;
	} // 日を設定

	public void set(int year, int month, int date) { // 年月日を設定
		this.year = year; // 年
		this.month = month; // 月
		this.date = date; // 日
	}

	// --- 曜日を求める ---//
	public int dayOfWeek() {
		int y = year; // 0 … 日曜日
		int m = month; // 1 … 月曜日
		if (m == 1 || m == 2) { // ：
			y--; // 5 … 金曜日
			m += 12; // 6 … 土曜日
		}
		return (y + y / 4 - y / 100 + y / 400 + (13 * m + 8) / 5 + date) % 7;
	}

	// --- 日付dと等しいか ---//
	public boolean equalTo(Day d) {
		return year == d.year && month == d.month && date == d.date;
	}

	// --- 文字列表現を返却 ---//
	public String toString() {
		String[] wd = { "日", "月", "火", "水", "木", "金", "土" };
		return String.format("%04d年%02d月%02d日(%s)", year, month, date, wd[dayOfWeek()]);
	}


}
