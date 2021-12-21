package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    private static Faker faker = new Faker(new Locale("ru"));

    public static String city() {
        String[] bigCity = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала",
                "Магас", "Нальчик", "Элиста", "Черкесск", "Казань", "Кызыл", "Ижевск", "Абакан",
                "Петрозаводск", "Сыктывкар", "Симферополь", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ",
                "Грозный", "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар",
                "Красноярск", "Пермь", "Владивосток", "Ставрополь", "Хабаровск", "Благовещенск",
                "Архангельск", "Астрахань", "Белгород", "Брянск", "Вологда", "Воронеж", "Калининград",
                "Киров", "Гатчина", "Москва", "Санкт-Петербург"};
        int randCity = (int) Math.floor(Math.random() * bigCity.length);
        return bigCity[randCity];

    }

    public static String dateMeeting() {
        return LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String dateMeeting2() {
        return LocalDate.now().plusDays(6).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String name() {
        return faker.name().fullName();
    }

    public static String phone() {
        return faker.phoneNumber().phoneNumber();
    }

}
