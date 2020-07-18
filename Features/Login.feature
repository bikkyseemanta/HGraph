Feature: Login

Scenario Outline: Successfully login with valid credentials
When user fills "<uname>" and "<pswd>"
And clicks on Login 
Then user can view dashboard

Examples:
|uname     |pswd       |
|hgdummydoc|HGraph@2$2$|
