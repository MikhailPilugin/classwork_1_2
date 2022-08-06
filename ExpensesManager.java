import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // Замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // Создайте таблицу
    }

    // Добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, double expense, String category) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        ArrayList<Double> expenses;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        //expenses.put(category, expense); // Замените на работу с таблицей
        if (expensesByCategories.containsKey(category)) {// Проверьте наличие категории
            // Получите список трат в этой категории
            expenses = expensesByCategories.get(category);
            // Добавьте трату
            expenses.add(expense);
            expensesByCategories.put(category, expenses);

        } else {
            // Создайте новый список трат и добавьте в него сумму
            expenses = new ArrayList<>();
            expenses.add(expense);
            // Сохраните категорию и новый список трат в хеш-таблицу
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        // Замените логику для работы с таблицами
        for(String category: expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);

            for(Double expense: expenses) {
                System.out.println(expense);
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        if(expensesByCategories.containsKey(category)) {
            ArrayList<Double> expense = expensesByCategories.get(category);
            for (Double exp : expense) {
                if (exp > maxExpense) {
                    maxExpense = exp;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear(); // Таблица называется иначе
        System.out.println("Траты удалены.");
    }
}