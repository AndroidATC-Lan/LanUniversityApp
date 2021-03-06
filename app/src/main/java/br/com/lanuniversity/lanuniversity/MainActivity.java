package br.com.lanuniversity.lanuniversity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MainFragment.OnFragmentInteractionListener,
        SobreFragment.OnFragmentInteractionListener,
        CursosFragment.OnFragmentInteractionListener,
        InstrutoresFragment.OnFragmentInteractionListener,
        ComoChegarFragment.OnFragmentInteractionListener {

    static Fragment paginaAtual = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new MainFragment();

        if (paginaAtual != null)
        {
            fragment = paginaAtual;
        }

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
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
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;

        switch(id){
            case R.id.nav_sobre:
                fragment = new SobreFragment();
                break;
            case R.id.nav_cursos:
                fragment = new CursosFragment();
                break;
            case R.id.nav_instrutores:
                fragment = new InstrutoresFragment();
                break;
            case R.id.nav_como_chegar:
                fragment = new ComoChegarFragment();
                break;
            case R.id.nav_idioma_portugues:
                configurarIdioma("pt");
                break;
            case R.id.nav_idioma_ingles:
                configurarIdioma("en");
                break;
            case R.id.nav_idioma_espanhol:
                configurarIdioma("es");
                break;
        }

        if (fragment != null) {
            paginaAtual = fragment;
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    private void configurarIdioma(String pstrIdioma){

        final Resources lresResource = this.getResources();
        final Configuration lcnfConfig = lresResource.getConfiguration();
        if (pstrIdioma == null || pstrIdioma.length() == 0)
        {
            lcnfConfig.locale = Locale.getDefault();
        }
        else
        {
            lcnfConfig.locale = new Locale(pstrIdioma);
            Locale.setDefault(new Locale(pstrIdioma));
        }

        lresResource.updateConfiguration(lcnfConfig, lresResource.getDisplayMetrics());
        recreate();

    }
}
