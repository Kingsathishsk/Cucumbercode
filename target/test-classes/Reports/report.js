$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Featurefile/login.feature");
formatter.feature({
  "name": "To validate the Login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "To verify login using valid and invalid credential",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user launch Facebook application",
  "keyword": "Given "
});
formatter.step({
  "name": "user enter \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "user click Login button",
  "keyword": "And "
});
formatter.step({
  "name": "user see the results based on \"\u003ccredentialType\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "credentialType"
      ]
    },
    {
      "cells": [
        "abc",
        "abc@123",
        "negative"
      ]
    }
  ]
});
formatter.scenario({
  "name": "To verify login using valid and invalid credential",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "user launch Facebook application",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginSteps.user_launch_Facebook_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enter \"abc\" and \"abc@123\"",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.user_enter_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.user_click_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user see the results based on \"negative\"",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_see_the_results_based_on(String)"
});
formatter.result({
  "status": "passed"
});
});