package android.mvp.mnews.ui;

import android.content.Intent;
import android.mvp.mnews.R;
import android.mvp.mnews.adaptors.NewsRecyclerAdaptor;
import android.mvp.mnews.models.NewsList;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import android.mvp.mnews.callbacks.Callback;

public class MainActivity extends AppCompatActivity implements Callback, SwipeRefreshLayout.OnRefreshListener
{
   RecyclerView recyclerView;

    NewsRecyclerAdaptor newsRecyclerAdaptor;
    GridLayoutManager gridLayoutManager;
    SwipeRefreshLayout mSwipeRefreshLayout;

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
                if (position == 0||position==3||position==6) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(newsRecyclerAdaptor);
        NewsList.addNewsToList();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);
        mSwipeRefreshLayout.post(new Runnable() {

            @Override
            public void run() {

                mSwipeRefreshLayout.setRefreshing(true);

                // Fetching data from server
                loadRecyclerViewData();
            }
        });
    }

    private void loadRecyclerViewData() {
        mSwipeRefreshLayout.setRefreshing(true);
        newsRecyclerAdaptor.notifyDataSetChanged();
        mSwipeRefreshLayout.setRefreshing(false);
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

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        NewsList.removeNewsList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //NewsList.removeNewsList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.add_news:
                Intent addNews=new Intent(this,NewsAddActivity.class);
                startActivity(addNews);
        }

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

    @Override
    public void onRefresh() {
       loadRecyclerViewData();
    }
}
