Feature: Registered Customer Search

Scenario: User should be able to search the registered customer details 
Given User lanches browser
When User opens URL 
And Enters username as "admin@yourstore.com" and password as "admin" into the fields
And Clicks on login button
Then Admin page should be displayed
When Selected customer option from menu bar
And Enter lastname as "Smith" and click on search button
Then Registed customer details needs to display
And Logout and close the browser