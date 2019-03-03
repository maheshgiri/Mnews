package android.mvp.mnews.adaptors;

import android.mvp.mnews.R;
import android.mvp.mnews.models.Master;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MasterListAdaptor extends RecyclerView.Adapter<MasterListAdaptor.MasterViewHolder> {

    private List<Master> masters=new ArrayList<>();

    @Override
    public MasterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MasterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_master,parent,false));
    }

    @Override
    public void onBindViewHolder(MasterViewHolder holder, int position) {
        holder.url.setText(""+masters.get(position).getUrl());
        holder.headline.setText(""+masters.get(position).getTitle());
        holder.desc.setText(""+masters.get(position).getDescription());
        holder.expiry.setText(""+masters.get(position).getExpirydate());
    }


    @Override
    public int getItemCount() {
        return masters.size();
    }


    static class MasterViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.headline)
        private TextView headline;
        @Bind(R.id.url)
        private TextView url;
        @Bind(R.id.desc)
        private TextView desc;
        @Bind(R.id.expiry)
        private TextView expiry;


        public MasterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }

        public TextView getHeadline() {
            return headline;
        }

        public TextView getUrl() {
            return url;
        }

        public TextView getDesc() {
            return desc;
        }

        public TextView getExpiry() {
            return expiry;
        }
    }

}
