package android.mvp.mnews.adaptors;

import android.content.Context;
import android.graphics.Point;
import android.mvp.mnews.R;
import android.mvp.mnews.models.News;
import android.mvp.mnews.models.NewsList;
import android.mvp.mnews.utils.Constansts;
import android.mvp.mnews.utils.ScreenUtils;
import android.mvp.mnews.viewholders.LeftTextViewHolder;
import android.mvp.mnews.viewholders.MainNewsViewHolder;
import android.mvp.mnews.viewholders.RightTextViewHolder;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import butterknife.ButterKnife;

/**
 * Created by USER on 29-11-2017.
 */

public class NewsRecyclerAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    Point point;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View mainview = null;
        RecyclerView.ViewHolder mainRecyViewHolder = null;
        context = parent.getContext();
        if (viewType == Constansts.MAIN_NEWS_VIEW_TYPE) {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_mainnews, null);
            mainRecyViewHolder = new MainNewsViewHolder(context,mainview);
        } else if (viewType == Constansts.LEFT_NEWS_VIEW_TYPE) {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_leftviewnews, null );
            mainRecyViewHolder = new LeftTextViewHolder(context,mainview);
        } else {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_rightviewnews, null);
            mainRecyViewHolder = new RightTextViewHolder(context,mainview);
        }


        return mainRecyViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setBackgroundColor(Constansts.getMatColor("100", context));
        point= ScreenUtils.getScreenDimensionsInDIP(context);

        News news=NewsList.newsList.get(position);
        if (holder.getItemViewType() == Constansts.MAIN_NEWS_VIEW_TYPE) {
            MainNewsViewHolder mainNewsViewHolder = (MainNewsViewHolder) holder;
           // ViewGroup.LayoutParams layoutParams =  mainNewsViewHolder.getMainCardView().getLayoutParams();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(point.x,point.y);
            Glide.with(context).load(news.getNewsurl()).into(mainNewsViewHolder.getImageview_mainimgnews());
            mainNewsViewHolder.getTextview_maintitle().setText(news.getHeadline());
            mainNewsViewHolder.getTextview_subtitle().setText(news.getSubheadline());
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP ,point.x, context.getResources().getDisplayMetrics());

            mainNewsViewHolder.itemView.setLayoutParams(layoutParams);

        } else if (holder.getItemViewType() == Constansts.LEFT_NEWS_VIEW_TYPE) {
            LeftTextViewHolder leftTextViewHolder = (LeftTextViewHolder) holder;
            Glide.with(context).load(news.getNewsurl()).into(leftTextViewHolder.getImageview_mainimgnews());
            leftTextViewHolder.getTextview_maintitle().setText(news.getHeadline());
            leftTextViewHolder.getTextview_subtitle().setText(news.getSubheadline());
        } else {
            RightTextViewHolder rightTextViewHolder = (RightTextViewHolder) holder;
            Glide.with(context).load(news.getNewsurl()).into(rightTextViewHolder.getImageview_mainimgnews());
            rightTextViewHolder.getTextview_maintitle().setText(news.getHeadline());
            rightTextViewHolder.getTextview_subtitle().setText(news.getSubheadline());
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

        if (position % 2 == 0 && position > 0)
            return Constansts.LEFT_NEWS_VIEW_TYPE;

        return Constansts.RIGHT_NEWS_VIEW_TYPE;
    }

}
