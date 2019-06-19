# Javalin Server

Simple Javalin API running as service in Linux OS

## Getting Started

These project is a simple API written in Java using Maven and Javalin, a lightweight and simple web framework
for Java and Kotlin

### Prerequisites

What you need

```
Linux OS (CentOS, Ubuntu)
Java JDK 1.8 
Maven Command Line
```

## Running the application (standalone)

Once cloned the repo you can run it doing these steps:
```
* Compile maven project by command mvn clean install
* Launching executable .jar file by command java -jar javalinserver-1.0.0-jar-with-dependencies
```

## Configuring the application (Linux service)
A Linux service is a kind of process not associated with Terminal or GUI that runs in background to provide functionality to the users.
Let's how to create a new service in Linux and linking our jar file
```
First create a new group and a new user that will be able to run the service
* sudo groupadd -r backendgroup
* sudo useradd -r -s /bin/false -g backendgroup backendapps

Then create a new service in /etc/systemd
* sudo nano /etc/systemd/system/javalin.service

The content of javalin.service will be the following:
  [Unit]
  Description=My JAVALIN API running as service

  [Service]
  WorkingDirectory=/opt/production/server
  ExecStart=/opt/production/server/run.sh
  User=backendapps
  Type=simple
  SuccessExitStatus=143S
  TimeoutStopSec=10
  Restart=on-failure
  RestartSec=5
  [Install]
  WantedBy=multi-user.target
  
Copy the jar previously created in the right folder (in this case /opt/production/server) and give it the right permissions
* sudo chown -R backendapps:backendgroup /opt/production/
* sudo chmod +x /opt/production/server/run.sh
```

## Running the application 
Now the service is ready to run:  first reload systemd so that it knows of the new application added.
```
sudo systemctl daemon-reload
```
Once reloaded start the service
```
sudo systemctl start javalin.service
```
Useful commands
```
sudo systemctl status javalin.service: check the status of the service
sudo systemctl restart javalin.service: restart the service
sudo systemctl stop javalin.service: stop the service
```

## Authors

* **Nicola Dileo** - [Github](https://nicoladileo.github.io)

