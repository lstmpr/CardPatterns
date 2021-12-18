package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
/**
 * Утилитный класс - содержит приватный конструктор и статичные методы
 *  Используем для удобства, один метод генерирует 3 поля (имя, телефон, номер карты)
 */


public class DataGenerator {
    private static Faker faker = new Faker(new Locale("ru"));
    private static String localD = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    private static String localDNext = LocalDate.now().plusDays(6).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));


  public static String city(){
      String[] bigCity = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала",
              "Магас", "Нальчик", "Элиста", "Черкесск", "Казань", "Кызыл", "Ижевск", "Абакан",
      "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ",
      "Грозный", "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар",
              "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск", "Благовещенск",
              "Архангельск", "Астрахань", "Белгород", "Брянск", "Вологда", "Воронеж", "Калининград",
              "Киров", "Гатчина", "Москва", "Санкт-Петербург"};
      int randCity = (int)Math.floor(Math.random() * bigCity.length);
      return bigCity[randCity];

  }
    public static String dateMeeting() {
      return localD;
    }

    public static String dateMeeting2() {
        return localDNext;
    }
    public static String name() {
      return faker.name().fullName();
    }

    public static String phone() {
      return faker.phoneNumber().phoneNumber();
    }

}
