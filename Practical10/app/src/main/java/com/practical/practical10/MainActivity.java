package com.practical.practical10;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Spinner spinner;
    long animationDuration =1000;//millisecond

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.spinnerAnim);
        img=findViewById(R.id.imageView1);

        getAnimationList();
    }

    private void getAnimationList(){
        List<String> listAnim=new ArrayList<>();
        listAnim.add("Select Animation");
        listAnim.add("Fade In");
        listAnim.add("Fade Out");
        listAnim.add("Rotate");
        listAnim.add("Zoom In");
        listAnim.add("Zoom Out");
        listAnim.add("Move");
        listAnim.add("Slide Up");
        listAnim.add("Slide Down");

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listAnim);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();

                switch (parent.getItemAtPosition(position).toString()){
                    case "Fade In":
                        fade_in_Animation();
                        break;
                    case "Fade Out":
                        fade_out_Animation();
                        break;
                    case "Rotate":
                        rotate_Animation();
                        break;
                    case "Zoom In":
                        zoom_in_Animation();
                        break;
                    case "Zoom Out":
                        zoom_out_Animation();
                        break;
                    case "Move":
                        move_Animation();
                        break;
                    case "Slide Up":
                        slide_up_Animation();
                        break;
                    case "Slide Down":
                        slide_down_Animation();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void fade_in_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }

    private void fade_out_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }

    private void rotate_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }

    private void zoom_in_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }

    private void zoom_out_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }

    private void move_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }

    private void slide_up_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }

    private void slide_down_Animation(){
        final Animation animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        animFadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(animation==animFadeIn){
                    Toast.makeText(getApplicationContext(),"Animation End",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        img.startAnimation(animFadeIn);
    }
}
