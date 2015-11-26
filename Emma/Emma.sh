# !/usr/bash


java -XX:-UseSplitVerifier -cp emma.jar emmarun -sp . -r html -cp .:junit-4.11.jar RationalTest

