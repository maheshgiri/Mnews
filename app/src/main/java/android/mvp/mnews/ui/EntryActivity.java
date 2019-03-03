package android.mvp.mnews.ui;

import android.mvp.mnews.R;
import android.mvp.mnews.fragments.MasterFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EntryActivity extends AppCompatActivity {

    @Bind(R.id.listview)
    private RecyclerView entrylist;
    private Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

    }


    public void addNewsCallback(View view) {
        MasterFragment masterFragment=new MasterFragment();
        masterFragment.show(getSupportFragmentManager(),"MASTRER");
    }
}
