package com.example.slidingbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.slidingbar.Adaptor.SlidingAdaptor;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    SlidingAdaptor slidingAdaptor;
    TabLayout tabLayout;


    // Handler and Runnable for auto sliding
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable autoSlideRunnable;
    private int currentPage = 0;  // To track the current page
    private boolean isForward = true; // To track sliding direction


    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);

        slidingAdaptor = new SlidingAdaptor(
                getSupportFragmentManager(),
                getLifecycle()
        );

        slidingAdaptor.addFragment(new Fragment_1());
        slidingAdaptor.addFragment(new Fragment_2());
        slidingAdaptor.addFragment(new Fragment_3());

        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(slidingAdaptor);

        // Attach TabLayout to ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> tab.setText(""+(position+1))
        ).attach();


        // Start the auto-slide feature
        startAutoSlide();

    }

    private void startAutoSlide() {
        // Auto-slide every 3 seconds (3000 milliseconds)
        autoSlideRunnable = new Runnable() {
            @Override
            public void run() {
                if (isForward) {
                    // Going forward
                    currentPage++;
                    if (currentPage == slidingAdaptor.getItemCount()) {
                        // If it's the last page, change direction to backward
                        isForward = false;
                        currentPage--; // Step back to stay at the last page
                    }
                } else {
                    // Going backward
                    currentPage--;
                    if (currentPage < 0) {
                        // If it's the first page, change direction to forward
                        isForward = true;
                        currentPage = 1; // Step forward to stay at the first page
                    }
                }

                viewPager.setCurrentItem(currentPage, true);  // Set the next page with animation
                handler.postDelayed(this, 3000);  // Repeat the process every 3 seconds
            }
        };
        handler.postDelayed(autoSlideRunnable, 3000);  // Start the first slide after 3 seconds
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove the handler callbacks to avoid memory leaks when the activity is destroyed
        handler.removeCallbacks(autoSlideRunnable);
    }
}