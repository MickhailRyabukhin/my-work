import java.util.ArrayList;

/**
 * Что нужно сделать
 * Для работы с данными списка дел в проекте находится класс TodoList,
 * который должен отвечать за хранение и работу со списком дел.
 * Реализуйте все методы и проверьте класс с помощью существующих тестов.
 * Принцип работы команд:
 * LIST — выводит дела с их порядковыми номерами;
 * ADD — добавляет дело в конец списка или дело на определённое место,
 * сдвигая остальные дела вперёд, если указать номер;
 * если указан несуществующий индекс - добавить в конец списка.
 * EDIT — заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делать.
 * DELETE — удаляет; если указан несуществующий индекс - ничего не делать.
 */

public class TodoList {
    public ArrayList<String> todos = new ArrayList<>();

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        todos.trimToSize();
        if (index > (todos.size() - 1) || index < 0) {
            System.out.println("Неверно указан номер записи ");
        } else {
            todos.remove(index);
            todos.add(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        todos.trimToSize();
        if (index > (todos.size() - 1) || index < 0) {
            System.out.println("Неверно указан номер записи ");
        } else {
            todos.remove(index);
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return todos;
    }

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todos.add(todos.size(), todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index < 0) {
            System.out.println("Неверно указан номер записи ");
            return;
        }
        if (index > todos.size()) {
            index = todos.size();
        }
        todos.add(index, todo);
    }


}
