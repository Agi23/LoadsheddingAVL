#!/bin/bash

# Declare an array of string with type
declare -a StringArray=("data297.txt" "data594.txt" "data891.txt" "data1188.txt" "data1485.txt" "data1782.txt" "data2079.txt" "data2376.txt" "data2673.txt" "data2976.txt" )
 
# Iterate the string array using for loop
for val in ${StringArray[@]}; do
   java LSManager $val
done


