package q02_advanced.question02;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 標準入力を制御するクラス
 * IOException, NumberFormatException を throws 宣言する。なお BufferedReader を用いること。
 */
class ConsoleReader {

	/**
	 * 文字列の標準入力。
	 * 
	 * @return 入力文字列
	 * @throws IOException
	 */
	public String inputString() throws IOException {
		//TODO ここから実装する
		BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
        return reader.readLine();
	}

	/**
	 * 整数の標準入力。
	 * 
	 * @return 入力整数
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public int inputNumber() throws IOException, NumberFormatException {
		//TODO ここから実装する
		BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
		String input = reader.readLine();
		return Integer.parseInt(input);
	}

}
