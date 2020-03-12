SRC_DIR = ./src
BIN_DIR = ./bin
DOC_DIR = ./doc

JAVAC = javac
JFLAGS = -g -d $(BIN_DIR) -cp $(BIN_DIR)

vpath %.java $(SRC_DIR)
vpath %.class $(BIN_DIR)

.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<



ClASSES:LSInfoItem.class \
	LSArray.class \
	LSArrayApp.class \
	BinaryTreeNode.class \
	BTQueueNode.class \
	BTQueue.class \
	BinaryTree.class \
	LSBSTApp.class \
	testGen.class \
	Counter.class\
	LSManager.class \
	AVLTree.class \
	LSAVLApp.class


clean:
	@rm -f  $(BIN_DIR)/*.class

docs:
	javadoc  -classpath ${BIN_DIR} -d ${DOC_DIR} ${SRC_DIR}/*.java

cleandocs:
	rm -rf ${DOC_DIR}/*

