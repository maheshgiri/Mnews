package android.mvp.mnews.viewholders;

import android.content.Context;
import android.mvp.mnews.R;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by USER on 29-11-2017.
 */

public class RightTextViewHolder extends RecyclerView.ViewHolder {


    ImageView imageview_mainimgnews;
    TextView textview_maintitle;
    TextView textview_subtitle;

    Context mContext;

    public RightTextViewHolder(Context context,View itemView) {
        super(itemView);
        mContext=context;
        imageview_mainimgnews=(ImageView) itemView.findViewById(R.id.image_mainnews);
        textview_maintitle=(TextView) itemView.findViewById(R.id.textview_maintitle);
        textview_subtitle=(TextView) itemView.findViewById(R.id.textview_subtitle);
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
}
