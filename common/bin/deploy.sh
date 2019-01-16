#!/usr/bin/env bash
# install mysql

# initial sql database

# install zookeeper
mv ZookeeperServer /home
# start service
sh ./start_service.sh

# protect service
sh ./protect_service.sh

# install tomcat

# deploy web api

# install nginx

# config nginx proxy