Feature: Login

Scenario: User should be able to login with valid credentials
Given User lanches browser
When User opens URL 
And Enters username as "admin@yourstore.com" and password as "admin" into the fields
And Clicks on login button
Then Admin page should be displayed
And Logout and close the browser
   
   
Scenario: User should not be able to login with invalid credentials
Given User lanches browser
When User opens URL 
And Enters username as "admn@yourstore.com" and password as "admin" into the fields
And Clicks on login button
Then Admin page should not be displayed


Scenario: User should not be able to login without any credentials
Given User lanches browser
When User opens URL 
And Enters username as " " and password as " " into the fields
And Clicks on login button
Then Admin page should not be displayed