package ru.skillbox;
/**
 * Задание 1
 * * Что нужно сделать
 * Создайте иммутабельный (неизменяемый) класс Book для хранения информации о книге, содержащий поля:
 * - название,
 * - автор,
 * - количество страниц,
 * - номер ISBN.
 */
public class Book {

    private final String name;
    private final String authorName;
    private final int pagesCount;
    private final String posISBN;

    public Book(String bookName, String authorName, int pagesCount, String posISBN) {
        this.name = bookName;
        this.authorName = authorName;
        this.pagesCount = pagesCount;
        this.posISBN = posISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public String getPosISBN() {
        return posISBN;
    }

    public String toString(){
        return  "Название               " + name +"\n"+
                "Автор                  " + authorName + "\n"+
                "Количество страниц     " + pagesCount + "\n"+
                "Номер ISSN             " + posISBN;
    }
}
