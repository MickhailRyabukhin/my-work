import java.util.*;

public class CoolNumbers {

    public static List<String> coolNumbers = new ArrayList<>();
    public static int coolNumbersId = 0;
    public CoolNumbers() {
    }

    public static List<String> generateCoolNumbers() {
        String baseLetter = "АВЕКМНОРСТУХ";                             // Базовый набор букв
        for (int firstLetter = 0; firstLetter < 12; firstLetter++) {
            for (int num = 0; num < 10; num++) {
                for (int secondLetter = 0; secondLetter < 12; secondLetter++) {
                    for (int thirdLetter = 0; thirdLetter < 12; thirdLetter++) {
                        for (int region = 1; region < 200; region++) {
                            StringBuilder coolNumber = new StringBuilder();
                            coolNumber.append(baseLetter.charAt(firstLetter)).append(num).append(num).append(num);
                            coolNumber.append(baseLetter.charAt(secondLetter)).append(baseLetter.charAt(thirdLetter));
                            if (region < 10) {
                                coolNumber.append("0").append(region);
                            } else {
                                coolNumber.append(region);
                            }
                            coolNumbers.add(coolNumbersId, coolNumber.toString());
                            coolNumbersId++;
                        }
                    }
                }
            }
        }
        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }


    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int index = Collections.binarySearch(sortedList, number);
        return index >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
