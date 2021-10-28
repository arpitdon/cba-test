# cba-test
Codility Test for Commonwealth Bank of Australia

This is a maven based framework which is configured for MacOS with surefire plugin to execute Test Cases from testng.xml.

In order to execute test cases just use below command in terminal - mvn clean test

OR

Execute following maven goals from IDE - clean test

Browsers can be configured by passing value as a parameter in testng.xml file.

Reports will be generated in form of testng reports at the below path - 

target/surefire-reports/index.html

Execution reports can be found in the repository under the name surefire-reports.zip
