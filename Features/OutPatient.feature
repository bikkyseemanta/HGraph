Feature: Verify Patient Details in OPD Page
@MustRun
@PatientDetailsVerificationThroughReceptionist
Scenario Outline:Verification of Out patient department
Then fill patient details  "<uname>" "<pswd>" "<Firstname>" "<Mobno>" "<Lastname>" "<Email>" "<language>" "<Pincode>" "<Ref>" "<Comment1>"  "<Comment2>" "<Comment3>" "<Comment4>" "<Comment5>" "<Comment6>" 
And validate mobile field "<Mobno>" "<note>"


Examples:
|  uname   |  pswd      | Firstname|Mobno     | Lastname |      Email              | language | Pincode|Ref |Comment1          |Comment2      |Comment3        |Comment4       |  Comment5    |Comment6      |   note       |          
|hgdummyrec| HGraph@2$2$| Biswajit |9861929608| Tripathy | bswjttripathy@gmail.com | Hindi    | 560037   |Self|Opthalmic Comments|Opthal History|Systemic History|Medical History|Family History|Other Comments|Reception Note|

@PatientDetailsVerificationThroughDoctor
Scenario Outline:Patient Details Verification through Doctor login
When doctor login "<uname>" and "<pswd>"
Then Doctor verify some details of patient
When Doctor create Optom Template "<Comment1>" "<Comment2>" "<Comment3>" "<Comment4>" "<Comment5>" "<Comment6>" "<input>"
Then Doctor fills Auto Refraction values
Then Doctor fills Dry Refraction values "<drycomment>"
Then Doctor fills Refraction dialated values "<diacomment>"
Then Doctor fills PGP values
Then Doctor fills Glasses prescription "<GlassAdvice>"
Then Doctor fills Intermediate Glasses prescription "<IntGlassAdvice>"
Then Doctor fills PMT 

Examples:

|uname     |pswd       | name          |input|Comment1          |Comment2      |Comment3        |Comment4       |  Comment5    |Comment6      |
|hgdummydoc|HGraph@2$2$|Test Automation|  50 |Opthalmic Comments|Opthal History|Systemic History|Medical History|Family History|Other Comments|