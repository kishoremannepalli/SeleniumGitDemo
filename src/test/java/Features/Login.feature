Feature: Login to Application
Scenario Outline: Postive Test Cases
Given Brower is intialieze
And Navigated to "http://www.qaclickacademy.com/" homepage
And click on loign button to navigate to secure login page
When user enters <username> and <password> and logs in
Then verify the user is succefully logged in

Examples:
|username			|password		|
|test99@gmail.com	|123456			|
|kishore@gmail.com	|test123		|



