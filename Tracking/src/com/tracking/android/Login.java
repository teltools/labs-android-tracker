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
import android.widget.Toast;

import com.tracking.R;

public class Login extends Activity {

	EditText editTextUser, editTextPassword;
	Button btAcess, btRegistrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		editTextUser = (EditText) findViewById(R.id.editUser);
		editTextPassword = (EditText) findViewById(R.id.editPassword);
		btAcess = (Button) findViewById(R.id.btAcess);
		btRegistrar = (Button) findViewById(R.id.btRegister);
		editTextUser.setFocusable(true);

		btAcess.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(editTextPassword.getText().toString().isEmpty() || editTextUser.getText().toString().isEmpty()){
					showMessage("Login", "Preencha todos os campos.");
				}
				
				else {
				String urlPost = "http://192.168.77.230/android/login.php";

				ArrayList<NameValuePair> postParameter = new ArrayList<NameValuePair>();
				postParameter.add(new BasicNameValuePair("usuario",
						editTextUser.getText().toString()));
				postParameter.add(new BasicNameValuePair("senha",
						editTextPassword.getText().toString()));

				String returnResponse = null;
				try {
					returnResponse = ConnectionHttpClient.executeHttpPost(
							urlPost, postParameter);

					String response = returnResponse.toString();

					// Response
					// usuário encontrado retorna o ID
					// -1 = senha inválida
					//  0 = usuário não encontrado

					int id = Integer.parseInt(response);
					if (id!=0 && id!=-1) {
						Intent i = new Intent();
						i.setAction(".android.Menu");
						i.putExtra("id_user", id);
						startActivity(i);
					} else if (id == -1) {
						showMessage("Login", "Senha inválida.");
					} else {
						showMessage("Login", "Usuário não encontrado.");
					}
				} catch (Exception error) {
					Toast.makeText(Login.this, "Erro:" + error,
							Toast.LENGTH_LONG).show();
				}
			}
			}
		});

		// Button para registro
		btRegistrar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent menu = new Intent();
				menu.setAction(".android.RegisterUser");
				startActivity(menu);
			}

		});

	}
	
	public void onRestart(){
		super.onRestart();
		editTextUser.setText("");
		editTextPassword.setText("");
		
	}

	public void showMessage(String Title, String Text) {
		AlertDialog.Builder message = new AlertDialog.Builder(Login.this);
		message.setTitle(Title);
		message.setMessage(Text);
		message.setNeutralButton("Ok", null);
		message.show();
	}
}
