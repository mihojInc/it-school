package com.lessons;
//Exeption созданное исключение если нет такого URL
//Operation основной класс приложения, в котором производятся все действия
//FileManager класс описывающий работу с файлами
//Процедура получения списка файлов (возвращать строку)
//Процедура получения ссылки на файл

//Loader Класс осуществляющий копирование
//DownloadService класс осуществляющий загрузку картинок
//Лог  логирование действий

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Operation oper = new Operation();
        oper.mainOperation(sc);

    }
}
