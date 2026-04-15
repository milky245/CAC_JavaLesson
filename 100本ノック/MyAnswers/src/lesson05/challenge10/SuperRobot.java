package lesson05.challenge10;

import lesson05.challenge01.Robot;
import java.util.*;

/**
 * Super smart robot that can manage ingredients, recommend menus, and cook various dishes.
 */
public class SuperRobot extends Robot {

    private Scanner scanner = new Scanner(System.in);

    // fixed ingredients list
    private final String[] ingredients = {
            "卵", "小麦粉", "砂糖", "バター",
            "牛肉", "鶏肉", "米", "牛乳",
            "トリュフ", "キャビア", "ロブスター", "野菜"
    };

    // stock of ingredients
    private final Map<String, Integer> stock = new LinkedHashMap<>();

    // recipes: dish name -> (ingredient -> quantity)
    private final Map<String, Map<String, Integer>> recipes = new LinkedHashMap<>();

    // constructor to initialize
    public SuperRobot(String name, int energy) {
        this.name = name;
        this.energy = energy;

        // 初始化库存
        for (String ingredient : ingredients) {
            stock.put(ingredient, 0);
        }
        initRecipes();
    }

    // constructor with set ingredients
    public SuperRobot(String name, int energy, Map<String, Integer> initialStock) {
        this.name = name;
        this.energy = energy;
        this.stock.putAll(initialStock);
        initRecipes();

        for (String ingredient : ingredients) {
            stock.put(ingredient, initialStock.getOrDefault(ingredient, 0));
        }
        initRecipes();
    }


    /**
     * recipes initialization
     */
    private void initRecipes() {
        addRecipe("オムレツ", Map.of("卵", 2, "バター", 5));
        addRecipe("クッキー", Map.of("小麦粉", 170, "砂糖", 50, "卵", 1, "バター", 80));
        addRecipe("ステーキ", Map.of("牛肉", 200, "野菜", 50));
        addRecipe("親子丼", Map.of("鶏肉", 150, "卵", 2, "米", 200));
        addRecipe("パンケーキ", Map.of("小麦粉", 100, "卵", 2, "牛乳", 100, "砂糖", 20));
        addRecipe("トリュフリゾット", Map.of("米", 200, "トリュフ", 10, "バター", 20));
        addRecipe("ロブスターのキャビア添え",
                Map.of("ロブスター", 1, "キャビア", 10, "バター", 10));
    }

    // add recipe to the system
    private void addRecipe(String name, Map<String, Integer> recipe) {
        recipes.put(name, new LinkedHashMap<>(recipe));
    }

    /**
     * start system
     */
    public void startCookingSystem() {
        while (true) {
            System.out.println("\n===== いらっしゃいませ、スーパーロボットの料理店へようこそ =====");
            displayStock();

            System.out.println("\n操作を選択してください：");
            System.out.println("1. 料理を作る");
            System.out.println("2. 食材を追加する");
            System.out.println("0. 終了");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cookDish();
                    break;
                case 2:
                    addIngredients();
                    break;
                case 0:
                    System.out.println("システムを終了します。またお越しください。");
                    return;
                default:
                    System.out.println("無効な入力です。");
            }
        }
    }

    /**
     * display current stock of ingredients
     */
    private void displayStock() {
        System.out.println("\n【現在の残る食材】");
        for (String ingredient : ingredients) {
            System.out.println(ingredient + "："
                    + stock.get(ingredient));
        }
    }

    /**
     * add multiple ingredients to stock
     */
    private void addIngredients() {
        System.out.println("\n追加する食材を選択してください（0で終了）:");

        while (true) {
            for (int i = 0; i < ingredients.length; i++) {
                System.out.printf("%d. %s\n", i + 1, ingredients[i]);
            }

            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > ingredients.length) {
                System.out.println("無効な番号です。");
                continue;
            }

            System.out.print("数量を入力してください：");
            int quantity = scanner.nextInt();

            String ingredient = ingredients[choice - 1];
            stock.put(ingredient, stock.get(ingredient) + quantity);

            System.out.println(ingredient + " を追加しました。");
        }
    }

    /**
     * show available dishes and cook selected dish
     */
    private void cookDish() {
        List<String> availableDishes = getAvailableDishes();

        if (availableDishes.isEmpty()) {
            System.out.println("作成可能な料理がありません。");
            return;
        }

        System.out.println("\n作成可能な料理：");
        for (int i = 0; i < availableDishes.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, availableDishes.get(i));
        }

        System.out.print("作成する料理を選択してください：");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > availableDishes.size()) {
            System.out.println("無効な選択です。");
            return;
        }

        String dish = availableDishes.get(choice - 1);
        consumeIngredients(dish);

        System.out.println("\n✨ " + dish + " が完成しました！");
    }

    /**
     * get list of dishes that can be cooked with current stock
     */
    private List<String> getAvailableDishes() {
        List<String> available = new ArrayList<>();

        for (String dish : recipes.keySet()) {
            if (canCook(dish)) {
                available.add(dish);
            }
        }
        return available;
    }

    /**
     * check if the dish can be cooked with current stock of ingredients
     */
    private boolean canCook(String dish) {
        Map<String, Integer> recipe = recipes.get(dish);

        for (String ingredient : recipe.keySet()) {
            if (stock.getOrDefault(ingredient, 0)
                    < recipe.get(ingredient)) {
                return false;
            }
        }
        return true;
    }

    /**
     * consume ingredients from stock when a dish is cooked
     */
    private void consumeIngredients(String dish) {
        Map<String, Integer> recipe = recipes.get(dish);

        for (String ingredient : recipe.keySet()) {
            stock.put(ingredient,
                    stock.get(ingredient) - recipe.get(ingredient));
        }
    }
}
