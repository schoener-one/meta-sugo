#!/bin/sh
# ******************************
# Sugrow service start script
# 
# Sugrow Project / Copyright 2020
# ******************************

GPIO_CONFIG=/etc/sugrow/gpio.conf
GPIO_SETUP=/usr/bin/sugrow-gpio-setup.sh

while [ $# -gt 0 ]; do
    case $1 in
        -c)
        shift
        GPIO_CONFIG=$1
        ;;
        *)
        echo "Error: wrong parameter: $1"
        exit 1
        ;;
    esac
    shift
done

$GPIO_SETUP "$GPIO_CONFIG"
