package com.eliteams.quick4j.web.model.weixin.message;

import java.util.List;

/**
 * Created by hccl on 2017/11/16.
 */
public class NewsMessage extends BaseMessage {

    private int ArticleCount;

    private List<Article> Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
