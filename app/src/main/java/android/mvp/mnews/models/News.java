package android.mvp.mnews.models;

import java.io.Serializable;

/**
 * Created by USER on 30-11-2017.
 */

public class News implements Serializable {

    String headline;
    String subheadline;
    String newsurl;

    public News(String headline, String subheadline, String newsurl) {
        this.headline = headline;
        this.subheadline = subheadline;
        this.newsurl = newsurl;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSubheadline() {
        return subheadline;
    }

    public void setSubheadline(String subheadline) {
        this.subheadline = subheadline;
    }

    public String getNewsurl() {
        return newsurl;
    }

    public void setNewsurl(String newsurl) {
        this.newsurl = newsurl;
    }
}
