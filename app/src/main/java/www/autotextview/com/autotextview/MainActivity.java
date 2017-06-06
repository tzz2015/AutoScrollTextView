package www.autotextview.com.autotextview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import www.autotextview.com.autotextview.View.AutoScrollTextView;

public class MainActivity extends Activity {



    private AutoScrollTextView verticalScrollTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {


        verticalScrollTV = (AutoScrollTextView) findViewById(R.id.textview_auto_roll);

        final List<String> list=new ArrayList<>();
        list.add("王者风范");
        list.add("狭路相逢勇者胜");
        list.add("别无出路");
        verticalScrollTV.setText(list.get(0));
        verticalScrollTV.setList(list);
        verticalScrollTV.startScroll();
        verticalScrollTV.setClickLisener(new AutoScrollTextView.ItemClickLisener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getApplicationContext(),list.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        verticalScrollTV.stopScroll();
    }
}
