#!/usr/bin/env bash

# stop service
sudo sh stop_service.sh

# stop zookeeper server
sudo sh /home/node_01/bin/zkServer.sh stop

# wait for stop
sleep 5s

# start zookeeper
sudo sh /home/node_01/bin/zkServer.sh start

# create log directory
sudo mkdir log

# start service
sudo sh start_service.sh