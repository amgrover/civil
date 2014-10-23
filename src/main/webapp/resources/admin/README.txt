Name: Aman Grover
Email : grover3@illinois.edu

Note: Directly import folder as java project in eclipse.

Steps to run code
1. Unzip the content
2. For convenience I have put every algorithm into a separate jar file . So you need not compile the whole code. There are five jar files that you can run . These are basically five algorithms

For running fully grown Decision Tree 
java -jar FFV_FULL.jar <path1.fold> <path2.fold> <path3.fold> <path4.fold> <path5.fold>
java -jar FFV_FULL.jar "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold1" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold2" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold3" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold4" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold5"

For running Decision tree of depth=4
java -jar FFV_4.jar "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold1" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold2" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold3" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold4" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold5"

For running Decision tree of depth=8
java -jar FFV_FULL.jar "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold1" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold2" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold3" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold4" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold5"

For running SGD(remember to give  path of ARFF file)
java -jar SGD.jar "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold1.arff" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold2.arff" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold3.arff" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold4.arff" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold5.arff"

For running Decision stumps as features 
java -jar DecisionStumpGenerator.jar "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold1" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold2" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold3" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold4" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.fold5"

Experimentation(remember fold and Arff file)
java -jar Experiment.jar "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.all" "C:\Users\Aman's Alien\Desktop\code_snippets\MachineLearningAssignment1\src\badges\badges.modified.data.foldmodiefiedall.arff"
