package com.example.rathana.navigationdrawer;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        setTitle("");
        //create nav drawer button
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navView);

        //set item event
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                item.setChecked(true);
                drawerLayout.closeDrawers();

                //event each item
                Fragment fragment=null;
                switch (item.getItemId()){
                    case  R.id.home:
                        fragment=HomeFragment.newInstance();
                        break;
                    case  R.id.share:
                        fragment=ShareFragment.newInstance();
                        break;
                    case  R.id.favorite:
                        fragment=FavoriteFragment.newInstance();
                        break;
                    case  R.id.setting:
                        fragment=SettingFragment.newInstance();
                        break;
                    case  R.id.account:
                        fragment=AccountFragment.newInstance();
                        break;
                        default: fragment=HomeFragment.newInstance();break;
                }

                FragmentTransaction t=getSupportFragmentManager().beginTransaction();
                t.replace(R.id.container,fragment);
                t.commit();

                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
