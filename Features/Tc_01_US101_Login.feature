Feature: Validate The E2E functionzlity of Login page

@Smoketest @Regression
Scenario: As per the user story US101(paste user story here), i need to validate the admin credentials with valid input data

Given Launch the firefox browser
And Enter URL
Then maximize the browser
When username is available enter the "valid" credentials

@Regression
Scenario: As per the user story US101(paste user story here), i need to validate the admin credentials with valid input data

Given Launch the firefox browser
And Enter URL
Then maximize the browser
When username is available enter the "invalid" credentials
