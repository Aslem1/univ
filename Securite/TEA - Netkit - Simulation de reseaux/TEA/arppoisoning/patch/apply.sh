#!/bin/bash
NETKIT_HOME=/usr/local/netkit/
dpkg -i *.deb
mv tap-not-first.patch $NETKIT_HOME
cd $NETKIT_HOME
patch -p1 < tap-not-first.patch
