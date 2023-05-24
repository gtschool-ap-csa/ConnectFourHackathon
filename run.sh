rm -rf "*.class"
find -name "*.java" > sources.txt
javac @sources.txt
rm sources.txt
java ConnectFourRunner