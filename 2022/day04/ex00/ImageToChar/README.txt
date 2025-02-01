# Создаём или пересоздаём директорию для файлов .class
rm -rf target/ && mkdir target/

# Компилируем файлы в .class и помещаем их в директорию target/
javac -d target/ src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/BMPConverter.java

# Запускаем исходный код с аргументами командной строки
java -classpath target/ edu/school21/printer/app/Program [полный путь до .bmp]