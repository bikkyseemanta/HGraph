Feature: Login

Scenario Outline: Successfully login with valid credentials
Given open the browser and enter the URL "https://ehr.healthgraph.in/users/login"
When user fills "<uname>" and "<pswd>"
And cliks on Login 
Then user can view dashboard

Examples:
|uname     |pswd       |
|hgdummydoc|HGraph@2$2$|
