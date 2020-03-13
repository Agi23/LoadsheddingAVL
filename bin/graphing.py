import matplotlib.pyplot as plt
import numpy 
import csv
import pandas as pd

arr=[]
avl=[]
bst=[]
iter=[]
BSTdata = []
AVLdata = []

n=[297,594,891,1118,1485,1782,2079,2376,2673,2976]

csvFiles = ["data297.txtoutput.txt","data594.txtoutput.txt","data891.txtoutput.txt" ,"data1188.txtoutput.txt" ,"data1485.txtoutput.txt" ,"data1782.txtoutput.txt" ,"data2079.txtoutput.txt" ,"data2376.txtoutput.txt" ,"data2673.txtoutput.txt" ,"data2976.txtoutput.txt" ]

for txtfile in csvFiles:

    with open(txtfile, "r") as csvfile:
        plots=csv.reader(csvfile, delimiter =",")
        for row in plots:
            iter.append(int(row[0]))
            arr.append(int(row[1]))
            bst.append(int(row[2]))
            avl.append(int(row[3]))
#plt.plot(iter,arr)
    worstBST = numpy.amax(bst)
    worstAVL = numpy.amax(avl)

    bestBST = numpy.amin(bst)
    bestAVL = numpy.amin(avl)

    avgAVL = round(numpy.mean(avl),2)
    avgBST = round(numpy.mean(bst),2)

    BSTdata.append([bestBST, worstBST, avgBST])
    AVLdata.append([bestAVL, worstAVL, avgAVL])

    #plt.plot(iter,bst)
    #plt.plot(iter, avl)

#plt.show()
#print(BSTdata)
#print(AVLdata)

df = pd.DataFrame(numpy.array(BSTdata) ,index = n,columns =["best", "worst", "avg"])
print(df)
df.to_excel("output.xlsx")  
#ig, ax = plt.subplots()
#df.plot(x=n, y='worst', ax=ax, legend=False)


