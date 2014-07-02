package com.culebracut.blogreader;

import com.foo.blogreader.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class BlogWebView2Activity extends ActionBarActivity {

	public static final String TAG = BlogWebView2Activity.class.getSimpleName();
	protected String mUrl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blog_web_view2);
		
		Intent intent = getIntent();
		Uri blogUriData = intent.getData();
		//String blogUri = blogUriData.toString();
		mUrl = blogUriData.toString();
		Log.i(TAG, "Target URI: " + mUrl);
		
		WebView webView = (WebView)findViewById(R.id.webView1);
		webView.loadUrl(mUrl.toString());

		/*if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blog_web_view2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		/*int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}*/
		
		int itemId = item.getItemId();
		if (itemId == R.id.action_share){
			sharePost();
		}
		return super.onOptionsItemSelected(item);
	}
	
	
	private void sharePost() {
		
		Intent shareIntent = new Intent (Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_TEXT, mUrl);
		startActivity(Intent.createChooser(shareIntent, getString(R.string.share_chooser_title)));
		
		
	}


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_blog_web_view2,
					container, false);
			return rootView;
		}
	}

}
