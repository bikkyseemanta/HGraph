Feature: Create Appointment for OPD 

@PatientDetails
Scenario Outline: Create Appointment for OPD by adding New Patient
Given open the browser and enter the URL "https://ehr.healthgraph.in/users/login"
When user fills "<uname>" and "<pswd>"
And cliks on Login 
Then user can view dashboard
Then EHR patient list page should display
And click on Add button
Then click on Add New Patient button
When user without filling mandatory field and click on Appointment button
Then validate warning message should display 
When user fill mandatory fields "<fname>" "<mobNo>"
Then user can create Appointment
Then user clicks on the ADD button 
And User clicks on the add new patient button
Then Patient Registration & Appointment Form should display
And user fill patientdetails text info 
Then user select patient details drop down info "<name>" "<primarylaungage>" "<secondarylaungage>" "<patienttype>" "<patientrefsource>"
And user select gender radio btn 

Examples:
|fname   |mobNo     |uname     |pswd       |name|primarylaungage|secondarylaungage|patienttype|patientrefsource|
|Biswajit|7795646804|hgdummydoc|HGraph@2$2$|Mr.|Hindi           |English          |VIP        |Self            |