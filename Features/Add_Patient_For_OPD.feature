Feature: Create Appointment for OPD 

Background:
When user fills "hgdummyrec" and "HGraph@2$2$"
And clicks on Login 
Then user can view dashboard
And click on Add button
Then click on Add New Patient button

@CreatePatientWithMandatoryFields
Scenario Outline: Create Appointment for OPD by adding mandatory fields
#Then User should see a modal having the header "Search Patient or Add New Patient"
#Then Validate all the fields contains in add_new_patient modal
#Then User should see a modal having the header "Patient Registration & Appointment Form"
And Modal must have below mentioned tabs
      | Patient Details |
      | Other Details   |
      | History         |
      | Allergies       |
When user without filling mandatory field and click on Appointment button
Then validate warning message should display 
When user fill mandatory fields "<fname>" "<mobNo>"
And validate the size and text of the name drop down values 
And validate the size and text of laungage drop down values
And validate the size and text of the patient type drop down values
Then user can create Appointment

Examples:
|fname    |mobNo     | 
|Bikky    |4678907665| 

@CreatePatientWithAllFieldsValues
Scenario Outline: Create Appointment for OPD by adding all fields values
Then fill patient details  "<firstname1>" "<mobno1>" "<middlename>" "<lastname>" "<secondaryno>" "<email>" "<language>" "<secondarylanguage>" "<pincode>" "<Add1>" "<Add2>" "<MedicalRepoNo>" "<Aadhaar>" "<PANno>" "<DLno>"
Then user can create Appointment
Examples:
|uname     |pswd        | firstname1 |mobno1     |middlename | lastname | secondaryno |      email              | language | secondarylanguage | pincode | Add1  | Add2      | MedicalRepoNo | Aadhaar   | PANno    | DLno      |Ref |DoctorReferal  | DrName        |DRMobNo    |DrEmail        |DRSpecialist       |Drlocation|Drcity   |DrState  |DrComments|staffreferal|relative|relativename|relativemobno|relativeemail |relation|comment|campaign |camp|InstitutionalReferral|Agent|Online|ThirdParty|self|EmergencyName|EmergencyContact|
|hgdummyrec| HGraph@2$2$| Vicky      |9861929608 | Kumar     | Tripathy | 7751996482  | bswjttripathy@gmail.com | Hindi    | English           | 5600  | keruna| chatrapada| MRN1        |30965893118    |ANMPT2557J| OR68310567|Self| Doctor Referal|Automation Test|88008248940|bki@gmail.com  |Medicine Specilist |Marathalli|Bangalore|Karnataka|Test      |staffreferal|Relative|Test1       |5773437887   |Test@gmail.com| Tester |Test   |campaign| camp|InstitutionalReferral|Agent|Online|ThirdParty|self|AutTest      |AutoTest   |

@Validate_Other_Details_Tab
Scenario Outline: Create Appointment for OPD by adding mandatory fields
When user fill mandatory fields "<fname>" "<mobNo>"
And clicks on other details tab
And validate blood gropup radio button should be single select
And Maritial status should be single select radio button
And fill emergency contact "<name>" "<number>"
And validate special status
Then user can create Appointment
Examples:
|fname       |mobNo     | name   | number |
|Biswajit    |1234567890| Pallabi|8987511234|

@Validate_History_Tab
Scenario Outline: Create Appointment for OPD by adding History fields
When user fill mandatory fields "<fname>" "<mobNo>"
And clicks on history tab
And Opthalmic History have below tabs
 | Glaucoma |
 | Retinal Detachment |
 | Glass|
 | Eye Disease |
 |Eye Surgery|
 |Uveitis|
 |Retinal laser|
Then each Opthalmic History name should be clickable
 And select Left Duration for each Opthalmic tabs
 And select Left Duration Units for each Opthalmic tab
 And fill comments for each Opthalmic History Comment
Then add comments inside Opthalmic Hitory
And Systemic History have below tabs
 | Diabetes |
 | Hypertension |
 |Alcoholism|
 |Smoking Tobacco|
 |Cardiac Disorder|
 |Steroid Intake|
 |Drug Abuse|
 |Hiv Aids|
 |Cancer Tumor|
 |Tuberculosis|
 |Asthma|
 |Cns Disorder Stroke|
 |Hypothyroidism|
 |Hyperthyroidism|
 |Hepatitis Cirrhosis|
 |Renal Disorder|
 |Acidity|
 |On insulin|
 |On Aspirin Blood Thinners|
 |Consanguinity|
 |Thyroid Disorder|
 |Chewing Tobacco|
Then each Systemic History name should be clickable
 And select Duration for each Systemic tabs
 And select Duration Units for each Systemic tab
 And fill comments for each Systemic History Comment 
