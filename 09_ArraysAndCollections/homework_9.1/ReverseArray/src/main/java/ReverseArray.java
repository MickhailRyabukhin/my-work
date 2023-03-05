public class ReverseArray {


    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.

    public static String[] reverse(String[] strings) {
        int length = strings.length;
        int middle = length / 2;
        String buffer;
        length = strings.length - 1;
        for (int pos = 0; pos < middle; pos++) {
            buffer = strings[pos];
            strings[pos] = strings[length - pos];
            strings[length - pos] = buffer;
        }

        return strings;
    }
}
