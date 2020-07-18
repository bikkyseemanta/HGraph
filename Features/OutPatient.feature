Feature: Verify Patient Details in OPD Page

Background:
When user fills "hgdummyrec" and "HGraph@2$2$"
And clicks on Login 
Then user can view dashboard 
And click on Add button 
Then click on Add New Patient button 

@PatientDetailsVerification
Scenario Outline:Verification of Out patient department
Then fill patient details  "<Firstname>" "<Mobno>" "<Lastname>" "<Email>" "<language>" "<Pincode>" "<Ref>"
And clicks on Other Details tab select One Eyed
Then select special status
And select history details "<HistoryComment>" "<GlaucomaHistory>"
And select algeries details "<Penicillincomments>"
Then user can create Appointment


Examples:
| Firstname|Mobno     | Lastname |      Email              | language | Pincode|Ref |HistoryComment|GlaucomaHistory|Penicillincomments|
| Biswajit |9861929608| Tripathy | bswjttripathy@gmail.com | Hindi    | 5600   |Self| TestHistory  |DetailHistory  |AlgeryHistory     |