Then add comments inside Systemic Hitory
And add Medical History
Then add Family history 
Then user can create Appointment
Examples:
|fname    |mobNo     | name   | number |
|Bikky    |4678907665| Pallabi|8987511234|

@Validate_Allergies_Tab
Scenario Outline: Create Appointment for OPD by adding Allergies fields
When user fill mandatory fields "<fname>" "<mobNo>"
And clicks on allergies tab
And Drug Allergies have below tabs
 |Antimicrobial Agents |
 | Antifungal Agents |
 | Antiviral Agents|
 | Nsaids |
 |Eye Drops|
 Then user clicks on Antimicrobial Agents 
 Then Antimicrobial agents have below tabs 
 |Ampicillin |
 | Amoxicillin |
 | Ceftriaxone|
 | Ciprofloxacin |
 |Clarithromycin|
 |Co Trimoxazole|
 |Ethambutol |
 | Isoniazid |
 | Metronidazole|
 | Penicillin |
 |Rifampicin|
 |Streptomycin|
 Then user clicks on Antifungal Agents
 Then Antifungal agents have below tabs
 |Ketoconazole |
 |Fluconazole |
 |Itraconazole|
 Then user clicks on Antiviral Agents
 Then Antiviral agents have below tabs
 |Acyclovir |
 |Efavirenz |
 |Enfuvirtide|
 |Nelfinavir |
 |Nevirapine |
 |Zidovudine|
 Then user clicks on Nsaids
 Then Nsaids have below tabs
 |Aspirin |
 |Paracetamol |
 |Ibuprofen|
 |Diclofenac |
 |Aceclofenac |
 |Naproxen|
 Then user clicks on EyeDrops
 Then EyeDrops have below tabs
 |Tropicamide_P |
 |Tropicamide |
 |Timolol|
 |Homide |
 |Latanoprost |
 |Brimonidine|
 |Travoprost |
 |Tobramycin |
 |Moxifloxacin|
 |Homatropine |
 |Pilocarpine |
 |Cyclopentolate|
 |Atropine|
 |Phenylephrine |
 |Tropicacyl |
 |Paracain|
 |Ciplox | 
 And Contact Allergies have below tabs
 |Alcohol |
 | Latex |
 | Betadine|
 | Adhesive Tape |
 |Tegaderm|
 |Transpore|
  And Food Allergies have below tabs
 |All Seafood |
 | Corn |
 | Egg|
 | Milk Proteins |
 |Peanuts|
 |Shellfish Only|
 |Soy Protein |
 |Lactose |
 |Mushroom|
 Then validate each tabs of Antimicrobial agents
 Then each Antimicrobial agents name should be display
 And select Duration for each Antimicrobial agents
 And select Duration Units for each Antimicrobial agents
 And fill comments for each Antimicrobial agents
Then validate each tabs of Antifungal agents
 Then each Antifungal agents name should be display
 And select Duration for each Antifungal agents
 And select Duration Units for each Antifungal agents
 And fill comments for each Antifungal agents
Then validate each tabs of Antiviral Agents
 Then each Antiviral Agents name should be display
 And select Duration for each Antiviral Agents
 And select Duration Units for each Antiviral Agents
 And fill comments for each Antiviral Agents
Then validate each tabs of Nsaids
 Then each Nsaids name should be display
 And select Duration for each Nsaids
 And select Duration Units for each Nsaids
 And fill comments for each Nsaids
 Then validate each tabs of Eye Drops
 Then each Eye Drops name should be display
 And select Duration for each Eye Drops
 And select Duration Units for each Eye Drops
 And fill comments for each Eye Drops
 Then validate each tabs of Contact Allergies
 Then each Contact Allergies name should be display
 #And select Duration for each Contact Allergies
 #And select Duration Units for each Contact Allergies
 #And fill comments for each Contact Allergies
 Then validate each tabs of Food Allergies
 Then each Food Allergies name should be display
 #And select Duration for each Food Allergies
 #And select Duration Units for each Food Allergies
 #And fill comments for each Food Allergies
 Then user can create Appointment
 Examples:
|fname    |mobNo     |
|Bikky    |4678907665| 

@Validate_Appointment_Details
Scenario Outline: Create Appointment for OPD by adding Appointment Details fields
When user fill mandatory fields "<fname>" "<mobNo>"
Then validate Walkin type radio buttom autoselected
Then validate Appointment Date and Time
And validate location drop down
And validate Doctor drop down
Then select Appointment Types
And select Appointment Category
Then user can create Appointment
 Examples:
|fname    |mobNo     |
|Bikky    |4678907665|
