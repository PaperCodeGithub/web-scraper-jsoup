package javaweb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaWebOps {

    private String url;
    private Document doc;
    public JavaWebOps(String url) {
        this.url = url;
        try {
            doc = Jsoup.connect(this.url).get();
        } catch (IOException e) {
            System.out.println("Java Web Operations: Failed to connect to " + this.url);
            throw new RuntimeException(e);
        }
    }

    public String setUrl(String url) {
        this.url = url;
        return url;
    }

    public String getUrl() {
        return url;
    }

    public String getTitleOfPage(){
        return doc.title();
    }

    public List<String> getAllLinks(){
        List<String> links = new ArrayList<>();
        Elements elements = doc.select("a[href]");
        for (Element element : elements) {
            links.add(element.absUrl("href"));
        }
        return links;
    }

    public List<String> getAllImages(){
        List<String> images = new ArrayList<>();
        Elements elements = doc.select("img[src]");
        for (Element element : elements) {
            images.add(element.absUrl("src"));
        }
        return images;
    }

    public List<String> getAllTexts(){
        List<String> texts = new ArrayList<>();
        Elements elements = doc.select("text");
        for (Element element : elements) {
            texts.add(element.text());
        }
        return texts;
    }

    public List<String> getAllCss(){
        List<String> css = new ArrayList<>();
        Elements elements = doc.select("link[href]");
        for (Element element : elements) {
            css.add(element.absUrl("href"));
        }
        return css;
    }

    public String getDataAtElementTag(String tagName){
        return doc.getElementsByTag(tagName).text();
    }

    public String getDataAtElementClass(String className){
        return doc.getElementsByClass(className).text();
    }

    public String getDataAtElementId(String id){
        return doc.getElementById(id).text();
    }

    public String getSource(){
        return doc.toString();
    }
}
