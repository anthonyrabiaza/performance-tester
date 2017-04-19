# Performance Tester

MuleSoft project to run:
- performance test on server (CloudHub or On-Premises)
- execute remote command (CloudHub or On-Premises)
- forward Logger activity to Splunk HTTP Event Collector

### Performance

Call the process as-is using GET or POST, default port is 8898

### Remote command

use "command" HTTP header with command, for example "ls -l"

### Splunk

1. Enable HTTP Event Collector first

![Alt text](src/main/resources/1-Global_Setting.png?raw=true "Global Setting")

2. Create a token

![Alt text](src/main/resources/2-HTTP_Collector_Token.png?raw=true "Create token")

3. Update log4j.xml to put the correct hostname and token