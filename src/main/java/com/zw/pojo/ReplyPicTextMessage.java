package com.zw.pojo;

import java.util.List;

public class ReplyPicTextMessage extends BaseReplyMessage {
    //图文消息个数
    private int ArticleCount;

    private List<News> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<News> getArticles() {
        return Articles;
    }

    public void setArticles(List<News> articles) {
        Articles = articles;
    }

    public ReplyPicTextMessage(int articleCount, List<News> articles) {
        ArticleCount = articleCount;
        Articles = articles;
    }

    public ReplyPicTextMessage() {
    }
}
