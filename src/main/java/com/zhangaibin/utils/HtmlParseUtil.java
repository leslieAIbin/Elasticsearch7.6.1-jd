package com.zhangaibin.utils;

import com.zhangaibin.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leslie
 * 2020/11/19 15:35
 */
public class HtmlParseUtil {
    public static void main(String[] args) throws Exception {
        new HtmlParseUtil().parseJD("大连理工").forEach(System.out::println);
    }

    public List<Content> parseJD(String keywords) throws Exception{
        // 获取请求
        // String url = "https://search.jd.com/Search?keyword=" + keywords+"&enc=utf-8";
        // 指定编码集，防止中文乱码
        Document document = null;
        try {
            document = Jsoup.parse(new URL("https://search.jd.com/Search?keyword=" + keywords + "&enc=utf-8"), 30000);
        } catch (IOException e) {
            System.out.println("---JDSearchHtmlParser.parse()失败---");
            e.printStackTrace();
        }
        //解析网页（jsoup返回的document就是浏览器返回的Document对象）
        //Document document = Jsoup.parse(new URL(url), 30000);
        // 所有在js中的方法，都可以使用
        Element element = document.getElementById("J_goodsList");
        // 获取所有的li元素
        Elements elements = element.getElementsByTag("li");
        List<Content> goodList = new ArrayList<>();
        // 获取元素内容,每个li标签
        for (Element el : elements) {
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            Content content = new Content();
            content.setImg(img);
            content.setPrice(price);
            content.setTitle(title);
            goodList.add(content);
        }
        return goodList;
    }
}
