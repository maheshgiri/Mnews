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

    String newsUrls[] = new String[]{"https://static01.nyt.com/images/2017/11/29/business/29RATINGS2/29RATINGS2-1511906547527-master768.jpg"
            };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsadd);
     //   edittext_subheadline = (TextInputEditText) findViewById(R.id.edittext_subheadline);
       // edittext_headline = (TextInputEditText) findViewById(R.id.edittext_headline);

    }


    public void addNewsCallback(View view) {
        News news = new News(edittext_headline.getText().toString(), edittext_subheadline.getText().toString(), newsUrls[0]);
        NewsList.addNews(news);
        Toast.makeText(this,"News Added!",Toast.LENGTH_SHORT).show();
     }

}
