Feature: Create Appointment for OPD 

@PatientDetails
Scenario Outline: Create Appointment for OPD by adding New Patient
Given open the browser and enter the URL "https://ehr.healthgraph.in/users/login"
When user fills "<uname>" and "<pswd>"
And clicks on Login 
Then user can view dashboard
And click on Add button
Then User should see a modal having the header
Then Validate all the fields contains in add_new_patient modal
Then click on Add New Patient button
#Then User should see a modal having the header "Patient Registration & Appointment Form"
And Modal must have below mentioned tabs
      | Patient Details |
      | Other Details   |
      | History         |
      | Allergies       |
When user without filling mandatory field and click on Appointment button
Then validate warning message should display 
When user fill mandatory fields "<fname>" "<mobNo>"
Then user can create Appointment
And click on Add button
Then click on Add New Patient button
Then fill patient details  "<firstname1>" "<mobno1>" "<middlename>" "<lastname>" "<secondaryno>" "<email>" "<language>" "<secondarylanguage>" "<pincode>" "<Add1>" "<Add2>" "<MedicalRepoNo>" "<Aadhaar>" "<PANno>" "<DLno>"

Examples:
|uname     |pswd        |fname    |mobNo     | firstname1      |mobno1     |middlename | lastname | secondaryno |      email              | language | secondarylanguage | pincode | Add1  | Add2      | MedicalRepoNo | Aadhaar   | PANno    | DLno     |DoctorReferal  | DrName          |DRMobNo     |DrEmail     |DRSpecialist       |Drlocation|Drcity   |DrState  |DrComments|staffreferal|relative|relativename|relativemobno|relativeemail |relation|comment|campaign |camp|InstitutionalReferral|Agent|Online|ThirdParty|self|EmergencyName|EmergencyContact|
|hgdummyrec| HGraph@2$2$|Bikky    |4678907665|  Selenium       |9861929608 | Automation     | Test | 7751996482 | bswjttripathy@gmail.com | Hindi    | English           | 5600  | keruna| chatrapada| MRN1        |30965893118|ANMPT2557J|        OR68310567| Doctor Referal|Automation Test|88008248940|bki@gmail.com  |Medicine Specilist |Marathalli|Bangalore|Karnataka|Test      |staffreferal|Relative|Test1       |5773437887   |Test@gmail.com| Tester |Test   |campaign| camp|InstitutionalReferral|Agent|Online|ThirdParty|self|AutTest      |AutoTest        |