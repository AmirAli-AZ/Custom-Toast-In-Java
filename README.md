# Custom-Toast-In-Sketchware

# Features
1. Set Long Or short time
2. set background color
3. set text color
4. set corner radius
5. set text size

# Class
first create MyToast.java in java manage files and add this class
```java
package com.my.newproject49;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
/*import android.widget.ImageView;*/
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.graphics.*;
import android.graphics.drawable.*;
/*
This class was created by Amir Ali on the Mon , 16 aug 2021
*/
public class MyToast {
    public static void show(Context context, String text, boolean isLong , String color , int radius , String textcolor , int textsize) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast, null);


        TextView textV = (TextView) layout.findViewById(R.id.toast);
		LinearLayout lin_toast = (LinearLayout) layout.findViewById(R.id.lin_toast);
		android.graphics.drawable.GradientDrawable ln = new android.graphics.drawable.GradientDrawable ();
		ln.setColor (Color.parseColor(color));
		ln.setCornerRadius(radius);
		lin_toast.setBackground (ln);
		lin_toast.setElevation(6);
		
		textV.setTextSize(textsize);
		textV.setText(text);
		textV.setTextColor(Color.parseColor(textcolor));
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER,0,0); 
        toast.setDuration((isLong) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
		
    }
}
```
# XML
Custom view shape
```xml
<LinearLayout
	xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:app="http://schemas.android.com/apk/res-auto"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	android:orientation="vertical">
	<LinearLayout
		android:id="@+id/lin_toast"
		android:layout_width="wrap_content"
		android:layout_height="wrap_content"
		android:layout_margin="15dp"
		android:padding="8dp"
		android:background="#FFFFFF"
		android:orientation="horizontal"
		android:layout_gravity="center_horizontal">
		<TextView
			android:id="@+id/toast"
			android:focusable="false"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"
			android:padding="8dp"
			android:text="TextView"
			android:textSize="14sp"
			android:textStyle="bold"
			android:textColor="#000000"/>
	</LinearLayout>
</LinearLayout>
```
# Usage

```java
MyToast.show(getApplicationContext(), "MyToast Sample", false , "#FFFFFF" , 19 , "#2196F3", 15);
```
 
