#!/usr/bin/env bash

facades=('log' 'data' 'alarm' 'balance' 'app' 'sso' 'forum')
services=('app' 'sso' 'control' 'data' 'alarm' 'forum')

echo "    _____                  _____ _                 _    _____                 _           "
echo "   / ____|                / ____| |               | |  / ____|               (_)          "
echo "  | |     ___ _ __   ___ | |    | | ___  _   _  __| | | (___   ___ _ ____   ___  ___ ___  "
echo "  | |    / _ \ '_ \ / _ \| |    | |/ _ \| | | |/ _. |  \___ \ / _ \ '__\ \ / / |/ __/ _ \ "
echo "  | |___|  __/ | | | (_) | |____| | (_) | |_| | (_| |_ ____) |  __/ |   \ V /| | (_|  __/ "
echo "   \_____\___|_| |_|\___/ \_____|_|\___/ \__,_|\__,_(_)_____/ \___|_|    \_/ |_|\___\___| "
echo ""
echo "PROTECT SERVICE!"
echo ""

# facade initial and start
for facade in ${facades[@]}
do
    FACADE="facade_${facade}"
    echo "----------------------------------------------------------finding service $FACADE"
    FACADE_ID=`ps -ef | grep "$FACADE" | grep -v "$0" | grep -v "grep" | awk '{print $2}'`
    echo "----------------------------------------------------------protecting service $FACADE"
    for id in $FACADE_ID
    do
        echo -17 > /proc/${id}/oom_adj
	    echo "----------------------------------------------------------protected $id"
    done
    echo "----------------------------------------------------------protected service $FACADE"
done

# service initial and start
for service in ${services[@]}
do
    SERVICE="service_${service}"
    echo "----------------------------------------------------------finding service $SERVICE"
    SERVICE_ID=`ps -ef | grep "$SERVICE" | grep -v "$0" | grep -v "grep" | awk '{print $2}'`
    echo "----------------------------------------------------------protecting service $SERVICE"
    for id in $SERVICE_ID
    do
    	echo -17 > /proc/${id}/oom_adj
    	echo "----------------------------------------------------------protected $id"
    done
    echo "----------------------------------------------------------protected service $SERVICE"
done