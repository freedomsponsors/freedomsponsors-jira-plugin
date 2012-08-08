This is the FreedomSponsors "SponsorThis" plugin for JIRA.

When installed, it will add a nice, discrete "Sponsor this" section on your JIRA's issue view, like the screenshot below.

![SponsorThis](http://freedomsponsors.github.com/freedomsponsors-jira-plugin/screenshot.png)

To install it, just get the latest version jar from the [download section](https://github.com/freedomsponsors/freedomsponsors-jira-plugin/downloads) and upload to your JIRA using the plugin management feature.

If you're developer, and for some reason want to build it yourself, here's a few pointers:

## Get the plugin SDK from Atlassian
https://developer.atlassian.com/display/DOCS/Set+up+the+Atlassian+Plugin+SDK+and+Build+a+Project

After you have the plugin installed, you'll want to run:

``` shell
atlas-mvn clean install
```

Depending on yor environment, that command might fail because maven won't find jta.jar on your local repository.
That's because jta is not on the maven central repository. But it can be found on the [java.net repository](http://download.java.net/maven/2).

Add this section to your maven settings.xml file:

``` xml
<activeProfiles>
  <!-- other profiles you might have -->
  <activeProfile>outrosrepos</activeProfile>
</activeProfiles>

<profiles>
  <!-- other profiles you might have -->
  <profile>
  	<id>outrosrepos</id>
    <repositories>
		<repository>
			<id>Java.net</id>
			<name>Java.net</name>
			<releases>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
				<checksumPolicy>warn</checksumPolicy>
			</releases>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>never</updatePolicy>
				<checksumPolicy>fail</checksumPolicy>
			</snapshots>
			<url>http://download.java.net/maven/2</url>
			<layout>default</layout>
		</repository>
	</repositories>
  </profile>
</profiles>
```

Try again and see if it works this time.

If you can build it, here are a few other SDK commands you'll want to use:

* atlas-run   -- installs this plugin into JIRA and starts it on http://localhost:2990/jira (login/pass = admin/admin)
* atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005
* atlas-cli   -- after atlas-run or atlas-debug, opens a Maven command line window:
                 - 'pi' reinstalls the plugin into the running JIRA instance
* atlas-help  -- prints description for all commands in the SDK


Full documentation is available at:

https://developer.atlassian.com/display/DOCS/Developing+with+the+Atlassian+Plugin+SDK