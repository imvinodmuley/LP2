<?php
  require_once("lib/DatabaseFun.php");
  $db = new database_functions();

  // get email using google login
  // check if exist
  // if exist then fetch record and dispalay
  // else insert all record

  // firsr start with else part
  $flag = 1;

  $alert_msg = "";

  $registeredUser = $db->checkUserIsRegstered($_SESSION['user_email_address']);
  $personal_data = array();
  $qualification_cnt = 0;
  $journal_cnt = 0;
  $book_cnt = 0;
  $patent_cnt = 0;
  $conference_cnt = 0;

  // chcek previously visited
  if($registeredUser){
    $personal_data = $db->getPersonalData($_SESSION['user_email_address']);
    $qualification_cnt = $db->getQualiCnt($_SESSION['user_email_address']);
    $journal_cnt = $db->getJournalCnt($_SESSION['user_email_address']);
    $book_cnt = $db->getBookCnt($_SESSION['user_email_address']);
    $patent_cnt = $db->getPatentCnt($_SESSION['user_email_address']);
    $conference_cnt = $db->getConfCnt($_SESSION['user_email_address']);
  }

  if(isset($_POST['nextAndSubmit'])){

    // Personal Info
    $fname = $_POST['fname'];
    $lname = $_POST['lname'];
    $email = $_POST['email'];
    $phone = $_POST['phone'];
    $dept = $_POST['dept'];
    $desig = $_POST['desig'];
    $resp = $_POST['resp'];
    $techexpy = $_POST['techexpy'];
    $techexpm = $_POST['techexpm'];
    $indexpy = $_POST['indexpy'];
    $indexpm = $_POST['indexpm'];
    $interest = $_POST['interest'];

    if(!$registeredUser){
    	if(!$db->insertPersonalData($fname, $lname, $email, $phone, $dept, $desig, $resp, $techexpy, $techexpm, $indexpy, $indexpm, $interest)){
	      $flag = 0;
	      echo "<script>alert('Personal Data incorretly filled');</script>"; 
	    }
    }
   
    // Qualification details

    $cntQuali = $_POST['cntQuali'];

    for($x = 0; $x < $cntQuali; $x++){
       $qdegree = $_POST['qdegree'.$x];
       $qspecialization = $_POST['qspecialization'.$x];
       $quniversity = $_POST['quniversity'.$x];
       $qcollege = $_POST['qcollege'.$x];
       $qyearpassing = $_POST['qyearpassing'.$x];

       if(!$db->insertQualifiactionDetails($email, $qdegree, $qspecialization, $quniversity, $qcollege, $qyearpassing)){
        echo "<script>alert('Qualification Data incorretly filled');</script>"; 
       }
    }

    // Journals Details

    $cntJornals = $_POST['cntJornals'];

    for($x = 0; $x < $cntJornals; $x++){
       $jtitle = $_POST['jtitle'.$x];
       $jauthor = $_POST['jauthor'.$x];
       $jtype = $_POST['jtype'.$x];
       $jdesc = $_POST['jdesc'.$x];
       $jyear = $_POST['jyear'.$x];

       if(!$db->insertJournalsDetails($email, $jtitle, $jauthor, $jtype, $jdesc, $jyear)){
        echo "<script>alert('Journals Data incorretly filled');</script>"; 
       }
    }

    // books details

    $cntBooks = $_POST['cntBooks'];

    for($x = 0; $x < $cntBooks; $x++){
       $bauthor = $_POST['bauthor'.$x];
       $byear = $_POST['byear'.$x];
       $bdetails = $_POST['bdetails'.$x];

       if(!$db->insertBooksDetails($email, $bauthor, $byear, $bdetails)){
         echo "<script>alert('Books Data incorretly filled');</script>"; 
       }
    }

    // patent details

    $cntPatents = $_POST['cntPatents'];

    for($x = 0; $x < $cntPatents; $x++){
       $pauthor = $_POST['pauthor'.$x];
       $pdesc = $_POST['pdesc'.$x];
       $pyear = $_POST['pyear'.$x];

       if(!$db->insertPatentsDetails($email, $pauthor, $pdesc, $pyear)){
         echo "<script>alert('Patent Data incorretly filled');</script>"; 
       }
    }

    // Conference details

    $cntConf = $_POST['cntConf'];

    for($x = 0; $x < $cntConf; $x++){
       $ctitle = $_POST['ctitle'.$x];
       $ctype = $_POST['ctype'.$x];
       $cdesc = $_POST['cdesc'.$x];
       $cyear = $_POST['cyear'.$x];

       if(!$db->insertConferencesDetails($email, $ctitle, $ctype, $cdesc, $cyear)){
         echo "<script>alert('Conference Data incorretly filled');</script>"; 
       }
    }

    // Getting CV 

    $valid_formats_cv = array("pdf");

    $cv_name = $_FILES['cv']['name'];
    $cv_type = $_FILES['cv']['type'];
    $cv_size = $_FILES['cv']['size'];
    $cv_loc = $_FILES['cv']['tmp_name'];

     if(strlen($cv_name)){
      list($name, $ext) = explode(".", $cv_name);
      if(in_array($ext, $valid_formats_cv)){
        $new_cv_name = $fname.$lname.".".$ext;
        $cv_desti_loc = "UserData/cvs/".$new_cv_name;
            if(move_uploaded_file($cv_loc, $cv_desti_loc)){
              if(!$db->insertCvName($new_cv_name, $email)){
                echo "<script>alert('Error in CV');</script>"; 
              }
        }
      }
     }

    // Getting Photo
    $valid_formats_photo = array("jpg", "png", "gif", "bmp", "JPG", "PNG", "GIF", "BMP");

    $photo_name = $_FILES['photo']['name'];
    $photo_type = $_FILES['photo']['type'];
    $photo_size = $_FILES['photo']['size'];
    $photo_loc = $_FILES['photo']['tmp_name'];

    if(strlen($photo_name)){
      list($name_pic, $ext_pic) = explode(".", $photo_name);
      if(in_array($ext_pic, $valid_formats_photo)){
        $new_photo_name = $fname.$lname.".".$ext_pic;
        $photo_desti_loc = "UserData/photos/".$new_photo_name;
            if(move_uploaded_file($photo_loc, $photo_desti_loc)){
              if(!$db->insertPhotoName($new_photo_name, $email)){
                echo "<script>alert('Error in Photo');</script>"; 
              }
        }
      }
     }

    if($flag){
      ?>
        <script type="text/javascript">
          alert("Rrgistration Done Successfully ...");
          window.location.href = "logout.php";
        </script>
      <?php
    }
  }

