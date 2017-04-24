
<?php
/*
How to Call this Script ? = locate this script to C:/xamp/htdocs/ as loginval.php 
and then in android give url as "your_pc_ip_address/loginval.php".
you have to provide JSONObject with uname,pswd(a post request)

*/



$data = json_decode(file_get_contents("php://input"));
 
$con=new mysqli("localhost","root","","your_database_name");
$usrname = mysqli_real_escape_string($con,$data->uname);// your jsonObject values 
$upswd = mysqli_real_escape_string($con,$data->pswd);
 
	$data = array();
    $qry = 'select uname from table_name where uname = "' . $usrname . '" AND pswd = "' . $upswd . '"';
     $qry_res = mysqli_query($con,$qry);
	 
	 
   if ($qry_res) {
		
        if(mysqli_num_rows($qry_res) > 0){
			while($row = mysqli_fetch_assoc($qry_res)){// if there are users with same username and password
				$data[] = $row;
			}
		}
		else {
			$data[] = mysqli_fetch_assoc($qry_res);
		}
        echo json_encode($data);
        // you will get username here if user is valid in json object
    } else {
        $arr = array('msg' => "", 'error' => 'No record found !');
        $jsn = json_encode($arr); // else you will get error message 
        print_r($jsn);
	}
?>