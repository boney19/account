package com.example.simpleui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends Activity {

	private static final String FILE_NAME = "text.txt";
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);

		textView = (TextView) findViewById(R.id.textView1);

		String text = getIntent().getStringExtra("text");
		writeFile(text);
		textView.setText(readFile());
	}

	private void writeFile(String text) {
		try {
			text += "\n";

			FileOutputStream fos = openFileOutput(FILE_NAME,
					Context.MODE_APPEND);
			fos.write(text.getBytes());
			fos.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String readFile() {

		try {
			FileInputStream fis = openFileInput(FILE_NAME);
			byte[] buffer = new byte[1024];
			fis.read(buffer);
			fis.close();

			return new String(buffer);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}