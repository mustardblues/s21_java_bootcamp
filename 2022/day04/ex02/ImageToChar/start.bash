#!/bin/bash

rm -rf target/ && mkdir target/

cd target/ && jar xf ./../lib/jcommander-1.72.jar && jar xf ./../lib/JCDP-4.0.0.jar && cd ..

cp -R src/resources target/

javac -cp lib/JCDP-4.0.0.jar:lib/jcommander-1.72.jar: -d target/ src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/BMPConverter.java src/java/edu/school21/printer/logic/Args.java

jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .

java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN