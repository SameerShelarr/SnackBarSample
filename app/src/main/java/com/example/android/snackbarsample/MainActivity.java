package com.example.android.snackbarsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //You need coordinator layout for swipe to dismiss functionality
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        Button showSnackButton = findViewById(R.id.showSnackBarButton);

        showSnackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorLayout,"This is a SnackBar example!",Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //You must declare a separate SnackBar variable to have dismiss button on it
                                final Snackbar snackBarWithDismiss = Snackbar.make(coordinatorLayout,"Action button pressed!",Snackbar.LENGTH_LONG);
                                        snackBarWithDismiss.setTextColor(Color.YELLOW)
                                        .setAction("Dismiss", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                snackBarWithDismiss.dismiss();
                                            }
                                        })
                                        .setActionTextColor(Color.RED)
                                        .show();
                            }
                        })
                        .setTextColor(Color.CYAN)
                        .setActionTextColor(Color.GREEN)
                        .show();
            }
        });
    }
}