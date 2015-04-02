package com.example.worldgeography;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class FactPageAnimation extends View{
	
	//create an array to store fact page for each country
	Integer[] factArray = {R.drawable.france, R.drawable.italy, R.drawable.egypt, R.drawable.australia, 
			R.drawable.japan, R.drawable.ethiopia, R.drawable.vietnam, R.drawable.usa, R.drawable.mexico, 
			R.drawable.china, R.drawable.russia, R.drawable.netherlands};
	
	Bitmap earth;
	Bitmap bg;
	float changeX;
	float changeY;

	public FactPageAnimation(Context context, AttributeSet attrs) {
		super(context);
		//set animation image
		earth = BitmapFactory.decodeResource(getResources(), R.drawable.earths);
		//set fact image from the array to match with the selected country from Normal class
		bg = BitmapFactory.decodeResource(getResources(), factArray[Normal.index]);
		changeX = 0;
		changeY = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		//draw bg(fact page) on canvas
		canvas.drawBitmap(bg, 0, 0, null);		
		//draw animation
		canvas.drawBitmap(earth, changeX, changeY, null);
		if(changeY < canvas.getHeight() && changeX < canvas.getWidth()) {			
			changeY += 5;
			changeX +=10;
		}
		else if(changeY < canvas.getHeight()) {
			changeY += 5;
			changeX = 0;
		}
		else {
			changeY = 0;
			changeX = 0;
		}
		invalidate();
	}

}
