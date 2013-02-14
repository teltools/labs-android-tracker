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

public class RegisterUser extends Activity {

	EditText editUser, editPassword, editName, editEmail;
	Button buttonSave;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_user);

		editUser = (EditText) findViewById(R.id.editUser);
		editPassword = (EditText) findViewById(R.id.editPassword);
		editName = (EditText) findViewById(R.id.editName);
		editEmail = (EditText) findViewById(R.id.editEmail);
		buttonSave = (Button) findViewById(R.id.buttonSave);

		buttonSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				if (editUser.getText().toString().isEmpty()
						|| editPassword.getText().toString().isEmpty()
						|| editName.getText().toString().isEmpty()
						|| editEmail.getText().toString().isEmpty())
					showMessage("Erro", "Preencha todos os campos.");
				else {
					String urlPost = "http://192.168.77.230/android/gravarUsuario.php";
					
					ArrayList<NameValuePair> postParameter = new ArrayList<NameValuePair>();
					postParameter.add(new BasicNameValuePair("usuario",
							editUser.getText().toString()));
					postParameter.add(new BasicNameValuePair("senha",
							editPassword.getText().toString()));
					postParameter.add(new BasicNameValuePair("nome", editName
							.getText().toString()));
					postParameter.add(new BasicNameValuePair("email", editEmail
							.getText().toString()));
					String returnResponse = null;
					try {
						Log.i("LOG",""+postParameter);
						returnResponse = ConnectionHttpClient.executeHttpPost(
								urlPost, postParameter);
						String response = returnResponse.toString();

						//Response
						//  1 -> usuário cadastrado com sucesso
						//  0 -> usuário não cadastrado
						
						if (response.charAt(0) == '1') {
							showMessage("Registrado", "Usuario Gravado");
						} else {
							showMessage("Erro", "Usuário não cadastrado");
						}
					} catch (Exception error) {
						showMessage("Erro", "Não foi possivel registrar"
								+ error);
					}
				}
			}
		});
	}

	public void showMessage(String Title, String Text) {
		AlertDialog.Builder message = new AlertDialog.Builder(RegisterUser.this);
		message.setTitle(Title);
		message.setMessage(Text);
		message.setNeutralButton("Ok", null);
		message.show();
	}
}
