package com.toastkit;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
//import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.graphics.*;
import android.graphics.drawable.*;
/*
This class was created by Amir Ali on the Mon 16 aug 2021
*/
public class ToastKit {
	// Custom Toast
    public static void showCustomToast(Context context, String text, boolean isLong , String color , int radius , String textcolor , int textsize , int gravity) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast, null);


        TextView textV = (TextView) layout.findViewById(R.id.toast);
		LinearLayout lin_toast = (LinearLayout) layout.findViewById(R.id.lin_toast);
		android.graphics.drawable.GradientDrawable ln = new android.graphics.drawable.GradientDrawable();
		ln.setColor (Color.parseColor(color));
		ln.setCornerRadius(radius);
		lin_toast.setBackground (ln);
		lin_toast.setElevation(6);
		
		textV.setTextSize(textsize);
		textV.setText(text);
		textV.setTextColor(Color.parseColor(textcolor));
        Toast toast = new Toast(context);
        switch(gravity){
		  case 1:
		   toast.setGravity(Gravity.BOTTOM,0,100);
		   break;
		  case 2:
		   toast.setGravity(Gravity.TOP,0,0);
		   break;
		  case 3:
		   toast.setGravity(Gravity.CENTER,0,0);
		   break;
		  default:
		   toast.setGravity(Gravity.BOTTOM,0,100);
		   break;
		}
        toast.setDuration((isLong) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
	// Normal Toast
	public static void showNormalToast(Context context, String text, int gravity, boolean isLong) {	
	  //Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
	  int duration = (isLong) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT;
	  
	  Toast toast = Toast.makeText(context, text, duration);
	  // gravity
	  switch(gravity){
		 case 1:
		    toast.setGravity(Gravity.CENTER, 0, 0);
		 break;
		 case 2:
		    toast.setGravity(Gravity.TOP, 0, 0);
		 break;
		 case 3:
		    toast.setGravity(Gravity.BOTTOM, 0, 100);
		 break;
		 default :
		     toast.setGravity(Gravity.BOTTOM, 0, 100);
		  break;
	  }
	  toast.show();
	}
}
