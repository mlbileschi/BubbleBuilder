package bileschi.bubblebuilder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		// Get the TableLayout
		TableLayout tl = (TableLayout) findViewById(R.id.maintable);

		int rowCount = 6;
		int colCount = rowCount;

		android.widget.TableRow.LayoutParams rowParams = new android.widget.TableRow.LayoutParams(
				LayoutParams.WRAP_CONTENT);
		rowParams.rightMargin = dpToPixel(10, this); // right-margin = 10dp
		rowParams.topMargin = dpToPixel(10, this); // top-margin = 10dp

		// Go through each item in the array
		for (int rowNum = 0; rowNum < rowCount; rowNum++) {
			// Create a TableRow and give it an ID
			TableRow tr = new TableRow(this);

			for (int colNum = 0; colNum < colCount; colNum++) {
				// Create a TextView to house the name of the province
				ImageView bubble = new ImageView(this);
				bubble.setImageBitmap(BitmapFactory.decodeResource(
						getResources(), R.drawable.outline));
				// bubble.setBackgroundColor(getResources()
				// .getColor(R.color.black));
				bubble.setLayoutParams(rowParams);
				bubble.setBackgroundResource(R.color.black);
				bubble.setOnTouchListener(getOnTouchListener(bubble));

				tr.addView(bubble);
			}

			// Add the TableRow to the TableLayout
			tl.addView(tr, new TableLayout.LayoutParams(
					LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
		}

	}

	public static int dpToPixel(int dp, Context context) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private final OnTouchListener getOnTouchListener(final ImageView v) {
		return new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {

				// new AlertDialog.Builder(MainActivity.this).setMessage(
				// arg1.toString()).show();
				v.setImageBitmap(BitmapFactory.decodeResource(
						MainActivity.this.getResources(), R.drawable.red_inside));
				return true;
			}
		};
	}
}
