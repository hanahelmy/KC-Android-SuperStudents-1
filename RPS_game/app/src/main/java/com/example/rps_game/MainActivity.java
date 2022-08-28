package com.example.rps_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView computer = findViewById(R.id.computer);
        ImageView player = findViewById(R.id.player);
        Button rock = findViewById(R.id.rock);
        Button paper = findViewById(R.id.paper);
        Button scissors = findViewById(R.id.scissors);
        Button reset = findViewById(R.id.reset);


        player.setImageResource(R.drawable.person);
        computer.setImageResource(R.drawable.computer);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setImageResource(R.drawable.person);
                computer.setImageResource(R.drawable.computer);
            }
        });


        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setImageResource(R.drawable.rockicon);
                String  message = play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setImageResource(R.drawable.papericon);
                String  message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.setImageResource(R.drawable.scissorsicon);
                String  message = play_turn("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }



    public String play_turn(String player_choice) {


        ImageView computer = findViewById(R.id.computer);
        ImageView player = findViewById(R.id.player);
        Button rock = findViewById(R.id.rock);
        Button paper = findViewById(R.id.paper);
        Button scissors = findViewById(R.id.scissors);
        Button reset = findViewById(R.id.reset);




        Random r = new Random();
        String compchoice = "";
        int comp_choice_num = r.nextInt(3) + 1;
        if (comp_choice_num == 1) {
            compchoice = "rock";
        } else if (comp_choice_num == 2) {
            compchoice = "scissors";
        } else if (comp_choice_num == 3) {
            compchoice = "paper";
        }

        if (compchoice == "rock") {
            computer.setImageResource(R.drawable.rockicon);
        } else if (compchoice == "scissors") {
            computer.setImageResource(R.drawable.scissorsicon);
        } else if (compchoice == "paper") {
            computer.setImageResource(R.drawable.papericon);
        }

        int plrscore= 0;
        int cmpscore = 0;

        if (compchoice == player_choice) {
            return "Tie";
        }

        else if (player_choice == "rock" && compchoice == "scissors") {
            plrscore++;
            return "1 point for you";
        }

        else if (player_choice == "rock" && compchoice == "paper") {
            cmpscore++;
            return "1 point for your opponent";
        }

        else if (player_choice == "scissors" && compchoice == "rock") {
            cmpscore++;
            return "1 point for your opponent";
        }

        else if (player_choice == "scissors" && compchoice == "paper") {
            plrscore++;
            return "1 point for you";
        }

        else if (player_choice == "paper" && compchoice == "scissors") {
            cmpscore++;
            return "1 point for your opponent";
        }

        else if (player_choice == "paper" && compchoice == "rock") {
            plrscore++;
            return "1 point for you";
        } else return "btates";




    }




}