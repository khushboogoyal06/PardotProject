# PardotProject

###Project Overview
Log in to Pardot (https://pi.pardot.com, Username: pardot.applicant@pardot.com, Password: Applicant2012)  
Create a list with a random name (Marketing > Segmentation > Lists)  
Attempt to create another list with that same name and ensure the system correctly gives a validation failure  
Rename the original list  
Ensure the system allows the creation of another list with the original name now that the original list is renamed  
Create a new prospect (Prospect > Prospect List)    
Add your new prospect to the newly created list    
Ensure the new prospect is successfully added to the list upon save  
Send a text only email to the list (Marketing > Emails)  *Please note, email is disabled in this account so you will not actually be
able to send the email.  This is okay.  
Log out  

---

###Project source can be downloaded from 
https://github.com/khushboogoyal06/PardotProject

---


###Author
Khushboo Goyal

---

###File List

.settings  
bin  
build  
report  
src  
Supported Jars  
.classpath  
.project  
build  
Salesforce  

---

###Pre requisite
Eclipse should be installed in your system  
firefox browser should be used to run this project  

---
###How to run file
Open Eclipse  
Import the project downloaded from GITHUB to your workspace in Eclipse  
Import all the jar files present in "Supported Jars" folder to your project  
Go to project src->test,Right click "SuiteRunner.java" and Run as JUNIT test        
Do not touch the mouse when the project is running as JUNIT  

---
###NOTE
If you want to repeat the test,change the data in Suite1.xlsx file from your windows machine which is present in src->Config folder inside the project



