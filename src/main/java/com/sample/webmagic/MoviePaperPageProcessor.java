package com.sample.webmagic;

import java.util.HashSet;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class MoviePaperPageProcessor implements PageProcessor {
 private Site page = Site.me().setRetryTimes(3).setSleepTime(1000);

 public Site getSite() {
  return page;
 }

 public void process(Page page) {
  List<String> links = page.getHtml().links().regex(
    "http://weibo.com/\\d+").all();
  links = removeDuplicate(links);
  page.addTargetRequests(links);
  page.putField("title", page.getHtml().xpath(
    "//div[@id='imdbleftsecc']/center/h1/text()").toString());
  page.putField("imgurl", page.getHtml().xpath(
    "//div[@id='imdbleftsecc']/center/img/@src").toString());
 }

 public static void main(String[] args) {
  for (int i = 1; i <= 3; i++) {
   Spider.create(new MoviePaperPageProcessor()).addUrl(
     "http://blog.csdn.net/heng_ji/article/details/29825383").thread(1).run();
  }
 }

 public static List removeDuplicate(List list) {
  HashSet hs = new HashSet(list);
  list.clear();
  list.addAll(hs);
  return list;
 }
}


