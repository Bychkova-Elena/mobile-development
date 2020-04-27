package com.example.cube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView your_points;
    TextView robot_points;
    TextView first_cube_points;
    TextView second_cube_points;
    Button btn;
    Random random = new Random();

    int common_your = 0;
    int common_robots = 0;
    int first_rand = 0;
    int second_rand = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        your_points = findViewById(R.id.YourCount);
        robot_points = findViewById(R.id.RobotCount);
        first_cube_points = findViewById(R.id.textYourPoints);
        second_cube_points = findViewById(R.id.textRobotPoints);
        btn = findViewById(R.id.buttonThrow);
    }
    public void onClick(View view) {
        first_rand = 1+random.nextInt(6);
        first_cube_points.setText(Integer.toString(first_rand));
        second_rand = 1+random.nextInt(6);
        second_cube_points.setText(Integer.toString(second_rand));
        while (first_rand==second_rand){
            first_rand = 1+random.nextInt(6);
            first_cube_points.setText(Integer.toString(first_rand));
            second_rand = 1+random.nextInt(6);
            second_cube_points.setText(Integer.toString(second_rand));
        }
        common_your += first_rand;
        your_points.setText(Integer.toString(common_your));
        common_robots += second_rand;
        robot_points.setText(Integer.toString(common_robots));


            if (common_robots >= 100 && common_your<100) {
                Intent i2 = new Intent(this, LooseActivity.class);
                your_points.setText("0");
                robot_points.setText("0");
                first_cube_points.setText("0");
                second_cube_points.setText("0");
                common_your = 0;
                common_robots = 0;
                first_rand = 0;
                second_rand = 0;
                startActivity(i2);
            }
        if (common_your >= 100 && common_robots<100) {
            Intent i = new Intent(this, WinActivity.class);
            your_points.setText("0");
            robot_points.setText("0");
            first_cube_points.setText("0");
            second_cube_points.setText("0");
            common_your = 0;
            common_robots = 0;
            first_rand = 0;
            second_rand = 0;
            startActivity(i);
        }
        if (common_robots >= 100 && common_your>=100) {
            Intent i3 = new Intent(this, FriendshipActivity.class);
            your_points.setText("0");
            robot_points.setText("0");
            first_cube_points.setText("0");
            second_cube_points.setText("0");
            common_your = 0;
            common_robots = 0;
            first_rand = 0;
            second_rand = 0;
            startActivity(i3);
        }
    }

}



