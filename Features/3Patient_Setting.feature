Feature: Setting

Scenario Outline: Patient setting
Given open the browser and enter the URL "http://qaehr.healthgraph.in/users/login"
When user fills "<uname>" and "<pswd>"
And clicks on Login 
Then user can view dashboard
When user clicks on profile setting button
Then clicks on organisation setting link
And clicks on Patient Setting link from the left panel menu
And it should display below buttons
|First Name|
|Mobile Number|
|Gender|
|Age|
|Age Month|
|Referral Source|
|Save|
Then validate mandatory field setting


Examples:
|uname     |pswd       |
|hgdummydoc|HGraph@2$2$|