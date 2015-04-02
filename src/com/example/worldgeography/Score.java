package com.example.worldgeography;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Score extends Activity{
	
	static int score;
	static int numQuestion = 0;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
		
		Button menu = (Button)findViewById(R.id.btnBacktoQuiz);
		menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				score = 0;
				numQuestion = 0;
				startActivity(new Intent(Score.this, Quiz.class));
			}
		});
		
		//set text based on the score
		final TextView message = (TextView)findViewById(R.id.endMessage);
		if(score >= 10) {
			message.setText("Congratulation! \nYou have mastered the world geography quiz \nYou score is " + score);
		}
		else if(score > 5) {
			message.setText("Good Job!\nYou score is " + score);
		}
		else {
			message.setText("You score is " + score + "\nYou can do better next time :)");
		}
		message.startAnimation(AnimationUtils.loadAnimation(this, R.anim.myanimation));
		
	}

}
