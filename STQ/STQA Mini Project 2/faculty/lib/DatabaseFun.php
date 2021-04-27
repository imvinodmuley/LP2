<?php
	
	date_default_timezone_set("Asia/kolkata");
	
	class database_functions{
		private $con;

		function __construct(){
			 $dbhost = "localhost";
			 $dbuser = "root";
			 $dbpass = "";
			 $db = "faculty";

			 $this->con = new mysqli($dbhost , $dbuser, $dbpass, $db);
		}

		function getPersonalData($email){
			if($stmt_select = $this->con->prepare("SELECT `firstname`, `lastname`, `email`, `phoneno`, `department`, `designation`, `responsibility`, `teaching_experience_year`, `teaching_experience_month`, `industrial_experience_year`, `industrial_experience_month`,`area_of_interest` FROM `personal_info` WHERE `email` = ?"))
			{
				$stmt_select->bind_param("s",$email);
				
				$stmt_select->bind_result($result_fname,$result_lname,$result_email_id,$result_phone,$result_dept,$result_desig,$result_resp,$result_techexpy,$result_techexpm,$result_indexpy,$result_indexpm,$result_interest);
				
				if($stmt_select->execute())
				{
					$data_container	=	array();
					
					if($stmt_select->fetch())
					{
						$data_container[0]	=	$result_fname;
						$data_container[1]	=	$result_lname;
						$data_container[2]	=	$result_email_id;
						$data_container[3]	=	$result_phone;
						$data_container[4]	=	$result_dept;
						$data_container[5]	=	$result_desig;
						$data_container[6]	=	$result_resp;
						$data_container[7]	=	$result_techexpy;
						$data_container[8]	=	$result_techexpm;
						$data_container[9]	=	$result_indexpy;
						$data_container[10]	=	$result_indexpm;
						$data_container[11]	=	$result_interest;
						
						return $data_container;
					}
				}
				return false;
			}
		}

		function checkUserIsRegstered($email){
			if($stmt_select = $this->con->prepare("Select `email` from `personal_info` where `email` = ?")){
				$stmt_select->bind_param("s",$email);
				$stmt_select->bind_result($result_email);
				if($stmt_select->execute()){
					if($stmt_select->fetch()){
						return true;
					}
				}
				return false;
			}		
		}

		// start website functions

		function insertPersonalData($fname, $lname, $email, $phone, $dept, $desig, $resp, $techexpy, $techexpm, $indexpy, $indexpm, $interest){
			if($stmt_insert = $this->con->prepare("INSERT INTO `personal_info`(`firstname`,`lastname`,`email`,`phoneno`,`department`, `designation` ,`responsibility`,`teaching_experience_year`,`teaching_experience_month`,`industrial_experience_year`,`industrial_experience_month`,`area_of_interest`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)")){
				$stmt_insert->bind_param("ssssssssssss", $fname, $lname, $email, $phone, $dept, $desig, $resp, $techexpy, $techexpm, $indexpy, $indexpm, $interest);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}

		function insertJournalsDetails($email, $jtitle, $jauthor, $jtype, $jdesc, $jyear){
			if($stmt_insert = $this->con->prepare("INSERT INTO `journal` (`email`,`title`,`author`,`type`,`description`,`year`) VALUES (?,?,?,?,?,?)")){
				$stmt_insert->bind_param("ssssss", $email, $jtitle, $jauthor, $jtype, $jdesc, $jyear);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}

		function insertQualifiactionDetails($email, $qdegree, $qspecialization, $quniversity, $qcollege, $qyearpassing){
			if($stmt_insert = $this->con->prepare("INSERT INTO `qualification` (`email`,`degree`,`specialization`,`university`,`college`,`year_of_passing`) VALUES (?,?,?,?,?,?)")){
				$stmt_insert->bind_param("ssssss", $email, $qdegree, $qspecialization, $quniversity, $qcollege, $qyearpassing);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}
		
		function insertBooksDetails($email, $bauthor, $byear, $bdetails){
			if($stmt_insert = $this->con->prepare("INSERT INTO `books` (`email`,`author`,`year`,`book_details`) VALUES (?,?,?,?)")){
				$stmt_insert->bind_param("ssss", $email, $bauthor, $byear, $bdetails);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}

		function insertPatentsDetails($email, $pauthor, $pdesc, $pyear){
			if($stmt_insert = $this->con->prepare("INSERT INTO `patent` (`email`,`patent_author`,`patent_description`,`year`) VALUES (?,?,?,?)")){
				$stmt_insert->bind_param("ssss", $email, $pauthor, $pdesc, $pyear);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}

		function insertConferencesDetails($email, $ctitle, $ctype, $cdesc, $cyear){
			if($stmt_insert = $this->con->prepare("INSERT INTO `conference` (`email`,`title`,`type`,`details`,`year`) VALUES (?,?,?,?,?)")){
				$stmt_insert->bind_param("sssss", $email, $ctitle, $ctype, $cdesc, $cyear);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}

		function insertCvName($new_cv_name, $email){
			if($stmt_insert = $this->con->prepare("UPDATE `personal_info` SET `upload_cv`=? WHERE `email` = ?")){
				$stmt_insert->bind_param("ss", $new_cv_name, $email);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}

		function insertPhotoName($new_photo_name, $email){
			if($stmt_insert = $this->con->prepare("UPDATE `personal_info` SET `upload_photo`=? WHERE `email` = ?")){
				$stmt_insert->bind_param("ss", $new_photo_name, $email);
				if($stmt_insert->execute()){
					return true;
				}else{
					return false;
				}
			}
		}

		function getQualiCnt($email) {
			if($stmt_select = $this->con->prepare("Select count(`email`) from `qualification` where `email` = ?")){
				$stmt_select->bind_param("s",$email);
				$stmt_select->bind_result($result_email);
				if($stmt_select->execute()){
					if($stmt_select->fetch()){
						return $result_email;
					}
				}
				return false;
			}	
		}

		function getJournalCnt($email) {
			if($stmt_select = $this->con->prepare("Select count(`email`) from `journal` where `email` = ?")){
				$stmt_select->bind_param("s",$email);
				$stmt_select->bind_result($result_email);
				if($stmt_select->execute()){
					if($stmt_select->fetch()){
						return $result_email;
					}
				}
				return false;
			}	
		}

		function getBookCnt($email) {
			if($stmt_select = $this->con->prepare("Select count(`email`) from `books` where `email` = ?")){
				$stmt_select->bind_param("s",$email);
				$stmt_select->bind_result($result_email);
				if($stmt_select->execute()){
					if($stmt_select->fetch()){
						return $result_email;
					}
				}
				return false;
			}	
		}

		function getPatentCnt($email) {
			if($stmt_select = $this->con->prepare("Select count(`email`) from `patent` where `email` = ?")){
				$stmt_select->bind_param("s",$email);
				$stmt_select->bind_result($result_email);
				if($stmt_select->execute()){
					if($stmt_select->fetch()){
						return $result_email;
					}
				}
				return false;
			}	
		}

		function getConfCnt($email) {
			if($stmt_select = $this->con->prepare("Select count(`email`) from `conference` where `email` = ?")){
				$stmt_select->bind_param("s",$email);
				$stmt_select->bind_result($result_email);
				if($stmt_select->execute()){
					if($stmt_select->fetch()){
						return $result_email;
					}
				}
				return false;
			}	
		}

	} // class end
?>