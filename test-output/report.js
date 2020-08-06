$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/OutPatient.feature");
formatter.feature({
  "line": 1,
  "name": "Verify Patient Details in OPD Page",
  "description": "",
  "id": "verify-patient-details-in-opd-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 14,
  "name": "Patient Details Verification through Doctor login",
  "description": "",
  "id": "verify-patient-details-in-opd-page;patient-details-verification-through-doctor-login",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@PatientDetailsVerificationThroughDoctor"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "doctor login \"\u003cuname\u003e\" and \"\u003cpswd\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Doctor verify some details of patient",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "Doctor create Optom Template \"\u003cComment1\u003e\" \"\u003cComment2\u003e\" \"\u003cComment3\u003e\" \"\u003cComment4\u003e\" \"\u003cComment5\u003e\" \"\u003cComment6\u003e\" \"\u003cinput\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Doctor fills Auto Refraction values",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Doctor fills Dry Refraction values \"\u003cdrycomment\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Doctor fills Refraction dialated values \"\u003cdiacomment\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Doctor fills PGP values",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "Doctor fills Glasses prescription \"\u003cGlassAdvice\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Doctor fills Intermediate Glasses prescription \"\u003cIntGlassAdvice\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Doctor fills PMT",
  "keyword": "Then "
});
formatter.examples({
  "line": 26,
  "name": "",
  "description": "",
  "id": "verify-patient-details-in-opd-page;patient-details-verification-through-doctor-login;",
  "rows": [
    {
      "cells": [
        "uname",
        "pswd",
        "name",
        "input",
        "Comment1",
        "Comment2",
        "Comment3",
        "Comment4",
        "Comment5",
        "Comment6"
      ],
      "line": 28,
      "id": "verify-patient-details-in-opd-page;patient-details-verification-through-doctor-login;;1"
    },
    {
      "cells": [
        "hgdummydoc",
        "HGraph@2$2$",
        "Test Automation",
        "50",
        "Opthalmic Comments",
        "Opthal History",
        "Systemic History",
        "Medical History",
        "Family History",
        "Other Comments"
      ],
      "line": 29,
      "id": "verify-patient-details-in-opd-page;patient-details-verification-through-doctor-login;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 9449884000,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Patient Details Verification through Doctor login",
  "description": "",
  "id": "verify-patient-details-in-opd-page;patient-details-verification-through-doctor-login;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@PatientDetailsVerificationThroughDoctor"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "doctor login \"hgdummydoc\" and \"HGraph@2$2$\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Doctor verify some details of patient",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "Doctor create Optom Template \"Opthalmic Comments\" \"Opthal History\" \"Systemic History\" \"Medical History\" \"Family History\" \"Other Comments\" \"50\"",
  "matchedColumns": [
    3,
    4,
    5,
    6,
    7,
    8,
    9
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "Doctor fills Auto Refraction values",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Doctor fills Dry Refraction values \"\u003cdrycomment\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Doctor fills Refraction dialated values \"\u003cdiacomment\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Doctor fills PGP values",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "Doctor fills Glasses prescription \"\u003cGlassAdvice\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 23,
  "name": "Doctor fills Intermediate Glasses prescription \"\u003cIntGlassAdvice\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Doctor fills PMT",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "hgdummydoc",
      "offset": 14
    },
    {
      "val": "HGraph@2$2$",
      "offset": 31
    }
  ],
  "location": "OPDVerify.doctor_login_and(String,String)"
});
formatter.result({
  "duration": 1988257100,
  "status": "passed"
});
formatter.match({
  "location": "OPDVerify.doctor_verify_some_details_of_patient()"
});
formatter.result({
  "duration": 465018000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Opthalmic Comments",
      "offset": 30
    },
    {
      "val": "Opthal History",
      "offset": 51
    },
    {
      "val": "Systemic History",
      "offset": 68
    },
    {
      "val": "Medical History",
      "offset": 87
    },
    {
      "val": "Family History",
      "offset": 105
    },
    {
      "val": "Other Comments",
      "offset": 122
    },
    {
      "val": "50",
      "offset": 139
    }
  ],
  "location": "OPDVerify.doctor_create_Optom_Template(String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 3560813700,
  "status": "passed"
});
formatter.match({
  "location": "OPDVerify.doctor_fills_Auto_Refraction_values()"
});
formatter.result({
  "duration": 3747063100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cdrycomment\u003e",
      "offset": 36
    }
  ],
  "location": "OPDVerify.doctor_fills_Dry_Refraction_values(String)"
});
formatter.result({
  "duration": 1206316600,
  "error_message": "org.openqa.selenium.ElementNotInteractableException: element not interactable\n  (Session info: chrome\u003d84.0.4147.105)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027VICKYPC\u0027, ip: \u0027192.168.1.107\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027x86\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_251\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 84.0.4147.105, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\lenovo\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:63556}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 9342c5d18335e9638b504954a56277c6\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:285)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:84)\r\n\tat stepDefinations.OPDVerify.doctor_fills_Dry_Refraction_values(OPDVerify.java:432)\r\n\tat ✽.Then Doctor fills Dry Refraction values \"\u003cdrycomment\u003e\"(./Features/OutPatient.feature:19)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cdiacomment\u003e",
      "offset": 41
    }
  ],
  "location": "OPDVerify.doctor_fills_Refraction_dialated_values(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OPDVerify.doctor_fills_PGP_values()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cGlassAdvice\u003e",
      "offset": 35
    }
  ],
  "location": "OPDVerify.doctor_fills_Glasses_prescription(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "\u003cIntGlassAdvice\u003e",
      "offset": 48
    }
  ],
  "location": "OPDVerify.doctor_fills_Intermediate_Glasses_prescription(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OPDVerify.doctor_fills_PMT()"
});
formatter.result({
  "status": "skipped"
});
});