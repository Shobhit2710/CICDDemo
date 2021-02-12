Feature: Login into Application

Scenario Outline: Positive test validationg login
Given Intialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" Site
And Click on Login link in home page to land on secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is not succesfully logged in

Examples:

|username         |password      |
|abc@gmail.com	  |abcdefg		 |
|xyz@gmail.com	  |abcde123fg	 |