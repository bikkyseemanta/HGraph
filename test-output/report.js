$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./Features/OutPatient.feature");
formatter.feature({
  "line": 1,
  "name": "Verify Patient Details in OPD Page",
  "description": "",
  "id": "verify-patient-details-in-opd-page",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 11,
  "name": "Verification of Out patient department",
  "description": "",
  "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 10,
      "name": "@PatientDetailsVerification"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "fill patient details  \"\u003cFirstname\u003e\" \"\u003cMobno\u003e\" \"\u003cLastname\u003e\" \"\u003cEmail\u003e\" \"\u003clanguage\u003e\" \"\u003cPincode\u003e\" \"\u003cRef\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "clicks on Other Details tab select One Eyed",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "select special status",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "select history details \"\u003cHistoryComment\u003e\" \"\u003cGlaucomaHistory\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "select algeries details \"\u003cPenicillincomments\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.examples({
  "line": 20,
  "name": "",
  "description": "",
  "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;",
  "rows": [
    {
      "cells": [
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
      "line": 21,
      "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;;1"
    },
    {
      "cells": [
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
      "line": 22,
      "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8326490300,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user fills \"hgdummyrec\" and \"HGraph@2$2$\"",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "clicks on Login",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "user can view dashboard",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "click on Add button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "click on Add New Patient button",
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
  "duration": 453688000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.clicks_on_Login()"
});
formatter.result({
  "duration": 1248143300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.user_can_view_dashboard()"
});
formatter.result({
  "duration": 10044700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_button()"
});
formatter.result({
  "duration": 3754563600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.click_on_Add_New_Patient_button()"
});
formatter.result({
  "duration": 694579000,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Verification of Out patient department",
  "description": "",
  "id": "verify-patient-details-in-opd-page;verification-of-out-patient-department;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 10,
      "name": "@PatientDetailsVerification"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "fill patient details  \"Biswajit\" \"9861929608\" \"Tripathy\" \"bswjttripathy@gmail.com\" \"Hindi\" \"5600\" \"Self\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4,
    5,
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "clicks on Other Details tab select One Eyed",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "select special status",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "select history details \"TestHistory\" \"DetailHistory\"",
  "matchedColumns": [
    7,
    8
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "select algeries details \"AlgeryHistory\"",
  "matchedColumns": [
    9
  ],
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "user can create Appointment",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Biswajit",
      "offset": 23
    },
    {
      "val": "9861929608",
      "offset": 34
    },
    {
      "val": "Tripathy",
      "offset": 47
    },
    {
      "val": "bswjttripathy@gmail.com",
      "offset": 58
    },
    {
      "val": "Hindi",
      "offset": 84
    },
    {
      "val": "5600",
      "offset": 92
    },
    {
      "val": "Self",
      "offset": 99
    }
  ],
  "location": "OPDverify.fill_patient_details(String,String,String,String,String,String,String)"
});
formatter.result({
  "duration": 228900,
  "error_message": "cucumber.runtime.CucumberException: class stepDefinations.OPDverify doesn\u0027t have an empty constructor. If you need DI, put cucumber-picocontainer on the classpath\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:45)\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.getInstance(DefaultJavaObjectFactory.java:33)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:127)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:26)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:86)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:538)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:760)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:460)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:206)\r\nCaused by: java.lang.NoSuchMethodException: stepDefinations.OPDverify.\u003cinit\u003e()\r\n\tat java.lang.Class.getConstructor0(Unknown Source)\r\n\tat java.lang.Class.getConstructor(Unknown Source)\r\n\tat cucumber.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:40)\r\n\t... 50 more\r\n",
  "status": "failed"
});
formatter.match({
  "location": "OPDverify.clicks_on_Other_Details_tab_select_One_Eyed()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "OPDverify.select_special_status()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "TestHistory",
      "offset": 24
    },
    {
      "val": "DetailHistory",
      "offset": 38
    }
  ],
  "location": "OPDverify.select_history_details(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "AlgeryHistory",
      "offset": 25
    }
  ],
  "location": "OPDverify.select_algeries_details(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Steps.user_can_create_Appointment()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 722513500,
  "status": "passed"
});
});