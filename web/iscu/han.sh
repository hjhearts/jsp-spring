#!/usr/bin/env bash

echo "Select Option."
echo "P : Process List"
echo "K : Re-Input Process ID"
echo "C : Calculator"
echo "Q or X : Running Script Quit"
read opt
while(1)
do
    optP() {
        ps -e
        continue
    }
    optK() {
        echo "Re-Input PID"
        read repid
        kill -9 ${repid}
        continue
    }
    optC() {
        echo "First Number"
        read firnum
        echo "Second Number"
        read secnum
        echo "1: + 2: - 3: *"
        read calopt
        case $calopt in
            1) echo $[$firnum + $secnum] ;;
            2) echo $[$firnum - $secnum] ;;
            3) echo $[$firnum * $secnum] ;;
        esac
        continue
    }
    optQX() {
        echo "Script Quit"
        exit 0
    }
    optO() {
        echo "Not Define Char"
        continue
    }
done