?>

<html>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap" rel="stylesheet">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/error.css">
	<link rel="stylesheet" href="css/bootstrap.min.css">

	<head>
		<title>Faculty Profile</title>
		<style type="text/css">
			input{
				margin-bottom: 15px;
			}
			select {
				margin-bottom: 15px;
			}
		</style>
	</head>
	<body onload = "checkBlank(<?php echo "$personal_data[4]"?>)">

	<div class="header"> 
		<div class="tooltip-logout">
		  <a href="logout.php"><img src="images/logout.png" class="logout" id="logout"></a>
		  <span class="tooltiptext">Logout</span>
		</div>
		  <?php 
		    if($registeredUser) {
		      echo '<button name="preview" class="preview" onclick="previewForm()" data-toggle="modal" data-target="#previewModel">Preview</button>';
		    }
		  ?>
	</div>

	  <!-- Modal -->
	  <div class="modal fade" id="previewModel" role="dialog">
	    <div class="modal-dialog">
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title"><?php echo $personal_data[0] . " " . $personal_data[1]; ?></h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <!-- fetch data from database and Display here -->
	          Email : <?php echo $personal_data[2]; ?> <br>
	          Phone : <?php echo $personal_data[3]; ?> <br>
	          Department : <?php echo $personal_data[4]; ?> <br>
	          Designation : <?php echo $personal_data[5]; ?> <br>
	          Responsibilities :  <?php echo $personal_data[6]; ?> <br>
	          Teching Experience : <?php echo $personal_data[7] . " " . $personal_data[8]; ?> <br>
	          Industrial Experience : <?php echo $personal_data[9] . " " . $personal_data[10]; ?> <br>
	          Area Of Integert : <?php echo $personal_data[11]; ?> <br>
	          Total Qualification Records : <?php echo $qualification_cnt; ?> <br>
	          Total Journals Records : <?php echo $journal_cnt; ?> <br>
	          Total Books Records : <?php echo $book_cnt; ?> <br>
	          Total Patents Records : <?php echo $patent_cnt; ?> <br>
	          Total Conferences Records : <?php echo $conference_cnt; ?> <br>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="prevBtn" data-dismiss="modal">Close</button>
	        </div>
	      </div>
	    </div>
	  </div>

	  <form id="regForm" action="index.php" method="POST" enctype="multipart/form-data">

	    <div class="tab">

	      <h1>Personal Details:</h1>

	      <b> Name: </b>
	      <div class="col-md-12 ">
	        <div class="validate">
	          <label for="Tooltips" class="error"></label>
	          <input type="text" id="fname" name="fname" placeholder="First Name" value="<?php if($registeredUser){echo "$personal_data[0]";}?>" required>
	        </div>
	      </div>

	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error1"></label>
	            <input type="text" id="lname" name="lname" placeholder="Last Name" value="<?php if($registeredUser){echo "$personal_data[1]";}?>" required>
	        </div>
	      </div>

	      <b> Email: </b> 
	       <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error2"></label>
	            <input type="text" name="email" value="<?php echo  $_SESSION['user_email_address'];?>" readonly style="cursor: not-allowed" id="email" placeholder="Email" required>
	        </div>
	      </div>
	      
	      <b> Phone Number: </b>
	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error3"></label>
	            <input type="text" id="phone"  name="phone" placeholder="Phone" value="<?php if($registeredUser){echo "$personal_data[3]";}?>" required>
	        </div>
	      </div>

	      <b> Department: </b>
	      <div class="col-md-12 " >
	        <div class="validate">
	            <label for="Tooltips" class="error4"></label>
	            <select id="dept" name="dept" 
	            readonly="<?php if($registeredUser) echo 'true'; else echo 'false'; ?>"
	            style = "<?php if($registeredUser) echo "cursor: not-allowed"?>"
	            required>
	              <option value="0">Select Department..</option>
	              <option value="1">COMP</option>
	              <option value="2">IT</option>
	              <option value="3">ENTC</option>
	              <option value="4">Other</option>
	            </select>
	        </div>
	      </div>

	      <b> Designation:  </b>
	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error5"></label>
	            <input type="text" name="desig" id="des" placeholder="Designation" value="<?php if($registeredUser){echo "$personal_data[5]";}?>" required>
	        </div>
	      </div>
	      
	      <b> Responsibility: </b>
	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error6"></label>
	            <input type="text" id="res" name="resp" placeholder="Responsibility" value="<?php if($registeredUser){echo "$personal_data[6]";}?>"   required>
	        </div>
	      </div>

	      <b> Teaching Experience:
	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error7"></label>
	            <input type="text" id="yr" name="techexpy" placeholder="Years" value="<?php if($registeredUser){echo "$personal_data[7]";}?>" required>
	        </div>
	      </div>

	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error8"></label>
	            <input type="text" id="mon" name="techexpm" placeholder="Months" value="<?php if($registeredUser){echo "$personal_data[8]";}?>"  required>
	        </div>
	      </div>

	      <b> Industrial Experience: </b>
	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error9"></label>
	            <input type="text" id="yr1" name="indexpy" placeholder="Years" value="<?php if($registeredUser){echo "$personal_data[9]";}?>" required>
	        </div>
	      </div>

	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error10"></label>
	            <input type="text" id="mon1" name="indexpm" placeholder="Months" value="<?php if($registeredUser){echo "$personal_data[10]";}?>" required>
	        </div>
	      </div>

	      <b> Area of Interest: </b>
	      <div class="col-md-12 ">
	        <div class="validate">
	            <label for="Tooltips" class="error11"></label>
	            <input type="text" id="aoi"  name="interest" placeholder="Area of Interest" value="<?php if($registeredUser){echo "$personal_data[11]";}?>"  required>
	        </div>
	      </div>
	    </div>

	     <div class="tab">
	      <h1>Qualification:</h1>
	      <b>Qualification</b>

	      <div  class="quali-add-div" id="quali-add-div">
	        <div class="col-md-12 ">
	          <div class="validate">
	            <label for="Tooltips" class="error13"></label>
	            <input type="text" name="cntQuali" id="cntQuali" placeholder="Enter Numbers of Degree's you have... (0 <= i < 10)" style="width: 80%">
		        <img src="images/add.png" class="addbtn" id="addBtnQuali" onclick="insertDivQuali()"> 
	          </div>
	        </div>
	      </div>
	      <div id="multi-ip-quali"></div>
	    </div>

	    <div class="tab">
	      <h1>Journals:</h1>
	      <b>Published Journals</b>
	      <div class="jornals-add-div" id="jornals-add-div">
	         <div class="col-md-12 ">
	            <div class="validate">
	                <label for="Tooltips" class="error12"></label>
                	<input type="text"  name="cntJornals" id="cntJornals" placeholder="Enter Numbers of Records (0 <= i < 10)" style="width: 80%">
	                <img src="images/add.png" class="addbtn" onclick="insertDivjornals()">
	            </div>
	        </div>        
	      </div>
	      <div id="multi-ip-jornals"></div>
	    </div>

	    <div class="tab">  
	      <h1>Books:</h1>
	      <b>Books Details</b> 
	       <div class="books-add-div" id="books-add-div">
	         <div class="col-md-12 ">
	          <div class="validate">
	              <label for="Tooltips" class="error14"></label>
	              <input type="text" name="cntBooks" id="cntBooks" placeholder="Enter Numbers of Records you want... (0 <= i < 10)" style="width: 80%">
	              <img src="images/add.png" class="addbtn" onclick="insertDivBooks()">
	          </div>
	        </div> 
	      </div>
	      <div id="multi-ip-books"></div>
	    </div>


	    <div class="tab">
	      <h1>Patent:</h1>
	      <b>Patent Details</b>
	      <div class="patent-add-div" id="patent-add-div">
	         <div class="col-md-12 ">
	            <div class="validate">
	                <label for="Tooltips" class="error15"></label>
	                <input type="text"  name="cntPatents" id="cntPatents" placeholder="Enter Numbers of Records (0 <= i < 10)" style="width: 80%" >
	                <img src="images/add.png" class="addbtn" onclick="insertDivPatents()">
	            </div>
	        </div>
	      </div>
	      <div id="multi-ip-Patents"></div>
	    </div>

	    <div class="tab">
	      <h1>Conference:</h1>
	      <b>Conference Details</b>
	      <div class="conf-add-div" id="conf-add-div">
	         <div class="col-md-12 ">
		        <div class="validate">
		            <label for="Tooltips" class="error16"></label>
		            <input type="text"  name="cntConf" id="cntConf" placeholder="Enter Numbers of Records (0 <= i < 10)" style="width: 80%">
		             <img src="images/add.png" class="addbtn" onclick="insertDivConferences()">
		        </div>
	        </div>
	      </div>
	      <div id="multi-ip-Conf"></div>
	    </div>

	    <div class="tab">
	      <h1>Documents:</h1>
	      <b>Documents Upload</b> 
	      CV:
	      <input type="file" placeholder="CV..."  name="cv">
	      <br>
	      Photo:
	      <br>
	      <input type="file" placeholder="Photo..."  name="photo">
	    </div>

	    <hr>
	    <div style="overflow:auto;">
	      <div style="float:right; margin-right: 50px;">
	        <button type="button" id="prevBtn" class="prevBtn"  onclick="nextPrev(-1)">Previous</button>
	        <button type="button" id="nextBtn" onclick="nextPrev(1)" name="nextAndSubmit">Next</button>
	      </div>
	    </div>

	    <!-- Circles which indicates the steps of the form: -->
	    <div style="text-align:center;margin-top:40px;">
	      <span class="step"></span>
	      <span class="step"></span>
	      <span class="step"></span>
	      <span class="step"></span>
	      <span class="step"></span>
	      <span class="step"></span>
	      <span class="step"></span>
	    </div>

	  </form>

	  <script src="js/dynamicFun.js"></script>
	  <script src="js/jquery.min.js"></script>
	  <script src="js/visualFun.js"></script>
	  <script src="js/error.js"></script>

	</body>
</html>
