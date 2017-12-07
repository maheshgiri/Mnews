package android.mvp.mnews.adaptors;

import android.content.Context;
import android.graphics.Point;
import android.mvp.mnews.R;
import android.mvp.mnews.callbacks.Callback;
import android.mvp.mnews.models.News;
import android.mvp.mnews.models.NewsList;
import android.mvp.mnews.utils.Constansts;
import android.mvp.mnews.utils.ScreenUtils;
import android.mvp.mnews.viewholders.CentreTextViewHolder;
import android.mvp.mnews.viewholders.LeftTextViewHolder;
import android.mvp.mnews.viewholders.MainNewsViewHolder;
import android.mvp.mnews.viewholders.RightTextViewHolder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by USER on 29-11-2017.
 */

public class NewsRecyclerAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    Point point;
    Callback callback;
    int color;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mainview = null;
        RecyclerView.ViewHolder mainRecyViewHolder = null;
        context = parent.getContext();
        callback= (Callback) context;
        if (viewType == Constansts.MAIN_NEWS_VIEW_TYPE) {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_mainnews, null);
            mainRecyViewHolder = new MainNewsViewHolder(context,mainview);
        } else if (viewType == Constansts.CENTRE_NEWS_VIEW_TYPE) {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_centreviewnews, null );
            mainRecyViewHolder = new CentreTextViewHolder(context,mainview);
        } else if (viewType==Constansts.RIGHT_NEWS_VIEW_TYPE){
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_rightviewnews, null);
            mainRecyViewHolder = new RightTextViewHolder(context,mainview);
        }else
        {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_lefttext, null);
            mainRecyViewHolder = new LeftTextViewHolder(mainview,context);

        }

        return mainRecyViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        point= ScreenUtils.getScreenDimensionsInDIP(context);
        color=Constansts.getMatColor("300", context);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onViewClicked(position);
            }
        });

        News news=NewsList.newsList.get(position);
        if (holder.getItemViewType() == Constansts.MAIN_NEWS_VIEW_TYPE) {
            MainNewsViewHolder mainNewsViewHolder = (MainNewsViewHolder) holder;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(point.x,point.y);
            mainNewsViewHolder.bind(news);

        } else if (holder.getItemViewType() == Constansts.LEFT_NEWS_VIEW_TYPE && position > 0) {
            LeftTextViewHolder centreTextViewHolder = (LeftTextViewHolder) holder;
            centreTextViewHolder.bind(news);
            centreTextViewHolder.getMaincardview().setBackgroundColor(color);
        } else if (holder.getItemViewType()==Constansts.RIGHT_NEWS_VIEW_TYPE&&position>0){
            RightTextViewHolder rightTextViewHolder = (RightTextViewHolder) holder;
            rightTextViewHolder.bind(news);
            rightTextViewHolder.getMaincardview().setBackgroundColor(color);
        }else {
            CentreTextViewHolder centreTextViewHolder = (CentreTextViewHolder) holder;
            centreTextViewHolder.bind(news);
            centreTextViewHolder.getMaincardview().setBackgroundColor(color);
        }


    }

    @Override
    public int getItemCount() {
        return NewsList.newsList.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0)
            return Constansts.MAIN_NEWS_VIEW_TYPE;
        if (position==3)
            return Constansts.LEFT_NEWS_VIEW_TYPE;

        if (position==6)
            return Constansts.RIGHT_NEWS_VIEW_TYPE;

        if (position % 2 == 0 && position > 0)
            return Constansts.CENTRE_NEWS_VIEW_TYPE;

        return Constansts.CENTRE_NEWS_VIEW_TYPE;
    }

}
