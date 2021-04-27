<?php
	//start session on web page
	session_start();

	//Include Google Client Library for PHP autoload file
	require_once 'vendor/autoload.php';

	//Make object of Google API Client for call Google API
	$google_client = new Google_Client();

	//Set the OAuth 2.0 Client ID
	$google_client->setClientId('8557046453-psfd781g163falo49dm13qce3utbjl45.apps.googleusercontent.com');

	//Set the OAuth 2.0 Client Secret key
	$google_client->setClientSecret('_rD2NGTQzdr_l7xjmKpG0m4C');

	//Set the OAuth 2.0 Redirect URI
	$google_client->setRedirectUri('http://localhost/faculty/index.php');

	// to get the email and profile 
	$google_client->addScope('email');

	$google_client->addScope('profile');

?>