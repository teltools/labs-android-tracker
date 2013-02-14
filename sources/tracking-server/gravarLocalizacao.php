<?php
  //$latitude=$_GET['latitude'];
  //$longitude=$_GET['longitude'];
  $id=$_POST['id'];
  $latitude=$_POST['latitude'];
  $longitude=$_POST['longitude'];

  $connection = mysql_connect('localhost','root','senhatemp');
  mysql_select_db('android',$connection);
  $sql = "insert into localizacoes (id, latitude, longitude) values ('$id','$latitude','$longitude')";
  
  $result = mysql_query($sql) or die ("Error" . mysql_error());
  if($result)
		  echo "Gravado";
   else
          echo "Erro";
?>