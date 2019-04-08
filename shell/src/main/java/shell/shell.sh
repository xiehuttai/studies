#!/usr/bin/env bash

# 启动脚本

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf

cd ~
USER_DIR=`pwd`

cd ${DEPLOY_DIR}