package com.knight7.knightbrowser;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ViewClient extends WebViewClient implements OnClickListener{
	

@Override
public boolean shouldOverrideUrlLoading(WebView v, String url) {
	v.loadUrl(url);
	return super.shouldOverrideUrlLoading(v, url);
}

@Override
public void onClick(View arg0) {
	Context context = null;
	// TODO Auto-generated method stub
	Toast.makeText(context, "Loading...", Toast.LENGTH_LONG).show();
}
}
