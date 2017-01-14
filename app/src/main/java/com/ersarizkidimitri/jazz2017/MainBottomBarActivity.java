package com.ersarizkidimitri.jazz2017;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ERD on 1/12/2017.
 */

public class MainBottomBarActivity extends AppCompatActivity {
    @BindView(R.id.view_pager)AHBottomNavigationViewPager viewPager;
    @BindView(R.id.bottom_navigation)AHBottomNavigation bottomNavigation;
    @BindView(R.id.toolbar)Toolbar toolbar;

    private MainPagerAdapter2 mPagerAdapter;
    private AHBottomNavigationAdapter navigationAdapter;
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private boolean useMenuResource = true;
    private int[] tabColors;
    private RootFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();
        initUI();

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar");
        }
    }

    private void initUI() {

        if (useMenuResource) {
            tabColors = getApplicationContext().getResources().getIntArray(R.array.tab_colors);
            navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottom_navigation_menu_3);
            navigationAdapter.setupWithBottomNavigation(bottomNavigation, tabColors);

            bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
            bottomNavigation.setAccentColor(Color.parseColor("#333333"));
            bottomNavigation.setInactiveColor(Color.parseColor("#999999"));
            bottomNavigation.setForceTint(true);
            bottomNavigation.setBehaviorTranslationEnabled(false);
            bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        }

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (currentFragment == null) {
                    currentFragment = mPagerAdapter.getCurrentFragment();
                }

                if (wasSelected) {
                    currentFragment.refresh();
                    return true;
                }

                if (currentFragment != null) {
                    currentFragment.willBeHidden();
                }

                viewPager.setCurrentItem(position, false);
                currentFragment = mPagerAdapter.getCurrentFragment();
                currentFragment.willBeDisplayed();

//				if (position == 1) {
//					bottomNavigation.setNotification("", 1);
//
//					floatingActionButton.setVisibility(View.VISIBLE);
//					floatingActionButton.setAlpha(0f);
//					floatingActionButton.setScaleX(0f);
//					floatingActionButton.setScaleY(0f);
//					floatingActionButton.animate()
//							.alpha(1)
//							.scaleX(1)
//							.scaleY(1)
//							.setDuration(300)
//							.setInterpolator(new OvershootInterpolator())
//							.setListener(new Animator.AnimatorListener() {
//								@Override
//								public void onAnimationStart(Animator animation) {
//
//								}
//
//								@Override
//								public void onAnimationEnd(Animator animation) {
//									floatingActionButton.animate()
//											.setInterpolator(new LinearOutSlowInInterpolator())
//											.start();
//								}
//
//								@Override
//								public void onAnimationCancel(Animator animation) {
//
//								}
//
//								@Override
//								public void onAnimationRepeat(Animator animation) {
//
//								}
//							})
//							.start();
//
//				} else {
//					if (floatingActionButton.getVisibility() == View.VISIBLE) {
//						floatingActionButton.animate()
//								.alpha(0)
//								.scaleX(0)
//								.scaleY(0)
//								.setDuration(300)
//								.setInterpolator(new LinearOutSlowInInterpolator())
//								.setListener(new Animator.AnimatorListener() {
//									@Override
//									public void onAnimationStart(Animator animation) {
//
//									}
//
//									@Override
//									public void onAnimationEnd(Animator animation) {
//										floatingActionButton.setVisibility(View.GONE);
//									}
//
//									@Override
//									public void onAnimationCancel(Animator animation) {
//										floatingActionButton.setVisibility(View.GONE);
//									}
//
//									@Override
//									public void onAnimationRepeat(Animator animation) {
//
//									}
//								})
//								.start();
//					}
//				}

                return true;
            }
        });

        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                Log.d("DemoActivity", "BottomNavigation Position: " + y);
            }
        });

        viewPager.setOffscreenPageLimit(4);
        mPagerAdapter = new MainPagerAdapter2(getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);

        currentFragment = mPagerAdapter.getCurrentFragment();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Setting custom colors for notification
                AHNotification notification = new AHNotification.Builder()
                        .setText(":)")
                        .setBackgroundColor(ContextCompat.getColor(MainBottomBarActivity.this, R.color.color_notification_back))
                        .setTextColor(ContextCompat.getColor(MainBottomBarActivity.this, R.color.color_notification_text))
                        .build();
                bottomNavigation.setNotification(notification, 1);

            }
        }, 3000);

    }

    public void updateBottomNavigationColor(boolean isColored) {
        bottomNavigation.setColored(isColored);
    }

    public boolean isBottomNavigationColored() {
        return bottomNavigation.isColored();
    }

    public void showOrHideBottomNavigation(boolean show) {
        if (show) {
            bottomNavigation.restoreBottomNavigation(true);
        } else {
            bottomNavigation.hideBottomNavigation(true);
        }
    }

    public void updateSelectedBackgroundVisibility(boolean isVisible) {
        bottomNavigation.setSelectedBackgroundVisible(isVisible);
    }

    public int getBottomNavigationNbItems() {
        return bottomNavigation.getItemsCount();
    }

    public void confirmExit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setTitle("Exit");
        alertDialogBuilder.setMessage("Are you sure you want to exit?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                doubleBackToExitPressedOnce = false;
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doubleBackToExitPressedOnce = false;
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            confirmExit();
//            Toast.makeText(this,"Please click BACK again to exit.", Toast.LENGTH_SHORT).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce = false;
//                }
//            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }

}
