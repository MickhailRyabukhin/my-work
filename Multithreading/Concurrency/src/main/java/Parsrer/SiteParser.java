package Parsrer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class SiteParser extends RecursiveTask<Set<String>> {
    public String url;

    public SiteParser(String url) {
        this.url = url;

    }


    @Override
    protected Set<String> compute() {                  // метод с автозапуском при создании класса SiteParser
        List<String> urlList = new ArrayList<>(Utils.getSiteMap(url));
        List<SiteParser> taskList = Utils.taskList(urlList);
//        tabs+="\t";
        for (SiteParser task:taskList) {
            task.fork();
        }
        for (SiteParser task : taskList) {
            Utils.noDoubles.addAll(task.join());
        }
        return Utils.noDoubles;
    }


}
