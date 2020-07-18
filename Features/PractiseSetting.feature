Feature: Practise Setting under User Setting 
Background:

When user fills "hgdummydoc" and "HGraph@2$2$"
And clicks on Login 
Then user can view dashboard
Then click on Setting button and go to Practise Setting

@VerifyDefaultViewFunctionality
Scenario Outline: Default View Functionality
Then clicks on Default view and validate the functionality

Examples:
|uname     |pswd       |
|hgdummydoc|HGraph@2$2$|

@VerifyAdviceSet
Scenario Outline: Advice Set Functionality under Clinical
And clicks on Clinical from the left panel menu 
Then click on Advice Sets and validate functionality"<name>" 
Then navigate to OPD and create one Appointment
When mark patient as Arrived go to Eye Template"<name>"

Examples:
|uname     |pswd       | name          |
|hgdummydoc|HGraph@2$2$|Test Automation|

@VerifyUserNotes_MedicalTemplate
Scenario Outline: User Note Functionality under Clinical
And clicks on Clinical from the left panel menu 
Then click on User Note and validate the New Template
And create Medical Certificate Template "<name>" "<Heading>" "<Subject>" "<Content>"
Then verify created Medical certificate should display in Template "<name>"
#When user deleted that template its should not display under template "<name>"
Then create again new Medical Certificate Template "<newname>" "<Heading1>" "<Subject1>" "<Content1>"
Then validate created Medical Certificate template should display Patient Summary page "<newname>"

Examples:
|name            |Heading            | Subject         | Content         | newname                      |Heading1           | Subject1        | Content1        |
|First Med Cert2 |  Med Cert Heading1|Med Cert Subject1|Med Cert Content1|Biswajit Medical Certificate  |Med Cert Heading   |Med Cert Subject |Med Cert Content |



@VerifyUserNotes_ReferalTemplate
Scenario Outline: User Note Functionality under Clinical
And clicks on Clinical from the left panel menu 
Then click on User Note and validate the New Template
And create Referal Message Template "<name>" "<Heading>" "<Subject>" "<Content>"
Then verify created Referal Message should display in Template "<name>"
#When user deleted that Referal Message its should not display under template "<name>"
Then create again new Referal Message Template "<newname>" "<Heading1>" "<Subject1>" "<Content1>"
Then validate created Referal Message template should display Patient Summary page "<newname>"

Examples:
|name            |Heading              | Subject         | Content         |newname                       |Heading1           | Subject1        | Content1        |
|First Ref Cert1 |Referal Cert Heading1|Ref Cert Subject1|Ref Cert Content1|Biswajit Referal Certificate  |Ref Cert Heading   |Ref Cert Subject |Ref Cert Content |


@VerifyMedicationLists
Scenario Outline: Medication Lists under Clinical
And clicks on Clinical from the left panel menu 
Then click on Medications Lists and validate each tab
When create Medication Lists "<MedicineName1>" "<GenericName1>" "<MedicineType1>"
Then verify created Medication Lists should display in Medication Lists "<MedicineName1>"
When user deleted that Medication List its should not display under template "<MedicineName1>"
Then create again new Medication Lists "<MedicineName>" "<GenericName>" "<MedicineType>"
Then validate created Medication List should display Patient Eye Template "<MedicineName>"

Examples:
|MedicineName1| GenericName1 | MedicineType1 |MedicineName |GenericName   | MedicineType |
|Azythromycin | Azios        | Tablets       | Relivia     |Pain Releif   | Lotion       |


@VerifyInPatientProcedureNotes
Scenario Outline: In Patient Procedure Notes under Clinical
And clicks on Clinical from the left panel menu 
Then click on In Patient Procedure Note and validate each tab
When create Procedure Note "<ProcedureName1>" "<ProcedureNote1>" 
Then verify created Procedure Note name should display in Procedure Notes "<ProcedureName1>"
#When user deleted that Procedure Note name its should not display under template "<ProcedureName1>"
Then create again new Procedure Note "<ProcedureName>" "<ProcedureNote>" 
And go to IPD and create an Appointment with mandatory fields
Then fill Admission Form and create new Oprative form
Then validate created Medication List should display in Surgical Note tab under Operative Form "<ProcedureName>"

Examples:
|ProcedureName1 | ProcedureNote1 | ProcedureName |ProcedureNote |
|Test Procedure | Test Note      | Biswajit Note | Biswajit Note|


@VerifyOpthalSets
Scenario Outline: Opthal Sets under Clinical
And clicks on Clinical from the left panel menu 
Then click on Opthal Sets and validate each tab
When create Opthal Lab Set "<SetName1>" 
Then verify created Opthal Set name should display in Procedure Notes "<SetName>"
When user deleted that Opthal Set name its should not display under template "<SetName>"
#Then create again new Opthal Set "<SetName>" 
Then navigate to OPD and create one Appointment
When mark patient as Arrived go to Investigation tab under Eye Template 
Then validate created Opthal Set should display in Investigation tab under Eye Template "<SetName>"
Then validate created Opthal Set should display in Investigation tab under QuickEye Template "<SetName>"
Then validate created Opthal Set should display in Investigation tab under Lens Template "<SetName>"
Then validate created Opthal Set should display in Investigation tab under Pediatrics Template "<SetName>"
Then validate created Opthal Set should display in Investigation tab under OrthopticsTemplate "<SetName>"
Then validate created Opthal Set should display in Investigation tab under Trauma  Template "<SetName>"
Then validate created Opthal Set should display in Investigation tab under Free Form Template "<SetName>"

Examples:
|SetName1        | SetName                  | 
|Opthal Set Test | Biswajit Opthal Set      |


@VerifyRadiologySets
Scenario Outline: Radiology Sets under Clinical
And clicks on Clinical from the left panel menu 
Then click on Radilogy Sets and validate each tab
When create Radiology Set "<SetName1>" 
Then verify created Radiology Set name should display in Radiology Lab Sets "<SetName1>"
When user deleted that Radiology Set name its should not display in Radiology Lab Sets "<SetName1>"
Then create again new Radiology Set "<SetName>" 
Then navigate to OPD and create one Appointment
When mark patient as Arrived go to Investigation tab under Eye Template 
Then validate created Radiology Set should display in Investigation tab under Eye Template "<SetName>"
#Then validate created Radiology Set should display in Investigation tab under QuickEye Template "<SetName>"
#Then validate created Radiology Set should display in Investigation tab under Lens Template "<SetName>"
#Then validate created Radiology Set should display in Investigation tab under Pediatrics Template "<SetName>"
#Then validate created Radiology Set should display in Investigation tab under OrthopticsTemplate "<SetName>"
#Then validate created Radiology Set should display in Investigation tab under Trauma  Template "<SetName>"
#Then validate created Radiology Set should display in Investigation tab under Free Form Template "<SetName>"

Examples:
|SetName1           | SetName               | 
|Radiology Set Test | Biswajit Radiology Set|
