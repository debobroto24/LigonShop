package activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ligonshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import fragments.CartFragment;
import fragments.HomeFragment;
import fragments.ProfileFragment;
import fragments.StoreFragment;
import fragments.favoriteFragment;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavContainer);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if(id == R.id.homeItem){
                    loadFragment(new HomeFragment(),true);
//                    switchFragment(new HomeFragment());
                }else if(id == R.id.favItem){
                    loadFragment(new favoriteFragment(),false);
//                    switchFragment(new favoriteFragment());
                }
                else if(id == R.id.storeItem){
                    loadFragment(new StoreFragment(),false);
//                    switchFragment(new StoreFragment());
                }
                else if(id == R.id.cartItem){
                    loadFragment(new CartFragment(),false);
//                    switchFragment(new CartFragment());
                }
                else{
                    loadFragment(new ProfileFragment(),false);
//                    switchFragment(new ProfileFragment());
                }

                return true;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.homeItem);
    }

    public void loadFragment(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
//        if(flag){
//            ft.add(R.id.homeFrameContainer, fragment);
//        }else {
//            ft.replace(R.id.homeFrameContainer, fragment);
//        }
        ft.replace(R.id.homeFrameContainer, fragment);

        ft.commit();


    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.homeFrameContainer, fragment)
                .commit();
    }
}