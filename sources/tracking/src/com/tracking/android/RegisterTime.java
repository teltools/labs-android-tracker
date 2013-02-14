package com.tracking.android;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tracking.R;

public class RegisterTime extends Activity {

	EditText editName, editTime;
	Button btTimeSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_time);

		editName = (EditText) findViewById(R.id.editName);
		editTime = (EditText) findViewById(R.id.editTime);
		btTimeSave = (Button) findViewById(R.id.btTimeSave);

		btTimeSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (editName.getText().toString().isEmpty()
						|| editTime.getText().toString().isEmpty())
					showMessage("Erro", "Preencha todos os campos.");
				else {
					String urlPost = "http://192.168.77.230/android/gravarTempo.php";

					// Get parameter from user
					Intent i = getIntent();
					String id_user = i.getIntExtra("id_user", 0) + "";

					// TODO: change PHP

					ArrayList<NameValuePair> postParameter = new ArrayList<NameValuePair>();
					postParameter
							.add(new BasicNameValuePair("id_user", id_user));
					postParameter.add(new BasicNameValuePair("nome", editName
							.getText().toString()));
					postParameter.add(new BasicNameValuePair("tempo", editTime
							.getText().toString()));
					String returnResponse = null;
					try {
						returnResponse = ConnectionHttpClient.executeHttpPost(
								urlPost, postParameter);
						String response = returnResponse.toString();

						// Response
						// 1 -> tracked cadastrado
						// 0 -> tracked não cadastrado
						// -1 -> tracked não é usuário
						int id = Integer.parseInt(response);
						Log.i("LOG", ""+id);
						if (id == 0) {
							showMessage("Registrado", "Tracked Gravado");
						} else if (id == -2) {
							showMessage("Registrado", "Tracked não cadastrado como usuário.");
						} else {
							showMessage("Erro", "Erro: Tracked não cadastrado.");
						}
					} catch (Exception error) {
						showMessage("Erro", "Não foi possivel cadastrar"
								+ error);
					}
				}
			}
		});
	}

	public void showMessage(String Title, String Text) {
		AlertDialog.Builder message = new AlertDialog.Builder(RegisterTime.this);
		message.setTitle(Title);
		message.setMessage(Text);
		message.setNeutralButton("Ok", null);
		message.show();
	}
}
