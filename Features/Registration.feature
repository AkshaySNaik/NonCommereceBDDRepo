Feature: Registration

Scenario: User should be able to register with vaid credentials
Given User lanches browser
When User opens URL 
And Enters username as "admin@yourstore.com" and password as "admin" into the fields
And Clicks on login button
Then Admin page should be displayed
When Selected customer option from menu bar
And click on new user and create a new user
And Save the newely created customer details
Then Success message should be displayed "The new customer has been added successfully."
And Logout and close the browser