package android.mvp.mnews;

import android.mvp.mnews.adaptors.NewsRecyclerAdaptor;
import android.mvp.mnews.utils.Constansts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsRecyclerAdaptor newsRecyclerAdaptor;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recyviewnewslist);
        gridLayoutManager=new GridLayoutManager(this,2);
        newsRecyclerAdaptor=new NewsRecyclerAdaptor();
        /*gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (newsRecyclerAdaptor.getItemViewType(position)) {
                    case Constansts.MAIN_NEWS_VIEW_TYPE:
                        return 0;
                    case Constansts.LEFT_NEWS_VIEW_TYPE:
                        return 1;
                    case Constansts.RIGHT_NEWS_VIEW_TYPE:
                        return 2;
                }
                return position;
            }
        });*/
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(newsRecyclerAdaptor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
