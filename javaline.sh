#!/usr/bin/env bash
find . -name "*.$1"|xargs cat|grep -v ^$|wc -l