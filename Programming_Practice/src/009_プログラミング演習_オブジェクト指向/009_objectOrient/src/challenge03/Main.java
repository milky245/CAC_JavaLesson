package challenge03;
//提供されたクラスのメソッドを組み合わせて、Main.javaのmainメソッドを構築してください。
//	mainメソッド内でGladiatorクラスを2つインスタンス化し、battleメソッドで戦わせます。
//	最後にHPが残っている方を勝ちとし、introduceメソッドを使って自己紹介させてください。
//	ただし、下記のメソッドが完全ではありません。内容を分析して修正してください。
public class Main {

	/**
	 * HumanクラスのtoStringメソッドを出力
	 * 
	 * @param human
	 */
	static void introduce(Human human) {
		System.out.println(human);
	}

	/**
	 * 両者の攻撃と防御を判定し、ダメージ計算を行う
	 * 
	 * @param p1
	 * @param p2
	 */
	static void battle(Gladiator p1, Gladiator p2) {
		// p1 先手
		// 攻撃実行判定
		//canAttackメソッドを呼び出し、攻撃が可能かどうかを判定する
		if (p1.canAttack() && p2.canDefence()) {
			// 攻撃が可能な場合、攻撃力を取得する
			if(p1.attack()>p2.defence()) {
				// 攻撃力が防御力を上回る場合、ダメージを計算する
				int damage = p1.attack() - p2.defence();
				// ダメージをp2のHPから減算する
				p2.damage(damage);
				System.out.println(p1.getName() + "の攻撃が成功！" + p2.getName() + "防衛も成功、防衛後" + damage + "のダメージを受けました。");
			}
			else {
				// 攻撃力が防御力を上回らない場合、ダメージは0とする
				p2.damage(0);
				System.out.println(p1.getName() + "の攻撃が成功！" + p2.getName() + "防衛も成功、防衛後0のダメージを受けました。");
			}
		}
		else if(p1.canAttack()){
			p2.damage(p1.attack());
			System.out.println(p1.getName() + "の攻撃が成功！" + p2.getName() + "防衛に失敗、防衛後" + p1.attack() + "のダメージを受けました。");
		}

	}

	/**
	 * メインメソッド
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 各種クラス、メソッドを組み合わせてプログラムを実装する
		// Gladiatorクラスを2つインスタンス化する
		Gladiator gladiator1 = new Gladiator("FireKnight", "male", 20, "FireSword", 10, "FireShield", 5);
		Gladiator gladiator2 = new Gladiator("WaterKnight", "female", 18, "WaterSword", 8, "WaterShield", 7);
		// 戦闘を実行する
		//随机选择一个对象作为先手，并循环至一方hp到0为止
		while (gladiator1.getHp() > 0 && gladiator2.getHp() > 0) {
			if (Math.random() < 0.5) {
				battle(gladiator1, gladiator2);
			} else {
				battle(gladiator2, gladiator1);
			}
		}
		// 勝者を判定し、自己紹介する
		System.out.println("戦闘終了！勝者は" + (gladiator1.getHp() > 0 ? gladiator1.getName() : gladiator2.getName()) + "です！");
		if (gladiator1.getHp() > 0) {
			introduce(gladiator1);
		} else {
			introduce(gladiator2);
		}
	}

}
