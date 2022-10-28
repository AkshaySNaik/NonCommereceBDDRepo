Feature: Orders Search

Scenario: User should be able to search the orders with valid credentials
Given User lanches browser
When User opens URL 
And Enters username as "admin@yourstore.com" and password as "admin" into the fields
And Clicks on login button
Then Admin page should be displayed 
When Selected sales option from menu bar
And User clicks on orders option
Then Orders page should be displayed with pagetitle "Orders / nopCommerce administration"
When Entered all the deatlis for OrderSearch
And User clicks on searchbutton
Then Verify the Shipping status of the order
And Logout and close the browser


