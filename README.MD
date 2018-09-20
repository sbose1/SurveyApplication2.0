
URL mapping:

the webportal is accessible at http://18.223.110.166:5000/index.html

with the credentials for admin 

uid-   admin@admin.com
pass-  admin

the repo contains webpages used for webportal at
/WebApp folder
and the library used in these files are kept in 
/content folder.

The mobile application code is stored in the 
/client_  folder



Mobile App

The mobile app should provide authentication, using a username and password mechanism. This app is only used by the patient role.
The mobile app should present the survey questions in the survey provided [Link (Links to an external site.)Links to an external site.]. The survey questions should be presented in a usable way to the user and should not be presented as a long list of questions. The user should be able to move from one screen to the other only when they answer the questions on the current app view. Your survey should provide validation to the user input and should alert the user when incorrect input is provided.
The user responses should be stored on the server and all communication with the server should be enabled through APIs.
In addition to the username/password authentication method, assuming the patient is at the clinic when they are logging into the app, and the admin is also in the clinic when they create the new user credentials.
Create an approach to pass on the user credentials or authentication information to the app other than giving the username and password to the patient. Your approach should not simply provide the user with the username and password on a piece of paper. You are allowed to use other communication channels that are available in on the phone.
The created approach should enable the admin role to pass on the user credentials to the a specific tablet for a specific user. The security of the approach is essential.
The app should also allow username and password in addition to your new approach.
Server Side

The server app should include a web site portal and web apis.
The web portal is only accessible by the admin role.
This portal should enable the admin to create and register new patients. The username and passwords of the new patients will be provided to the patients on check in.
List the patients in the system, you should consider using the DataTables (Links to an external site.)Links to an external site.Links to an external site. library.
Review patient survey responses and score the survey based on the survey scoring scale.
Create a printable report of the patient responses to the survey.
The web apis
Create all the apis needed for the mobile app authentication, and survey management.
After authentication a JWT token should be used to track and verify the authenticated user.
The api responses should be in JSON format.
