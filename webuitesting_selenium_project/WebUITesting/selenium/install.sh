#!/usr/bin/env bash
if [ -z "$REACT_APP_HASH" ]; then
    echo "Running in evaluation mode. Skipping Chrome installation."
else
    export DEBIAN_FRONTEND=noninteractive
    apt-get update -y
    wget --no-verbose -O /tmp/chrome.deb https://uc.hackerearth.com/he-public-data/google-chrome-stableaef3189.deb
    apt install -y /tmp/chrome.deb
    rm /tmp/chrome.deb
    export CHROME_BIN=/usr/bin/google-chrome
fi
