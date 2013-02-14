<?php
  //$user=$_GET['usuario'];
  //$password=$_GET['senha'];
  $user=$_POST['usuario'];
  $password=$_POST['senha'];

  $connection = mysql_connect('localhost','root','senhatemp');
  mysql_select_db('android',$connection);
  $sql="select * from usuarios where usuario='$user';";
  $result = mysql_query($sql) or die ("Error:" . mysql_error());
  
	if (mysql_num_rows($result) > 0){
  		$sql2="select id from usuarios where usuario='$user' and senha ='$password';";
  		$result2 = mysql_query($sql2) or die ("Error:" . mysql_error());

		if (mysql_num_rows($result2) > 0){
			//Usuário Encontrado
			echo mysql_fetch_array($result2);
		}
  		else{
      		//Senha inválida
			echo -1;
		}
	}
	else{
	//Usuario Não Encontrado
	echo 0;
	}
?>