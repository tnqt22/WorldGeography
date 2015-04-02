package com.example.worldgeography;

import java.util.Random;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Quiz extends Activity {
	
	//create array to store map, flag, and button
	public Integer[] map = {R.drawable.francem, R.drawable.italym, R.drawable.egyptm, R.drawable.australiam, 
			R.drawable.japanm, R.drawable.ethiopiam, R.drawable.vietnamm, R.drawable.usam, R.drawable.mexicom, 
			R.drawable.chinam, R.drawable.russiam, R.drawable.netherlandsm};
	public static Integer[] flag = {R.drawable.francef, R.drawable.italyf, R.drawable.egyptf, R.drawable.australiaf, 
			R.drawable.japanf, R.drawable.ethiopiaf, R.drawable.vietnamf, R.drawable.usaf, R.drawable.mexicof, 
			R.drawable.chinaf, R.drawable.russiaf, R.drawable.netherlandsf};
	Integer[] name = {R.drawable.franceb, R.drawable.italyb, R.drawable.egyptb, R.drawable.australiab, 
			R.drawable.japanb, R.drawable.ethiopiab, R.drawable.vietnamb, R.drawable.usab, R.drawable.mexicob, 
			R.drawable.chinab, R.drawable.russiab, R.drawable.netherlandsb};
	
	public static int index = 0;
	ImageView pic;
	static int score = 0;
	int i = 10;
	Random rand = new Random();
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz);
		
		Button back = (Button)findViewById(R.id.btnBackMenu);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Quiz.this, MainActivity.class));
			}
		});
		
		//create a random number to assign image for flag and map
		final int r = rand.nextInt(flag.length - 1);
		
		ImageView imgmap = (ImageView)findViewById(R.id.imageMap);
		imgmap.setImageResource(map[r]);
		ImageView imgflag = (ImageView)findViewById(R.id.imageFlag);
		imgflag.setImageResource(flag[r]);
		
		//set GridView
		GridView gr = (GridView)findViewById(R.id.gridView1);
		gr.setAdapter(new ImageAdapter(this));					

		gr.setOnItemClickListener(new OnItemClickListener() {
	
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
						long arg3) {
				//update number of question answered
				Score.numQuestion++;
				if(arg2 == r)
				{
					index = arg2;
					//update score
					Score.score++;
					Toast.makeText(Quiz.this, "Correct!", Toast.LENGTH_SHORT).show();						
				}
				else
				{
					Toast.makeText(Quiz.this, "Incorrect", Toast.LENGTH_SHORT).show();
				}
				startActivity(new Intent(Quiz.this, Quiz.class));
			}
		});	
		
		
		//if 12 question have been answered, go to score class
		if(Score.numQuestion == 12)
		{
			startActivity(new Intent(Quiz.this, Score.class));
		}
		

		Button end = (Button)findViewById(R.id.btnEnd);
		end.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Quiz.this, Score.class));
			}
		});
	}

	
	public class ImageAdapter extends BaseAdapter {

		private Context context;
		public ImageAdapter(Context c) {
			// TODO Auto-generated constructor stub
			context=c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return flag.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			pic = new ImageView(context);
			pic.setImageResource(name[arg0]);
			pic.setScaleType(ImageView.ScaleType.FIT_XY);
			pic.setLayoutParams(new GridView.LayoutParams(188,200));
			return pic;
		}
		
	}
}
