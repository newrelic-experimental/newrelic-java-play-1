
<a href="https://opensource.newrelic.com/oss-category/#new-relic-experimental"><picture><source media="(prefers-color-scheme: dark)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/dark/Experimental.png"><source media="(prefers-color-scheme: light)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"><img alt="New Relic Open Source experimental project banner." src="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"></picture></a>

![GitHub forks](https://img.shields.io/github/forks/newrelic-experimental/newrelic-java-play-1?style=social)
![GitHub stars](https://img.shields.io/github/stars/newrelic-experimental/newrelic-java-play-1?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/newrelic-experimental/newrelic-java-play-1?style=social)

![GitHub all releases](https://img.shields.io/github/downloads/newrelic-experimental/newrelic-java-play-1/total)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/newrelic-experimental/newrelic-java-play-1)
![GitHub last commit](https://img.shields.io/github/last-commit/newrelic-experimental/newrelic-java-play-1)
![GitHub Release Date](https://img.shields.io/github/release-date/newrelic-experimental/newrelic-java-play-1)


![GitHub issues](https://img.shields.io/github/issues/newrelic-experimental/newrelic-java-play-1)
![GitHub issues closed](https://img.shields.io/github/issues-closed/newrelic-experimental/newrelic-java-play-1)
![GitHub pull requests](https://img.shields.io/github/issues-pr/newrelic-experimental/newrelic-java-play-1)
![GitHub pull requests closed](https://img.shields.io/github/issues-pr-closed/newrelic-experimental/newrelic-java-play-1)


# New Relic Java Instrumentation for the Play 1.x Framework

Provides instrumentation for the Play 1.x Framework

## Installation

To use this instrumentation.   
1. Download the latest release.    
2. In the New Relic Java Agent directory (directory containing newrelic.jar), create a directory named extensions if it doe not already exist.   
3. Copy the jars into the extensions directory.   
4. Restart the application.   
  
## Recommended Additional Instrumentation  
In order to capture the asynchronous behavior in the Play 1.x framework, it is recommended that you also include the Java Executors instrumentation that is available in the New Relic Experimental Repository: https://github.com/newrelic-experimental/newrelic-java-executors   
   
## Getting Started

After restarting the application, you should see transaction names based on the Controller class name and action name.  As well you should start to capture asynchronous behavior.   

## Usage

The calls will show up under Databases as Aerospike

## Building

If you make changes to the instrumentation code and need to build the instrumentation jars, follow these steps
1. Set environment variable NEW_RELIC_EXTENSIONS_DIR.  Its value should be the directory where you want to build the jars (i.e. the extensions directory of the Java Agent).   
2. Build one or all of the jars.   
a. To build one jar, run the command:  gradlew _moduleName_:clean  _moduleName_:install    
b. To build all jars, run the command: gradlew clean install
3. Restart the application
    
## Support

New Relic hosts and moderates an online forum where customers can interact with New Relic employees as well as other customers to get help and share best practices. Like all official New Relic open source projects, there's a related Community topic in the New Relic Explorers Hub. You can find this project's topic/threads here:



## Contributing
We encourage your contributions to improve [project name]! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project.
If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company,  please drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).   

## License
[Project Name] is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.
>[If applicable: The [project name] also uses source code from third-party libraries. You can find full details on which libraries are used and the terms under which they are licensed in the third-party notices document.]
