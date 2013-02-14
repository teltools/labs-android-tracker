<?php
  //$user=$_GET['user'];
  //$password=$_GET['password'];
  //$name=$_GET['name'];
  //$email=$_GET['email'];
  $user=$_POST['usuario'];
  $password=$_POST['senha'];
  $name=$_POST['nome'];
  $email=$_POST['email'];

  $connection = mysql_connect('localhost','root','senhatemp');
  mysql_select_db('android',$connection);
  $sql = "insert into usuarios (usuario, senha, nome, email) values ('$user','$password', '$name', '$email')";
  
  $result = mysql_query($sql) or die ("Error:" . mysql_error());
  if($result)
		  echo "1";
   else
          echo "0";
?>