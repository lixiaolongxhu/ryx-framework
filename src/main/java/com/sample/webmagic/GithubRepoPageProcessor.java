//package com.sample.webmagic;
//
//import java.util.List;
//
//import org.apache.log4j.ConsoleAppender;
//
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.pipeline.FilePipeline;
//import us.codecraft.webmagic.pipeline.JsonFilePipeline;
//import us.codecraft.webmagic.processor.PageProcessor;
//import us.codecraft.webmagic.scheduler.RedisScheduler;
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//
///**
// * @author code4crafter@gmail.com <br>
// * @since 0.3.2
// */
//public class GithubRepoPageProcessor implements PageProcessor {
//	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
//    private Site site = Site.me().setRetryTimes(2).setSleepTime(1000);
//    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
//    @Override
//    public void process(Page page) {
//    	
//    	// 部分二：定义如何抽取页面信息，并保存下来
//    	  
////        page.addTargetRequests(page.getHtml().links().regex("(http://blog.csdn.net/smilingleo/article/details/\\w+)").all());
//      //  page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("author", page.getUrl().toString());
//     //   page.putField("author", page.getHtml().links().toString());
//     //   page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        //所有的直接和间接文本子节点，并将一些标签替换为换行，使纯文本显示更整洁
//          //page.putField("name", page.getHtml().xpath("//table[@class='category']/tbody/tidyText()"));
//        page.putField("name", page.getHtml());	
//       // page.putField("name", page.getHtml().xpath("//table/tidyText()"));
//        // 所有的直接和间接文本子节点
//        //page.putField("name", page.getHtml().xpath("//table[@class='category']/tbody/allText()"));
//        
//      //  page.putField("name", page.getHtml().xpath("//div[@class='details']").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
////      page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//        page.putField("allLink", page.getHtml().links().all());
//        
//    // 部分三：从页面发现后续的url地址来抓取
//    //  page.addTargetRequests(page.getHtml().links().regex("(http://weibo\\.cn/jiuzhaigou/\\w+/\\w+)").all());
//    //page.addTargetRequests(page.getHtml().links().all());
//     
//   //     page.addTargetRequests(page.getHtml().links().all());
//    }
//    
////    @Override
////    public void process(Page page) {
//// 
////        String imgRegex = "http://pic.meizitu.com/wp-content/uploads/20[0-9]{2}[a-z]/[0-9]{1,4}/[0-9]{1,4}/[0-9]{1,4}.jpg";
////        String urlPattern = "http://www.meizitu.com/[a-z]/[0-9]{1,4}.html";
////        List<String> requests = page.getHtml().links().regex(urlPattern).all();
////        page.addTargetRequests(requests);
////        String imgHostFileName = page.getHtml().xpath("//title/text()").toString().replaceAll("[|\\pP‘’“”\\s(妹子图)]", "");
////        List<String> listProcess = page.getHtml().$("div#picture").regex(imgRegex).all();
////        //此处将标题一并抓取，之后提取出来作为文件名
////        listProcess.add(0, imgHostFileName);
////        page.putField("img", listProcess);
//// 
////    }
//
//    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    public static void main(String[] args) {
//        //Spider.create(new GithubRepoPageProcessor()).addUrl("http://blog.csdn.net/smilingleo/article/details/3541449").thread(1).run();
//    	Spider.create(new GithubRepoPageProcessor())
//    	.addUrl("http://trends.baidu.com/tour/?provinceId=28")
//   // 	.addUrl("http://www.meizitu.com/a/5186.html")
//    //  .addUrl("http://jiuzhai.com/index.php/news/dynamic.html")
//   // 	.addUrl("http://weibo.cn/jiuzhaigou")
//    //	.addUrl("http://weibo.com/p/1001061803921393/home?from=page_100106&mod=TAB#place")
//    	//以json格式输出到指定路径的文件保存
//    //	.addPipeline(new JsonFilePipeline("D:\\webmagic\\"))
//    	//输出到控制台
//    	.addPipeline(new ConsolePipeline())
//    	.addPipeline(new FilePipeline("D:/webmagic"))
//    	.thread(2)
//    	.run();
//    }
//}
