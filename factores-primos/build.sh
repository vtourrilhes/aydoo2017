javac -d ./build ./src/main/java/ar/edu/untref/aydoo/Program.java
jar cfm   ./build/ar/edu/untref/aydoo/factores-primos.jar manifest.mf build/ar/edu/untref/aydoo/Program.class 
java -jar ./build/ar/edu/untref/aydoo/factores-primos.jar
