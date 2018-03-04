//Author : Arunav Mallik Avi (Arm Avi)
//Department of Computer Science & Engineering(NU)

package com.teshshop.arm_avi.techshop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // WebView
    WebView webViewRender;
//    ProgressBar progressBar;
    SwipeRefreshLayout swipe;

    //This one is Connection Error URL
    private String errorConnection = "file:///android_asset/index.html";



    //Defining TechShop URL_Change Them in Your OWN Purposes

    // Home Page URL
    private String home = "http://musoft.alakaproject.com/system222/public/index",

    //Information URL
     information = "http://musoft.alakaproject.com/system222/public/info",

    //Library (Submenu)

    //library Info URL
    libararyInfo = "http://musoft.alakaproject.com/system222/public/libraryinfos",

    //Book List URL
    bookList = "http://musoft.alakaproject.com/system222/public/library" ,


    //Inventory (Submenu)

    //Instrument URL
    instruments = "http://musoft.alakaproject.com/system222/public/instrument" ,

    //Furniture URL
    furniture = "http://musoft.alakaproject.com/system222/public/furniture",

    //Booking (Submenu)

    //Busbooking URL
    busBooking = "http://musoft.alakaproject.com/system222/public/bus",

    //Room Booking URL
    roomBooking = "http://musoft.alakaproject.com/system222/public/room",

    //Buildings (Submenu)

    //CSE Building URL
    cseBuilding = "http://musoft.alakaproject.com/system222/public/cse",

    //EEE Building URL
    eeeBuilding = "http://musoft.alakaproject.com/system222/public/eee",

    //CE Building URL
    ceBuilding = "http://musoft.alakaproject.com/system222/public/ce",

    //Libary Building URL
    libraryBuilding = "http://musoft.alakaproject.com/system222/public/lb",

    //Admin Building URL
    adminBuilding = "http://musoft.alakaproject.com/system222/public/ad",

    //Login URL
    login  = "http://musoft.alakaproject.com/system222/public/login",

    //Register URL
    register = "http://musoft.alakaproject.com/system222/public/register";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#313B3D"));
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Swipe Gesture Refresh
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);

        // Defining WebView
        webViewRender = (WebView) findViewById(R.id.webViewRender);

        //Defining Progressbar
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        WebSettings webSettings = webViewRender.getSettings();

        webViewRender.setWebViewClient(new WebBasicBrowser());

        //Call all WebPage Rendering Function
        webViewRender.getSettings().setLoadsImagesAutomatically(true);
        webViewRender.getSettings().setJavaScriptEnabled(true);
        webViewRender.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webViewRender.getSettings().setPluginState(WebSettings.PluginState.ON);
        webViewRender.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webViewRender.getSettings().setBuiltInZoomControls(true);
        webViewRender.getSettings().setDisplayZoomControls(false);
        webViewRender.getSettings().setAppCacheEnabled(true);
        webViewRender.setInitialScale(0);
        webViewRender.getSettings().setLoadWithOverviewMode(true);
        webViewRender.getSettings().setUseWideViewPort(true);
        webViewRender.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webViewRender.getSettings().setDomStorageEnabled(true);

        //Default Page URL

        webViewRender.loadUrl(home);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                swipe.setRefreshing(true);
                ( new Handler()).postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        swipe.setRefreshing(false);
                        webViewRender.loadUrl(home);
                    }
                }, 2000);
            }
        });



        webViewRender.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webViewRender.loadUrl(errorConnection);

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intentTorvalds = new Intent(MainActivity.this,Torvalds.class);
            startActivity(intentTorvalds);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
           webViewRender.loadUrl(home);

        } else if (id == R.id.nav_library_info) {

//            webViewRender.loadUrl(shop);
            webViewRender.loadUrl(libararyInfo);

        } else if (id == R.id.nav_book_list) {

//            webViewRender.loadUrl(promotion);
            webViewRender.loadUrl(bookList);

        } else if (id == R.id.nav_instrument) {

//            webViewRender.loadUrl(pages);
            webViewRender.loadUrl(instruments);

        } else if (id == R.id.nav_furniture) {

//            webViewRender.loadUrl(category);
            webViewRender.loadUrl(furniture);

        }else if(id == R.id.nav_booking_bus){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(busBooking);

        }else if(id == R.id.nav_booking_room){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(roomBooking);

        }else if(id == R.id.nav_building_cse){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(cseBuilding);

        }else if(id == R.id.nav_building_eee){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(eeeBuilding);

        }else if(id == R.id.nav_building_ce){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(ceBuilding);

        }else if(id == R.id.nav_building_libary){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(libraryBuilding);

        }else if(id == R.id.nav_building_administration){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(adminBuilding);

        }else if(id == R.id.nav_login){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(login);

        }else if(id == R.id.nav_register){

//            webViewRender.loadUrl(contact);
            webViewRender.loadUrl(register);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //WebViewClient is a Class That can give Basic Browsing Ability To WebView
    private class WebBasicBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            webViewRender.loadUrl(url);
            return true;
        }

        public void onLoadResource(WebView view,String url){

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
//            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
//            progressBar.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//           webViewRender.loadUrl(errorConnection);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webViewRender.canGoBack()) {
                        webViewRender.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
