<?php
  //$name=$_GET['name'];
  //$time=$_GET['time'];
  $name=$_POST['nome'];
  $time=$_POST['tempo'];

  $connection = mysql_connect('localhost','root','senhatemp');
  mysql_select_db('android',$connection);
  $sql = "insert into tempos (nome, tempo) values ('$name', '$time')";
  
  $result = mysql_query($sql) or die ("Error" . mysql_error());
  if($result)
		  echo "Gravado";
   else
          echo "Erro";
?>
