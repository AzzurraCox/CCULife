package org.zankio.cculife.ui.map;

import android.os.Bundle;

import org.zankio.cculife.R;
import org.zankio.cculife.ui.base.BaseActivity;

public class MapActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
