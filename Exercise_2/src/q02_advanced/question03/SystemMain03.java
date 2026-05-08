package q02_advanced.question03;

public class SystemMain03 {

	public static void main(String[] args) {

		LoginService loginService = new LoginService(new MemberStorage());
		System.out.println("ログイン情報を入力してください");
		boolean isLogin = false;
		//TODO ここから実装する
		while (!isLogin) {
			ConsoleReader consoleReader = new ConsoleReader();
			try {
				System.out.println("input id>>");
				int id = consoleReader.inputNumber();
				System.out.println("input password>>");
				String password = consoleReader.inputString();
				Member member = loginService.doLogin(id, password);
				if (member == null) {
					System.out.println("ID またはパスワードが違っています。再度入力してください。");
				} else {
					System.out.println("ログインに成功しました");
					System.out.println("ログインユーザ情報を表示します。");
					System.out.println(member);
					isLogin = true;
				}
			} catch (NumberFormatException e) {
				System.out.println("不正な入力です。再度入力してください");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
