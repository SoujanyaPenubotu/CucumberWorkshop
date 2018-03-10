Feature: Validate if user is able to edit Contact Details


Scenario: As per the given user story , validate if user is able to edit Contact Details and  updated details are saved successfully

Given Login to Application with valid credentials

And Navigate to My Info Page

Then Navigate to Contact Details Page

Then Edit contact details and verify the success message and verify that saved fields are disabled 
|AddressLine11|AddressLine12|Hyderabad1|Telangana1|500051|Germany|04023457111|8753456111|7653478111|testemail11@gmail.com|test11@gmail.com|
|AddressLine21|AddressLine22|Hyderabad2|Telangana2|500052|France|04023457222|8753456222|7653478222|testemail22@gmail.com|test22@gmail.com|
|AddressLine31|AddressLine32|Hyderabad3|Telangana3|500053|Egypt|04023457333|8753456333|7653478333|testemail33@gmail.com|test33@gmail.com|
|AddressLine41|AddressLine32|Hyderabad4|Telangana4|500054|India|04023457654|8753456098|7653478987|testemail44@gmail.com|test44@gmail.com|

Then Logout of the Application