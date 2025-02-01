# Создаём или пересоздаём директорию для файлов .class
rm -rf target/ && mkdir target/

# Компилируем файлы в .class и помещаем их в директорию target/
javac -d target src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/BMPConverter.java

# Копируем папку ресурсов в директорию target/
cp -R src/resources target/

# Создаём архив .jar с указанием имени и информации из manifest.txt
jar cfm target/images-to-char-printer.jar src/manifest.txt -C target/ .

# Запускаем исходный код с аргументами командной строки
java -jar target/images-to-char-printer.jar /home/mustardblues/s21_java_bootcamp/2022/day04/ex01/ImageToChar/src/resources/baks.bmp