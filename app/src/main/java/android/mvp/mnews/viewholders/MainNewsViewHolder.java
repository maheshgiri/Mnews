package android.mvp.mnews.viewholders;

import android.mvp.mnews.R;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by USER on 29-11-2017.
 */

public class MainNewsViewHolder extends RecyclerView.ViewHolder {
    CardView mainCardView;

    public MainNewsViewHolder(View itemView) {
        super(itemView);
        mainCardView=itemView.findViewById(R.id.maincardview);
    }

    public CardView getMainCardView() {
        return mainCardView;
    }
}
