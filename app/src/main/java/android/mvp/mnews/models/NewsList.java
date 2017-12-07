package android.mvp.mnews.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 30-11-2017.
 */

public class NewsList {

    public static List<News> newsList=new ArrayList<>();


    public static void addNewsToList(){
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));
        newsList.add(new News("NBC Receives at Least 2 New Complaints About Matt Lauer\n","The fast-moving national reckoning over sexual harassment in the workplace toppled another television news star on Wednesday when NBC fired Matt Lauer, the co-host of its most profitable franchise",
                "https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"));

    }



    public static void removeNewsList(){
        newsList=new ArrayList<>();
    }


    public static void addNews(News news){
        newsList.add(0,news);
    }


}
