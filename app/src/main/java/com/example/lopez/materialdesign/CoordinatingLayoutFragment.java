package com.example.lopez.materialdesign;

/**
 * Created by Administrator on 7/9/2015.
 */
public class CoordinatingLayoutFragment extends android.support.v4.app.Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.coordinatinglayout,container,false);

        CoordinatingLayout coor = (CoordinatingLayout) v.findViewById(R.id.main_content);
        DrawerLayout drawerLayout = (DrawerLayout) v.findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) v.findViewById(R.id.toolbar);
        v.setSupportActionBar(toolbar);

        TabLayout tablayout = (TabLayout) v.findViewById(R.id.tabs);
        tablayout.addTab(tablayout.newTab().setText("Tab1"));
        tablayout.addTab(tablayout.newTab().setText("Tab2"));
        tablayout.addTab(tablayout.newTab().setText("Tab3"));



        NavigationView navigationView = (NavigationView) v.findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment
                    case R.id.drawer_item_1: {
                        ToolBarFragment fragment = new ToolBarFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content, fragment);
                        fragmentTransaction.commit();

                    }

                    case R.id.drawer_item_2:
                    {
                        FabFragment fragment = new FabFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content, fragment);
                        fragmentTransaction.commit();
                    }

                    case R.id.drawer_item_3:
                    {
                        FabFragment fragment = new FabFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content, fragment);
                        fragmentTransaction.commit();
                    }
                    case R.id.drawer_item_4:
                    {

                    }
                    case R.id.drawer_item_5:
                    {
                        CollapsingLayout fragment = new CollapsingLayout();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.content, fragment);
                        fragmentTransaction.commit();

                    }

                }
                return true;
            }

        });


        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar , R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
                //invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        drawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FloatingActionButton fab = (FloatingActionButton)v.findViewById(R.id.fab);

        final View.OnClickListener clickListener = new View.OnClickListener() {
            public void onClick(View v) {

            }
        };
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,R.string.snackbar,Snackbar.LENGTH_LONG).setAction(R.string.undo, clickListener).show();
            }
        });

        return v;
    }
        }


