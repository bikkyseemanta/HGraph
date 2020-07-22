$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/OutPatient.feature");
formatter.feature({
  "line": 1,
  "name": "Verify Patient Details in OPD Page",
  "description": "",
  "id": "verify-patient-details-in-opd-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Verification of Out patient department",
  "description": "",
  "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@PatientDetailsVerification"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "fill patient details  \"\u003cuname\u003e\" \"\u003cpswd\u003e\" \"\u003cFirstname\u003e\" \"\u003cMobno\u003e\" \"\u003cLastname\u003e\" \"\u003cEmail\u003e\" \"\u003clanguage\u003e\" \"\u003cPincode\u003e\" \"\u003cRef\u003e\" \"\u003cHistoryComment\u003e\" \"\u003cGlaucomaHistory\u003e\" \"\u003cPenicillincomments\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "validate mobile field \"\u003cMobno\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;",
  "rows": [
    {
      "cells": [
        "uname",
        "pswd",
        "Firstname",
        "Mobno",
        "Lastname",
        "Email",
        "language",
        "Pincode",
        "Ref",
        "HistoryComment",
        "GlaucomaHistory",
        "Penicillincomments"
      ],
      "line": 13,
      "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;;1"
    },
    {
      "cells": [
        "hgdummyrec",
        "HGraph@2$2$",
        "Biswajit",
        "9861929608",
        "Tripathy",
        "bswjttripathy@gmail.com",
        "Hindi",
        "5600",
        "Self",
        "TestHistory",
        "DetailHistory",
        "AlgeryHistory"
      ],
      "line": 14,
      "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8630850600,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verification of Out patient department",
  "description": "",
  "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@PatientDetailsVerification"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "fill patient details  \"hgdummyrec\" \"HGraph@2$2$\" \"Biswajit\" \"9861929608\" \"Tripathy\" \"bswjttripathy@gmail.com\" \"Hindi\" \"5600\" \"Self\" \"TestHistory\" \"DetailHistory\" \"AlgeryHistory\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6,
    7,
    8,
    9,
    10,
    11
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "validate mobile field \"9861929608\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "hgdummyrec",
      "offset": 23
    },
    {
      "val": "HGraph@2$2$",
      "offset": 36
    },
    {
      "val": "Biswajit",
      "offset": 50
    },
    {
      "val": "9861929608",
      "offset": 61
    },
    {
      "val": "Tripathy",
      "offset": 74
    },
    {
      "val": "bswjttripathy@gmail.com",
      "offset": 85
    },
    {
      "val": "Hindi",
      "offset": 111
    },
    {
      "val": "5600",
      "offset": 119
    },
    {
      "val": "Self",
      "offset": 126
    },
    {
      "val": "TestHistory",
      "offset": 133
    },
    {
      "val": "DetailHistory",
      "offset": 147
    },
    {
      "val": "AlgeryHistory",
      "offset": 163
    }
  ],
  "location": "OPDVerify.fill_patient_details(String,String,String,String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 14621515200,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d84.0.4147.89)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027VICKYPC\u0027, ip: \u0027192.168.1.105\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027x86\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 84.0.4147.89, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\lenovo\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:58010}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 7c612dec6a39c02f59425a35e64403ba\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepDefinations.CommonSteps.fillpatientDetails(CommonSteps.java:73)\r\n\tat stepDefinations.OPDVerify.fill_patient_details(OPDVerify.java:30)\r\n\tat ✽.Then fill patient details  \"hgdummyrec\" \"HGraph@2$2$\" \"Biswajit\" \"9861929608\" \"Tripathy\" \"bswjttripathy@gmail.com\" \"Hindi\" \"5600\" \"Self\" \"TestHistory\" \"DetailHistory\" \"AlgeryHistory\"(./Features/OutPatient.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Steps.user_can_create_Appointment()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "9861929608",
      "offset": 23
    }
  ],
  "location": "OPDVerify.validate_mobile_field(String)"
});
formatter.result({
  "status": "skipped"
});
});