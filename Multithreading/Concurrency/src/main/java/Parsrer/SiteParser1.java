package Parsrer;

import org.jetbrains.annotations.NotNull;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class SiteParser1 {
    private ArrayList<String> mapSite = new ArrayList<>();
    public String url;
    private static final String BASE_URL = Main.URL;
    final int MAX_ARRAY_SIZE = 50000;
    private static LinkedHashSet<String> noDoubles = new LinkedHashSet<>();

    public SiteParser1(String url) {
        this.url = url;
        mapSite.add(BASE_URL);
    }

    public List<String> compute(String url) {
        List<String> urlList = new ArrayList<>(Utils.getSiteMap(url));
        for (String tabsUrl:urlList){
            mapSite.add(Utils.getTabs(tabsUrl));
        }
        if (mapSite.size()>MAX_ARRAY_SIZE) {
            return mapSite;
        }
        if (urlList.size() > 1) {
            for (String child : urlList) {
                compute(child);
            }
        }
        return mapSite;

    }



}

