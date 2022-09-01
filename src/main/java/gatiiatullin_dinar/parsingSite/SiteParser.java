package gatiiatullin_dinar.parsingSite;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RecursiveTask;

public class SiteParser extends RecursiveTask<Set<String>> {

    public String strUrl;

    public SiteParser(String strUrl) {
        this.strUrl = strUrl;
    }

    @Override
    protected Set<String> compute() {

        Set<String> result = new HashSet<>();
        Set<String> tmpResult = new HashSet<>();
        Set<SiteParser> taskList = new HashSet<>();
        try {
            result.add(strUrl);
            tmpResult.addAll(SiteMap.readJsoup(strUrl));
            SiteMap.noDoubles.add(strUrl);
            for (String url : tmpResult) {
                taskList.add(new SiteParser(url));
            }
            for (SiteParser task : taskList) {
                task.fork();
            }
            for (SiteParser task : taskList) {
                result.addAll(task.join());
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
