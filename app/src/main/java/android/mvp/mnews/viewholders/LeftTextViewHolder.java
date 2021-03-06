package android.mvp.mnews.viewholders;

import android.content.Context;
import android.mvp.mnews.R;
import android.mvp.mnews.models.News;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by maheshgiri on 07/12/17.
 */

public class LeftTextViewHolder extends RecyclerView.ViewHolder {
    ImageView imageview_mainimgnews;
    TextView textview_maintitle;
    TextView textview_subtitle;

    Context mContext;
    LinearLayout maincardview;
    public LeftTextViewHolder(View itemView,Context context) {
        super(itemView);
        mContext=context;
        imageview_mainimgnews=(ImageView) itemView.findViewById(R.id.image_mainnews);
        textview_maintitle=(TextView) itemView.findViewById(R.id.textview_maintitle);
        textview_subtitle=(TextView) itemView.findViewById(R.id.textview_subtitle);
        maincardview=(LinearLayout) itemView.findViewById(R.id.maincardview);

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

    public LinearLayout getMaincardview() {
        return maincardview;
    }

}
