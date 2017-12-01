package android.mvp.mnews.viewholders;

import android.content.Context;
import android.mvp.mnews.R;
import android.mvp.mnews.models.News;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by USER on 29-11-2017.
 */

public class MainNewsViewHolder extends RecyclerView.ViewHolder {
    CardView mainCardView;
    ImageView imageview_mainimgnews;
    TextView textview_maintitle;
    TextView textview_subtitle;
    Context mContext;

    public MainNewsViewHolder(Context context,View itemView) {
        super(itemView);
        mContext=context;
        mainCardView=(CardView) itemView.findViewById(R.id.maincardview);
        imageview_mainimgnews=(ImageView) itemView.findViewById(R.id.imageview_mainimgnews);
        textview_maintitle=(TextView) itemView.findViewById(R.id.textview_maintitle);
        textview_subtitle=(TextView) itemView.findViewById(R.id.textview_subtitle);
    }

    public CardView getMainCardView() {
        return mainCardView;
    }


    public ImageView getImageview_mainimgnews() {
        return imageview_mainimgnews;
    }

    public TextView getTextview_maintitle() {
        return textview_maintitle;
    }

    public TextView getTextview_subtitle() {
        return textview_subtitle;
    }
    public void bind(News news){
        Glide.with(mContext).load(news.getNewsurl()).into(imageview_mainimgnews);
        textview_maintitle.setText(news.getHeadline());
        textview_subtitle.setText(news.getSubheadline());
    }
}
