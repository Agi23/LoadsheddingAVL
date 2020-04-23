#!/bin/bash

#No parameter test
exec 3<> BSTTestNoParam.txt

    
    echo "BSTTest No parameters: Prints all data" >&3
    echo "Input = java LSBSTApp" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSBSTApp >> BSTTestNoParam.txt


#Valid Test 1
exec 3<> BSTValid1.txt

   
    echo "BST Valid Test 1: " >&3
    echo "Input = java LSBSTApp '1' '12' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

exec 3>&-


java LSBSTApp "1" "12" "00" >> BSTValid1.txt

#Valid Test 2
exec 3<> BSTValid2.txt

   
    echo "BST Valid Test 2: " >&3
    echo "Input = java LSBSTApp '4' '15' '10'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSBSTApp "4" "15" "10" >> BSTValid2.txt

#Valid Test 3
exec 3<> BSTValid3.txt

   
    echo "BST Valid Test 3: " >&3
    echo "Input = java LSBSTApp '8' '21' '14'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSBSTApp "8" "21" "14" >> BSTValid3.txt


#Invalid Tests

#Invalid test 1
exec 3<> BSTInvalid1.txt

    echo "BST Invalid Test 1: invalid search input" >&3
    echo "Input = java LSBSTApp '8' '44' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3
exec 3>&-

java LSBSTApp "8" "44" "00" >> BSTInvalid1.txt


#Invalid Test 2
exec 3<> BSTInvalid2.txt

    echo "BST Invalid Test 2: input has too many values" >&3
    echo "Input = java LSBSTApp '8' '44' '00' '22' '33' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSBSTApp "8" "44" "00" "22" "33" >> BSTInvalid2.txt


#Invalid Test 3
exec 3<> BSTInvalid3.txt

    
    echo "BST Invalid Test 3: input is wrong data type" >&3
    echo "Input = java LSBSTApp 'A' 'B' 'C' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSBSTApp "A" "B" "C" >> BSTInvalid3.txt



