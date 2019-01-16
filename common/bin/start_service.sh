#!/bin/sh

facades=('log' 'data' 'alarm' 'balance' 'app' 'sso' 'forum')
services=('app' 'sso' 'control' 'data' 'alarm' 'forum')

echo "     _____                  _____ _                 _    _____                 _           "
echo "    / ____|                / ____| |               | |  / ____|               (_)          "
echo "   | |     ___ _ __   ___ | |    | | ___  _   _  __| | | (___   ___ _ ____   ___  ___ ___  "
echo "   | |    / _ \ '_ \ / _ \| |    | |/ _ \| | | |/ _. |  \___ \ / _ \ '__\ \ / / |/ __/ _ \ "
echo "   | |___|  __/ | | | (_) | |____| | (_) | |_| | (_| |_ ____) |  __/ |   \ V /| | (_|  __/ "
echo "    \_____\___|_| |_|\___/ \_____|_|\___/ \__,_|\__,_(_)_____/ \___|_|    \_/ |_|\___\___| "
echo ""
echo "START SERVICE!"
echo ""

for facade in ${facades[@]}
do
    # clear .dsa .rsa .sf
    zip -d facade_${facade}_jar/facade_${facade}.jar 'META-INF/*.DSA' 'META-INF/*.RSA' 'META-INF/*.SF'
    echo "${facade}_log cleared!-------------------------------------------------------ok!";
    # start facade
    nohup sudo java -jar facade_${facade}_jar/facade_${facade}.jar > log/facade_${facade}.log &
    echo "facade_${facade} start!------------------------------------------------------ok!"

done

for service in ${services[@]}
do
    # clear .dsa .rsa .sf
    zip -d service_${service}_jar/service_${service}.jar 'META-INF/*.DSA' 'META-INF/*.RSA' 'META-INF/*.SF'
    echo "service_${service} cleared!------------------------------------------------------ok!"
    # start service
    nohup sudo java -jar service_${service}_jar/service_${service}.jar > log/service_${service}.log &
    echo "service_${service} start!--------------------------------------------------------ok!"
done