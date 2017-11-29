package android.mvp.mnews.adaptors;

import android.content.Context;
import android.graphics.Point;
import android.mvp.mnews.R;
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

            mainRecyViewHolder = new MainNewsViewHolder(mainview);
        } else if (viewType == Constansts.LEFT_NEWS_VIEW_TYPE) {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_leftviewnews, null );
            mainRecyViewHolder = new LeftTextViewHolder(mainview);
        } else {
            mainview = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_rightviewnews, null);
            mainRecyViewHolder = new RightTextViewHolder(mainview);
        }


        return mainRecyViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setBackgroundColor(Constansts.getMatColor("100", context));
        point= ScreenUtils.getScreenDimensionsInDIP(context);

        if (holder.getItemViewType() == Constansts.MAIN_NEWS_VIEW_TYPE) {
            MainNewsViewHolder mainNewsViewHolder = (MainNewsViewHolder) holder;
           // ViewGroup.LayoutParams layoutParams =  mainNewsViewHolder.getMainCardView().getLayoutParams();
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(point.x,point.y);

            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP ,point.x, context.getResources().getDisplayMetrics());

            mainNewsViewHolder.itemView.setLayoutParams(layoutParams);

        } else if (holder.getItemViewType() == Constansts.LEFT_NEWS_VIEW_TYPE) {
            LeftTextViewHolder leftTextViewHolder = (LeftTextViewHolder) holder;
        } else {
            RightTextViewHolder rightTextViewHolder = (RightTextViewHolder) holder;
        }


    }

    @Override
    public int getItemCount() {
        return 10;
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
