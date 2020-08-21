# TestPhorest

Project Details -<br> <br> 
MainTest Class - 
TestPhorest.java in src/test

The test-run reports can be viewed [here](NGReportSS.png)
<br>And I have also attached the Report html files.





Running Information -

Clone this project from github
<br>
<b>This is a maven based project</b>

The test-suite can be run by using the below command -
 
<b>mvn clean test -Dtestng.dtd.http=true -DsuiteXmlFile=testng.xml</b>

<br>To run individual test cases, import this project to your IDE & in the run-vm options add this flag ->  -Dtestng.dtd.http=true
<br> <i>We have to add this flag because testNG, doesn't support insecure http URL calls otherwise.</i>

<br>
<h3>Email Verification</h3>
I'm using MailTrap.io, which is a free smtp server used for mail verification.
 <br>-  Once any of the success purchase flow is complete
<br> - Wait for 3 seconds
<br> - Login to the mailtrap server   
<br> - Click the inbox & look for received messages with appropriate subject lines & store in a list
<br> - Success if message list is of appropriate size. | Fo send_to_me 1 email & send_to_other 2 emails should be present.
<br> Test cases - test_email_was_delivered() & test_2_emails_delivered_on_gifting_to_other()