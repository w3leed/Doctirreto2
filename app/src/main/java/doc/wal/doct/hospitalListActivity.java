package doc.wal.doct;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class hospitalListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);

        getSupportFragmentManager().beginTransaction().replace(R.id.container1, new hospitalListFragment()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }
}
