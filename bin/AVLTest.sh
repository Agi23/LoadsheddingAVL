#!/bin/bash

#No parameter test
exec 3<> AVLTestNoParam.txt

    
    echo "AVLTest No parameters: Prints all data" >&3
    echo "Input = java LSAVLApp" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSAVLApp >> AVLTestNoParam.txt


#Valid Test 1
exec 3<> AVLValid1.txt

   
    echo "AVL Valid Test 1: " >&3
    echo "Input = java LSAVLApp '1' '12' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

exec 3>&-


java LSAVLApp "1" "12" "00" >> AVLValid1.txt

#Valid Test 2
exec 3<> AVLValid2.txt

   
    echo "AVL Valid Test 2: " >&3
    echo "Input = java LSAVLApp '4' '15' '10'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSAVLApp "4" "15" "10" >> AVLValid2.txt

#Valid Test 3
exec 3<> AVLValid3.txt

   
    echo "AVL Valid Test 3: " >&3
    echo "Input = java LSAVLApp '8' '21' '14'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSAVLApp "8" "21" "14" >> AVLValid3.txt


#Invalid Tests

#Invalid test 1
exec 3<> AVLInvalid1.txt

    echo "AVL Invalid Test 1: invalid search input" >&3
    echo "Input = java LSAVLApp '8' '44' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3
exec 3>&-

java LSAVLApp "8" "44" "00" >> AVLInvalid1.txt


#Invalid Test 2
exec 3<> AVLInvalid2.txt

    echo "AVL Invalid Test 2: input has too many values" >&3
    echo "Input = java LSAVLApp '8' '44' '00' '22' '33' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSAVLApp "8" "44" "00" "22" "33" >> AVLInvalid2.txt


#Invalid Test 3
exec 3<> AVLInvalid3.txt

    
    echo "AVL Invalid Test 3: input is wrong data type" >&3
    echo "Input = java LSAVLApp 'A' 'B' 'C' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3


exec 3>&-

java LSAVLApp "A" "B" "C" >> AVLInvalid3.txt



