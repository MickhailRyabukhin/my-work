import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String FIRST_URL = "https://skillbox-java.github.io/";
    public static final String OUT_FILE = "src/main/MskM.json";
    public static final String regLid = "(\\w+)\"";
    public static final Pattern patLid = Pattern.compile(regLid, Pattern.MULTILINE);
    public static final String regConName = "«([а-яА-ЯёЁ -]+)";
    public static final Pattern patCon = Pattern.compile(regConName, Pattern.MULTILINE);
    public static JSONObject jsonStations = new JSONObject();   // Здесь будет список всех станций
    public static JSONArray lineList = new JSONArray();         // Здесь будет список всех линий
    public static JSONArray jsonConnects = new JSONArray();     // Здесь будут все соединения
    public static ArrayList<ArrayList<String>> dupKill = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        String lineID;

        String lineName;
        try {

            Document doc = Jsoup.connect(FIRST_URL).get();
            // Считываем данный из сети. Хорошо хоть сайт не настоящий :)
            // ниже - дя настоящих сайтов
//                    .data("query", "Java")
//                    .userAgent("Mozilla")
//                    .cookie("auth", "token")
//                    .timeout(3000)
//                    .post();
            // Отфильтровываем нужную информацию по линиям метро (идентификатор и название)
            // Здесь информация о линиях метро
            Elements lines = doc.select(".js-metro-line");
            // Здесь информация о станциях метро, вместе с переходами
            Elements stations = doc.select(".js-depend");

            int lineNum;
            // Обходим все линии по очереди. lineNum - номер в очереди
            // складываем в этот массив

            for (lineNum = 0; lineNum < lines.size(); lineNum++) {
//                ====== С О Б И Р А Е М  Л И Н И Ю ==========
                Element line = lines.get(lineNum);                                //  Очередной элемент (линия)
                lineID = line.attr("data-line");                        // Идентификатор линии (строка)
                ArrayList<String> stationNames = new ArrayList<>();             // Массив названий станций этой линии
                lineName = line.childNode(0).toString();                         // Название линии (строка)
                JSONObject jsonline = new JSONObject();
                jsonline.put("ID", lineID);                                          // Создаем объект ЛИНИЯ
                jsonline.put("name", lineName);
                lineList.add(jsonline);                                          // И добавляем в массив линий
                System.out.println(lineID + "  " + lineName);
                System.out.println("=========== С Т А Н Ц И И =============");
                Elements stationList = stations.get(lineNum).getElementsByTag("p");
                for (Element station : stationList) {
                    String stName = station.childNode(1).childNode(0).toString();
                    System.out.println(stName);
                    stationNames.add(stName);
                    // Собираем станции одной линии
//               ============ П Е Р Е Х О Д Ы ============
                    // Теперь займемся переходами
                    if (station.childNodes().size() > 2) {
                        ArrayList<String> thisconnect = new ArrayList<>();
                        // табуляторы - для упрощения последующей разбивки строк
                        thisconnect.add(lineID + "\t" + stName+"\t");
                        for (int i = 2; i < station.childNodes().size(); i++) {
                            String lID;
                            String conName = "";
                            String title = station.childNode(i).toString();
                            Matcher lIDmatcher = patLid.matcher(title);
                            if (lIDmatcher.find()) {
                                lID = lIDmatcher.group(1);
                            } else break;
                            Matcher matcher = patCon.matcher(title);
                            if (matcher.find()) {
                                conName = matcher.group(1);
                            }
                            // Все переходы этой станции собираем в масиив thisconnect
                            thisconnect.add(lID + "\t" + conName + "\t");
                        }
                        // Если есть переходы, проверяем, есть ли аналоги
                        if (thisconnect.size() > 1) {
                            if (hasNoSet(thisconnect)) {
                                // Если переходы не дублируются, то добавляем новый
                                dupKill.add(thisconnect);
                            }
                        }
                    }
                }
                System.out.println("====================================");
                // Здесь все станции с указанием линии
                jsonStations.put(lineID, stationNames);
            }
//               =============== С Б О Р К А   С О Е Д И Н Е Н И Й ==================
//          в двумерном листе "dupKill" отфильтрованы все дубликаты и проведены дополнения
//          списков переходов между станциями (сединений)
            // выбираем нужный список
            for (ArrayList<String> connectList:dupKill){
            JSONArray jsonConnect = new JSONArray();
                // разбираем на строки
                for (String thisCon:connectList) {
                    JSONObject jsonCon = new JSONObject();
                    // строка перехода -  индекс линии и название станции
                    // делим сплитом
                    String[] conObj = thisCon.split("\t");
                    // и заносим в JSONObject jsonCon
                    jsonCon.put("line",conObj[0]);
                    jsonCon.put("Station",conObj[1]);
                    // Его добавляем в список соединения
                    jsonConnect.add(jsonCon);
                }
                // и собираем все в общий список
            jsonConnects.add(jsonConnect);
            }
            // по заданию выводим в консоль количество переходов
            System.out.println("Количество переходов:    "+dupKill.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeJsonMskMetro(OUT_FILE);
    }

    public static boolean hasNoSet(ArrayList<String> thisConnect) {
        for (int i = 0; i < dupKill.size(); i++) {
            ArrayList<String> thisconnects = dupKill.get(i);
            StringBuilder sb = new StringBuilder();
            for (String string : thisconnects) {
                sb.append(string);
            }
            String conStr = sb.toString();
            boolean hasString = false;
            for (String connect : thisConnect) {
                if (conStr.contains(connect)) {
                    hasString = true;
                    break;
                }
            }
            if (hasString) {
                for (int j = 0; j < thisConnect.size(); j++) {
                    String thisCon = thisConnect.get(j);
                    if (!conStr.contains(thisCon)) {
                        dupKill.get(i).add(thisCon);
                    }
                }
                return false;
            }
        }
        return true;
    }

    public static void writeJsonMskMetro(String filename) throws Exception {
        JSONObject mskMetro = new JSONObject();

        mskMetro.put("lines", lineList);                              // Собираем конечную запись
        mskMetro.put("stations", jsonStations);
        mskMetro.put("connections", jsonConnects);
        Files.writeString(Paths.get(filename), mskMetro.toJSONString());
    }
}
