package com.example.wechatcutimage;

import java.io.ByteArrayOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * http://blog.csdn.net/lmj623565791/article/details/39761281
 * @author zhy
 *
 */
public class MainActivity extends Activity
{
	private ClipImageLayout mClipImageLayout;
	private Button bt_cut;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mClipImageLayout = (ClipImageLayout) findViewById(R.id.id_clipImageLayout);
		bt_cut = (Button)findViewById(R.id.bt_cut);
		bt_cut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Bitmap bitmap = mClipImageLayout.cut();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
				byte[] datas = baos.toByteArray();
				Intent intent = new Intent(MainActivity.this, ShowImageActivity.class);
				intent.putExtra("bitmap", datas);
				startActivity(intent);


				mClipImageLayout.setBitmapDrawable(R.drawable.xx);
			}
		});
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu)
//	{
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item)
//	{
//		switch (item.getItemId())
//		{
//		case R.id.id_action_clip:
//
//			break;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}
