Feature: Verify Patient Details in OPD Page

@PatientDetailsVerification
Scenario Outline:Verification of Out patient department
Then fill patient details  "<uname>" "<pswd>" "<Firstname>" "<Mobno>" "<Lastname>" "<Email>" "<language>" "<Pincode>" "<Ref>" "<HistoryComment>" "<GlaucomaHistory>" "<Penicillincomments>" 
And validate mobile field "<Mobno>"




Examples:
|  uname   |  pswd      | Firstname|Mobno     | Lastname |      Email              | language | Pincode|Ref |HistoryComment|GlaucomaHistory|Penicillincomments|
|hgdummyrec| HGraph@2$2$| Biswajit |9861929608| Tripathy | bswjttripathy@gmail.com | Hindi    | 5600   |Self| TestHistory  |DetailHistory  |AlgeryHistory     |