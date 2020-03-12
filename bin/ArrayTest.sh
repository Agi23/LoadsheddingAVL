#!/bin/bash

exec 3<> ArrayTest1.txt

    # Let's print some text to fd 3
    echo "ArrayTest 1: Prints all data" >&3
    echo "Input = java LSArrayApp" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSArrayApp >> ArrayTest1.txt



exec 3<> ArrayTest2.txt

    # Let's print some text to fd 3
    echo "ArrayTest 2: valid search input" >&3
    echo "Input = java LSArrayApp '1' '12' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSArrayApp "1" "12" "00" >> ArrayTest2.txt




exec 3<> ArrayTest3.txt

    # Let's print some text to fd 3
    echo "ArrayTest 3: invalid search input" >&3
    echo "Input = java LSArrayApp '8' '44' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSArrayApp "8" "44" "00" >> ArrayTest3.txt



exec 3<> ArrayTest4.txt

    # Let's print some text to fd 3
    echo "ArrayTest 4: input has too many values" >&3
    echo "Input = java LSArrayApp '8' '44' '00' '22' '33' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSArrayApp "8" "44" "00" "22" "33" >> ArrayTest4.txt



exec 3<> ArrayTest5.txt

    # Let's print some text to fd 3
    echo "ArrayTest 5: input has too many values" >&3
    echo "Input = java LSArrayApp 'A' 'B' 'C' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSArrayApp "A" "B" "C" >> ArrayTest5.txt



exec 3<> ArrayTest6.txt

    # Let's print some text to fd 3
    echo "ArrayTest 6: input has too few values" >&3
    echo "Input = java LSArrayApp '1' '2' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSArrayApp "1" "2" >> ArrayTest6.txt




