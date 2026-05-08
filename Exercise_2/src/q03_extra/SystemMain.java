package q03_extra;

/**
 * 会員登録システムのエントリーポイント
 * 
 */
public class SystemMain {

	public static void main(String[] args) {

		MemberStorage memberStorage = new MemberStorage();
		CreateUserService createUserService = new CreateUserService(memberStorage);
		boolean isCreated = false;
		int inputId = 0;
		String inputPassword = "";
		String inputName = "";
		String inputBirthday = "";

		System.out.println("新規に会員登録します。必要事項を入力してください");
		//TODO ここから実装する

		while (!isCreated) {
			try {
				//get input from ConsoleReader
				System.out.print("input id[1-9]>>");
				inputId = (int) new MemberIdReader().input();
				System.out.print("input password>>");
				inputPassword = (String) new MemberPasswordReader().input();
				System.out.print("input name>>");
				inputName = (String) new MemberNameReader().input();
				System.out.print("input birthday>>");
				inputBirthday = (String) new MemberBirthdayReader().input();

				//execute createUserService
				isCreated = createUserService.execute(inputId, inputPassword, inputName, inputBirthday);
				if (isCreated) {
					System.out.println("ユーザが作成されました");
					System.out.println("ユーザ情報を表示します。");
					//memberStorage.getMembers().getLast().showMember();

					Member lastMember = null;
					//memberStorage.getMembers()の最後の要素を取得する

					for (Member member : memberStorage.getMembers()) {
						lastMember = member;
					}
					if (lastMember != null) {
						lastMember.showMember();
					}
				}
			} catch (IllegalInputException e) {
				System.out.println(e.getMessage());
			} catch (SystemErrorException e) {
				e.printStackTrace();
			}
		}

	}

}
