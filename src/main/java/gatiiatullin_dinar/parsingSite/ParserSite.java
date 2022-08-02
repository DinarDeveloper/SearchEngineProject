package gatiiatullin_dinar.parsingSite;

import gatiiatullin_dinar.models.Page;
import gatiiatullin_dinar.repository.PageRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.RecursiveAction;
import java.util.stream.Collectors;

@Component
public class ParserSite extends RecursiveAction {

    public String url;

    @Autowired
    private PageRepository pageRepository;

    public ParserSite(String url) {
        this.url = url.trim();
    }

    @Override
    protected void compute() {

        try {
            Thread.sleep(500);

            Document doc = JsoupConnection.getConnection(url).parse();
            Elements elements = doc.select("a[href]");

            Set<String> allLinks = elements.stream().map(el -> el.attr("href"))
                    .filter(l -> !l.isEmpty())
                    .filter(l -> l.startsWith("/"))
                    .collect(Collectors.toSet());


            for (String link : allLinks) {
                ParserSite parserSite = new ParserSite(link);
                parserSite.fork();

                // Page page = new Page(parserSite.url,getResponseCode(),pageContent(parserSite));

                Page page = new Page();
                page.setPath(parserSite.url);
                page.setCode(getResponseCode());
                page.setContent(pageContent(parserSite));
                pageRepository.save(page);
                //BatchingProcessing.addPage(page);
                // parserSite.join();
            }

        } catch (InterruptedException | IOException ignoring) {
            throw new RuntimeException(ignoring);
        }
    }


    private int getResponseCode() throws IOException {
        return JsoupConnection.getConnection(url).statusCode();
    }

    private String pageContent(ParserSite parserSite) throws IOException {
        return Jsoup.connect(removeLastChar(url) + parserSite.url).maxBodySize(0).get().html();
    }

    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
}