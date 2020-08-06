package org.zankio.cculife.ui.map;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import org.zankio.cculife.R;
import org.zankio.cculife.ui.base.BaseActivity;

public class MapActivity extends BaseActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mImageView = findViewById(R.id.imageView2);

        mImageView.setOnClickListener(view -> {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(MapActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_custom_layout, null);
            PhotoView photoView = mView.findViewById(R.id.imageView3);
            photoView.setImageResource(R.drawable.ccu_map);
            mBuilder.setView(mView);
            AlertDialog mDialog = mBuilder.create();
            mDialog.show();
        });

    }
}
