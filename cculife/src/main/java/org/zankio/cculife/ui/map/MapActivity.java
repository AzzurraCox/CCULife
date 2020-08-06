package org.zankio.cculife.ui.map;

import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;

import org.zankio.cculife.R;
import org.zankio.cculife.ui.base.BaseActivity;

public class MapActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PhotoView mImageView = findViewById(R.id.imageView2);
        mImageView.setMaximumScale(8);
        mImageView.setMediumScale(4);
        mImageView.setMinimumScale(1);



    }
}
