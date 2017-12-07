package android.mvp.mnews.ui;

import android.mvp.mnews.R;
import android.mvp.mnews.models.News;
import android.mvp.mnews.models.NewsList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by USER on 07-12-2017.
 */

public class NewsAddActivity extends AppCompatActivity {

    TextInputEditText edittext_headline, edittext_subheadline;

    String newsUrls[] = new String[]{"http://www.thehindu.com/life-and-style/food/robots-serve-food-in-style-at-this-first-of-its-kind-restaurant/article21280115.ece"
            , "http://www.thehindu.com/sport/cricket/england-tour-of-australia-australia-vs-england-second-ashes-test-match-in-adelaide/article21287894.ece"
            , "http://www.thehindu.com/news/national/new-notes-not-fit-for-visually-impaired-hc/article21284542.ece"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsadd);
        edittext_subheadline = (TextInputEditText) findViewById(R.id.edittext_subheadline);
        edittext_headline = (TextInputEditText) findViewById(R.id.edittext_headline);

    }


    public void addNewsCallback(View view) {
        News news = new News(edittext_headline.getText().toString(), edittext_subheadline.getText().toString(), newsUrls[0]);
        NewsList.addNews(news);
        Toast.makeText(this,"News Added!",Toast.LENGTH_SHORT).show();
     }

}
