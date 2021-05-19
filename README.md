#WalletHubCucumberSelenium

1. Both the Assignments are present in the same project. This project is integrated with Cucumber and each assignment is present as a feature file in the location src/test/resources/feature as follows:

	Assignment 1 - facebook.feature
	Assignment 2 - wallethub.feature

2. This project supports 3 browsers - Chrome, Firefox and Egde. In each feature file the browsers are present in the Examples section. In case you need to run on a specific browser, comment out the other browsers by adding a prefix "#"
	Example- If you want to run only on Chrome:
	  | browser |
      | Chrome  |
      #| Firefox |
      #| Edge    |
	  
3. To run the project, we need Java and Maven installed on the system (Should be a Windows machine).
	
4. Use the following commands in a cli to run the project(cli should be initiated from project root):
	i. mvn clean install  											//This command is to run all the two assignments
	ii. mvn clean install -DCucumber.Options="--tags @facebook"  	//This command is to run Assignment 1
	iii. mvn clean install -DCucumber.Options="--tags @wallethub"	//This command is to run Assignment 2
	
5. Enter your facebook username and password inside the respective inverted commas in the facebook.feature file on line number 7.

6. Replace your newly created WalletHub emailId and password in the examples section of the wallethub.feature file starting from line number 25.
	Example-
      | Chrome  | <Your desired email Id 1> | <Your desired password 1> |
      | Firefox | <Your desired email Id 2> | <Your desired password 2> |
      | Edge    | <Your desired email Id 3> | <Your desired password 3> |
