CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [ -d "student-submission" ]; then
  echo 'Cloning successful'
else
  echo 'Cloning failed'
  exit 1
fi

if [ -f "student-submission/ListExamples.java" ]; then
  echo 'ListExamples.java found'
else
  echo 'ListExamples.java not found'
  exit 1
fi

# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

cp -r ./lib grading-area
cp -r ./student-submission/* grading-area
cp TestListExamples.java grading-area
cd grading-area

javac -cp $CPATH *.java

if [ $? -ne 0 ]; then
  echo 'Compilation failed'
  exit 1
else 
  echo 'Compilation successful'
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples
