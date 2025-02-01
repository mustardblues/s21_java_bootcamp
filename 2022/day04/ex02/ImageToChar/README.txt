# Скачиваем внешние библиотеки JCommander, JCDP (или JColor)
curl https://repo1.maven.org/maven2/com/beust/jcommander/1.72/jcommander-1.72.jar -o lib/jcommander-1.72.jar

curl https://repo1.maven.org/maven2/com/diogonunes/JCDP/4.0.0/JCDP-4.0.0.jar -o lib/JCDP-4.0.0.jar

# Создаём или пересоздаём директорию для файлов .class
rm -rf target/ && mkdir target/

# Разорхивируем скаченные архивы .jar в папку target/
cd target/ && jar xf ./../lib/jcommander-1.72.jar && jar xf ./../lib/JCDP-4.0.0.jar && cd ..

# Копируем папку ресурсов в директорию target/
cp -R src/resources target/

# Компилируем файлы в .class и помещаем их в директорию target/
javac -cp lib/JCDP-4.0.0.jar:lib/jcommander-1.72.jar: -d target/ src/java/edu/school21/printer/app/Program.java src/java/edu/school21/printer/logic/BMPConverter.java src/java/edu/school21/printer/logic/Args.java

# Создаём архив .jar с указанием имени и информации из manifest.txt
jar cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ .

# Запускаем исходный код с аргументами командной строки
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN