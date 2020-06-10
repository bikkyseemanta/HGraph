$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/Add_Patient_For_OPD.feature");
formatter.feature({
  "line": 1,
  "name": "Create Appointment for OPD",
  "description": "",
  "id": "create-appointment-for-opd",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Create Appointment for OPD by adding New Patient",
  "description": "",
  "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@PatientDetails"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user fills \"\u003cuname\u003e\" and \"\u003cpswd\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "clicks on Login",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user can view dashboard",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "click on Add button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User should see a modal having the header \"Search Patient or Add New Patient\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Validate all the fields contains in add_new_patient modal",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "click on Add New Patient button",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 12,
      "value": "#Then User should see a modal having the header \"Patient Registration \u0026 Appointment Form\""
    }
  ],
  "line": 13,
  "name": "Modal must have below mentioned tabs",
  "rows": [
    {
      "cells": [
        "Patient Details"
      ],
      "line": 14
    },
    {
      "cells": [
        "Other Details"
      ],
      "line": 15
    },
    {
      "cells": [
        "History"
      ],
      "line": 16
    },
    {
      "cells": [
        "Allergies"
      ],
      "line": 17
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "user without filling mandatory field and click on Appointment button",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "validate warning message should display",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "user fill mandatory fields \"\u003cfname\u003e\" \"\u003cmobNo\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "click on Add button",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "click on Add New Patient button",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "fill patient details  \"\u003cfirstname1\u003e\" \"\u003cmobno1\u003e\" \"\u003cmiddlename\u003e\" \"\u003clastname\u003e\" \"\u003csecondaryno\u003e\" \"\u003cemail\u003e\" \"\u003clanguage\u003e\" \"\u003csecondarylanguage\u003e\" \"\u003cpincode\u003e\" \"\u003cAdd1\u003e\" \"\u003cAdd2\u003e\" \"\u003cMedicalRepoNo\u003e\" \"\u003cAadhaar\u003e\" \"\u003cPANno\u003e\" \"\u003cDLno\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 26,
  "name": "",
  "description": "",
  "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient;",
  "rows": [
    {
      "cells": [
        "uname",
        "pswd",
        "fname",
        "mobNo",
        "firstname1",
        "mobno1",
        "middlename",
        "lastname",
        "secondaryno",
        "email",
        "language",
        "secondarylanguage",
        "pincode",
        "Add1",
        "Add2",
        "MedicalRepoNo",
        "Aadhaar",
        "PANno",
        "DLno",
        "DoctorReferal",
        "DrName",
        "DRMobNo",
        "DrEmail",
        "DRSpecialist",
        "Drlocation",
        "Drcity",
        "DrState",
        "DrComments",
        "staffreferal",
        "relative",
        "relativename",
        "relativemobno",
        "relativeemail",
        "relation",
        "comment",
        "campaign",
        "camp",
        "InstitutionalReferral",
        "Agent",
        "Online",
        "ThirdParty",
        "self",
        "EmergencyName",
        "EmergencyContact"
      ],
      "line": 27,
      "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient;;1"
    },
    {
      "cells": [
        "hgdummyrec",
        "HGraph@2$2$",
        "Bikky",
        "4678907665",
        "Selenium",
        "9861929608",
        "Automation",
        "Test",
        "7751996482",
        "bswjttripathy@gmail.com",
        "Hindi",
        "English",
        "5600",
        "keruna",
        "chatrapada",
        "MRN1",
        "30965893118",
        "ANMPT2557J",
        "OR68310567",
        "Doctor Referal",
        "Automation Test",
        "88008248940",
        "bki@gmail.com",
        "Medicine Specilist",
        "Marathalli",
        "Bangalore",
        "Karnataka",
        "Test",
        "staffreferal",
        "Relative",
        "Test1",
        "5773437887",
        "Test@gmail.com",
        "Tester",
        "Test",
        "campaign",
        "camp",
        "InstitutionalReferral",
        "Agent",
        "Online",
        "ThirdParty",
        "self",
        "AutTest",
        "AutoTest"
      ],
      "line": 28,
      "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9599996000,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "Create Appointment for OPD by adding New Patient",
  "description": "",
  "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@PatientDetails"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user fills \"hgdummyrec\" and \"HGraph@2$2$\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "clicks on Login",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user can view dashboard",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "click on Add button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User should see a modal having the header \"Search Patient or Add New Patient\"",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Validate all the fields contains in add_new_patient modal",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "click on Add New Patient button",
  "keyword": "Then "
});
formatter.step({
  "comments": [
    {
      "line": 12,
      "value": "#Then User should see a modal having the header \"Patient Registration \u0026 Appointment Form\""
    }
  ],
  "line": 13,
  "name": "Modal must have below mentioned tabs",
  "rows": [
    {
      "cells": [
        "Patient Details"
      ],
      "line": 14
    },
    {
      "cells": [
        "Other Details"
      ],
      "line": 15
    },
    {
      "cells": [
        "History"
      ],
      "line": 16
    },
    {
      "cells": [
        "Allergies"
      ],
      "line": 17
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "user without filling mandatory field and click on Appointment button",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "validate warning message should display",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "user fill mandatory fields \"Bikky\" \"4678907665\"",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "click on Add button",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "click on Add New Patient button",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "fill patient details  \"Selenium\" \"9861929608\" \"Automation\" \"Test\" \"7751996482\" \"bswjttripathy@gmail.com\" \"Hindi\" \"English\" \"5600\" \"keruna\" \"chatrapada\" \"MRN1\" \"30965893118\" \"ANMPT2557J\" \"OR68310567\"",
  "matchedColumns": [
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11,
    12,
    13,
    14,
    15,
    16,
    17,
    18
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "hgdummyrec",
      "offset": 12
    },
    {
      "val": "HGraph@2$2$",
      "offset": 29
    }
  ],
  "location": "Steps.user_fills_and(String,String)"
});
formatter.result({
  "duration": 633530400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.clicks_on_Login()"
});
formatter.result({
  "duration": 1515972300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_can_view_dashboard()"
});
formatter.result({
  "duration": 12330000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_button()"
});
formatter.result({
  "duration": 248196300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Search Patient or Add New Patient",
      "offset": 43
    }
  ],
  "location": "Steps.user_should_see_a_modal_having_the_header(String)"
});
formatter.result({
  "duration": 613781300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.validate_all_the_fields_contains_in_add_new_patient_modal()"
});
formatter.result({
  "duration": 20700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_New_Patient_button()"
});
formatter.result({
  "duration": 86361800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.modal_must_have_below_mentioned_tabs(DataTable)"
});
formatter.result({
  "duration": 25821700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_without_filling_mandatory_field_and_click_on_Appointment_button()"
});
formatter.result({
  "duration": 946470600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.validate_warning_message_should_display()"
});
formatter.result({
  "duration": 38360900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Bikky",
      "offset": 28
    },
    {
      "val": "4678907665",
      "offset": 36
    }
  ],
  "location": "Steps.user_fill_mandatory_fields(String,String)"
});
formatter.result({
  "duration": 548172500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_can_create_Appointment()"
});
formatter.result({
  "duration": 218915700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_button()"
});
formatter.result({
  "duration": 194388000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_New_Patient_button()"
});
