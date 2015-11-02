package com.sample.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author code4crafter@gmail.com <br>
 * @since 0.3.2
 */
public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(1).setSleepTime(1000);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//        page.addTargetRequests(page.getHtml().links().regex("(http://blog.csdn.net/smilingleo/article/details/\\w+)").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
     //   page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
  //      page.putField("name", page.getJson().toString());
        page.putField("name", page.getHtml().toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
      //  Spider.create(new GithubRepoPageProcessor()).addUrl("http://blog.csdn.net/smilingleo/article/details/3541449").thread(1).run();
    	Spider.create(new GithubRepoPageProcessor()).addUrl("http://weibo.com/p/1001061803921393/album?from=page_100106&mod=TAB#place").thread(1).run();
    }
}
