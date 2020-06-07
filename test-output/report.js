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
  "name": "open the browser and enter the URL \"https://ehr.healthgraph.in/users/login\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user fills \"\u003cuname\u003e\" and \"\u003cpswd\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "cliks on Login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user can view dashboard",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "EHR patient list page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "click on Add button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "click on Add New Patient button",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user without filling mandatory field and click on Appointment button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "validate warning message should display",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user fill mandatory fields \"\u003cfname\u003e\" \"\u003cmobNo\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "user clicks on the ADD button",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "User clicks on the add new patient button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Patient Registration \u0026 Appointment Form should display",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user fill patientdetails text info",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "user select patient details drop down info \"\u003cname\u003e\" \"\u003cprimarylaungage\u003e\" \"\u003csecondarylaungage\u003e\" \"\u003cpatienttype\u003e\" \"\u003cpatientrefsource\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "user select gender radio btn",
  "keyword": "And "
});
formatter.examples({
  "line": 23,
  "name": "",
  "description": "",
  "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient;",
  "rows": [
    {
      "cells": [
        "fname",
        "mobNo",
        "uname",
        "pswd",
        "name",
        "primarylaungage",
        "secondarylaungage",
        "patienttype",
        "patientrefsource"
      ],
      "line": 24,
      "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient;;1"
    },
    {
      "cells": [
        "Biswajit",
        "7795646804",
        "hgdummydoc",
        "HGraph@2$2$",
        "Mr.",
        "Hindi",
        "English",
        "VIP",
        "Self"
      ],
      "line": 25,
      "id": "create-appointment-for-opd;create-appointment-for-opd-by-adding-new-patient;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 25,
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
  "name": "open the browser and enter the URL \"https://ehr.healthgraph.in/users/login\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user fills \"hgdummydoc\" and \"HGraph@2$2$\"",
  "matchedColumns": [
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "cliks on Login",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user can view dashboard",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "EHR patient list page should display",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "click on Add button",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "click on Add New Patient button",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user without filling mandatory field and click on Appointment button",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "validate warning message should display",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user fill mandatory fields \"Biswajit\" \"7795646804\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "user clicks on the ADD button",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "User clicks on the add new patient button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Patient Registration \u0026 Appointment Form should display",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "user fill patientdetails text info",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "user select patient details drop down info \"Mr.\" \"Hindi\" \"English\" \"VIP\" \"Self\"",
  "matchedColumns": [
    4,
    5,
    6,
    7,
    8
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "user select gender radio btn",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "https://ehr.healthgraph.in/users/login",
      "offset": 36
    }
  ],
  "location": "Steps.open_the_browser_and_enter_the_URL(String)"
});
formatter.result({
  "duration": 10588162900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "hgdummydoc",
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
  "duration": 271772500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.cliks_on_Login()"
});
formatter.result({
  "duration": 1463523600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_can_view_dashboard()"
});
formatter.result({
  "duration": 34092500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.ehr_patient_list_page_should_display()"
});
formatter.result({
  "duration": 70461300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_button()"
});
formatter.result({
  "duration": 10232696400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_New_Patient_button()"
});
formatter.result({
  "duration": 5057606100,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_without_filling_mandatory_field_and_click_on_Appointment_button()"
});
formatter.result({
  "duration": 12250677400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.validate_warning_message_should_display()"
});
formatter.result({
  "duration": 114279100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Biswajit",
      "offset": 28
    },
    {
      "val": "7795646804",
      "offset": 39
    }
  ],
  "location": "Steps.user_fill_mandatory_fields(String,String)"
});
formatter.result({
  "duration": 372971600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_can_create_Appointment()"
});
formatter.result({
  "duration": 12110141900,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_clicks_on_the_ADD_button()"
});
formatter.result({
  "duration": 37600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_clicks_on_the_add_new_patient_button()"
});
formatter.result({
  "duration": 39500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.patient_Registration_Appointment_Form_should_display()"
});
formatter.result({
  "duration": 38000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_fill_patientdetails_text_info()"
});
formatter.result({
  "duration": 35600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Mr.",
      "offset": 44
    },
    {
      "val": "Hindi",
      "offset": 50
    },
    {
      "val": "English",
      "offset": 58
    },
    {
      "val": "VIP",
      "offset": 68
    },
    {
      "val": "Self",
      "offset": 74
    }
  ],
  "location": "Steps.user_select_patient_details_drop_down_info(String,String,String,String,String)"
});
formatter.result({
  "duration": 205800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_select_gender_radio_btn()"
});
formatter.result({
  "duration": 36500,
  "status": "passed"
});
});