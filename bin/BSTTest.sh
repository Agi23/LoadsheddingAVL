#!/bin/bash

exec 3<> BSTTest1.txt

    # Let's print some text to fd 3
    echo "BSTTest 1: Prints all data" >&3
    echo "Input = java LSBSTApp" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSBSTApp >> BSTTest1.txt



exec 3<> BSTTest2.txt

    # Let's print some text to fd 3
    echo "BSTTest 2: valid search input" >&3
    echo "Input = java LSBSTApp '1' '12' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSBSTApp "1" "12" "00" >> BSTTest2.txt




exec 3<> BSTTest3.txt

    # Let's print some text to fd 3
    echo "BSTTest 3: invalid search input" >&3
    echo "Input = java LSBSTApp '8' '44' '00'" >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSBSTApp "8" "44" "00" >> BSTTest3.txt



exec 3<> BSTTest4.txt

    # Let's print some text to fd 3
    echo "BSTTest 4: input has too many values" >&3
    echo "Input = java LSBSTApp '8' '44' '00' '22' '33' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSBSTApp "8" "44" "00" "22" "33" >> BSTTest4.txt



exec 3<> BSTTest5.txt

    # Let's print some text to fd 3
    echo "BSTTest 5: input has too many values" >&3
    echo "Input = java LSBSTApp 'A' 'B' 'C' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSBSTApp "A" "B" "C" >> BSTTest5.txt



exec 3<> BSTTest6.txt

    # Let's print some text to fd 3
    echo "BSTTest 6: input has too few values" >&3
    echo "Input = java LSBSTApp '1' '2' " >&3
    echo "------------------" >&3
    echo "OUTPUT:" >&3
    echo "" >&3

# Close fd 3
exec 3>&-

java LSBSTApp "1" "2" >> BSTTest6.txt



