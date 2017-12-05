package android.mvp.mnews;

import android.content.Intent;
import android.mvp.mnews.adaptors.NewsRecyclerAdaptor;
import android.mvp.mnews.models.News;
import android.mvp.mnews.models.NewsList;
import android.mvp.mnews.utils.Constansts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;


import butterknife.Bind;
import butterknife.ButterKnife;
import android.mvp.mnews.callbacks.Callback;

public class MainActivity extends AppCompatActivity implements Callback
{
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
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
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
    protected void onResume() {
        super.onResume();
        NewsList.addNewsToList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        NewsList.removeNewsList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onViewClicked(int position) {

        startTargetActivity();

    }

    private  void startTargetActivity(){
        Intent intent=new Intent(this,TargetpageActivity.class);
        startActivity(intent);
    }

}
