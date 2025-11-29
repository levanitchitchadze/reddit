
# Reddit Test Automation 

It's a mini project for Reddit automation.


# Installation

**❗ You need to have JDK 21, Android SDK, and Appium on your computer.**

copy url from git repository 

git clone https://github.com/levanitchitchadze/reddit.git

cd reddit 


### Run project
run project with

$: `mvn clean test -Ptestng`

or

$: `mvn clean test -Pcucumber`


# project layout scheme
```
reddit/
│
├── apk/
│   └── reddit.apk      //Apk file for testing
│
├── cucumber-reports/   //Cucumber reports save here 
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── drivers/                //drivers section
│       │   │   └── DriverManager        
│       │   │
│       │   ├── hooks/                  //Cucumber hooks for set up environment
│       │   │   └── Hooks
│       │   │
│       │   ├── pages/                  //page classes (POM) 
│       │   │   └── LoginPage
│       │   │
│       │   ├── runners/                //Runner classes for cucumber 
│       │   │   └── CucumberRunner
│       │   │
│       │   ├── steps/
│       │   │   ├── LoginSteps          //Step definitions 
│       │   │   ├── ProfileSteps
│       │   │   └── SearchSteps
│       │   │
│       │   └── utils/                  //Widely used tools
│       │       └── ReadPropertyFile
│       │
│       └── resources/
│           ├── features/               //Cucumber scenarios 
│           │   ├── login.feature
│           │   ├── profile.feature
│           │   └── search.feature
│           │
│           └── config.properties       //Project properties and test data
│ 
├── .gitignore
├── pom.xml
├── reddit.iml
├── testng.xml
└── README.md

```## Color Reference

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Example Color | ![#0a192f](https://via.placeholder.com/10/0a192f?text=+) #0a192f |
| Example Color | ![#f8f8f8](https://via.placeholder.com/10/f8f8f8?text=+) #f8f8f8 |
| Example Color | ![#00b48a](https://via.placeholder.com/10/00b48a?text=+) #00b48a |
| Example Color | ![#00d1a0](https://via.placeholder.com/10/00b48a?text=+) #00d1a0 |

