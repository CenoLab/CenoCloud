#!/usr/bin/env bash

facades=('log' 'data' 'alarm' 'balance' 'app' 'sso' 'forum')
services=('app' 'sso' 'control' 'data' 'alarm' 'forum')

echo "   _____                  _____ _                 _    _____                 _           "
echo "  / ____|                / ____| |               | |  / ____|               (_)          "
echo " | |     ___ _ __   ___ | |    | | ___  _   _  __| | | (___   ___ _ ____   ___  ___ ___  "
echo " | |    / _ \ '_ \ / _ \| |    | |/ _ \| | | |/ _. |  \___ \ / _ \ '__\ \ / / |/ __/ _ \ "
echo " | |___|  __/ | | | (_) | |____| | (_) | |_| | (_| |_ ____) |  __/ |   \ V /| | (_|  __/ "
echo "  \_____\___|_| |_|\___/ \_____|_|\___/ \__,_|\__,_(_)_____/ \___|_|    \_/ |_|\___\___| "
echo ""
echo "FINDING SERVICE!"
echo ""


for facade in ${facades[@]}
do
    echo "facade_${facade}---------------------------------------------find!"
    ps -elf | grep facade_${facade}
done

for service in ${services[@]}
do
   echo "service_${service}-----------------------------------------------find!"
    ps -elf | grep service_${service}
done



