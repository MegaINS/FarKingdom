package ru.megains.farlandsOld.gameobjects;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import ru.megains.farlandsOld.base.Styles;
import ru.megains.farlandsOld.loaders.DangeAtlasLoader;

public class CellTextMask extends Group {
    private MyActor mask;
    private Label num;
    private String[] chars = new String[]{"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я", "А", "Б", "В", "Г", "Д", "Е", "Ё", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О", "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ы", "Ь", "Э", "Ю", "Я", "аа", "бб", "вв", "гг", "дд", "ее", "ёё", "жж", "зз", "ии", "йй", "кк", "лл", "мм", "нн", "оо", "пп", "рр", "сс", "тт", "уу", "фф", "хх", "цц", "чч", "шш", "щщ", "ъъ", "ыы", "ьь", "ээ", "юю", "яя", "АА", "ББ", "ВВ", "ГГ", "ДД", "ЕЕ", "ЁЁ", "ЖЖ", "ЗЗ", "ИИ", "ЙЙ", "КК", "ЛЛ", "ММ", "НН", "ОО", "ПП", "РР", "СС", "ТТ", "УУ", "ФФ", "ХХ", "ЦЦ", "ЧЧ", "ШШ", "ЩЩ", "ЪЪ", "ЫЫ", "ЬЬ", "ЭЭ", "ЮЮ", "ЯЯ"};

    public CellTextMask(int num) {
        this.mask = new MyActor(DangeAtlasLoader.mask5);
        if (num < this.chars.length && num >= 0) {
            this.num = new Label(this.chars[num], Styles.labelYellow);
        } else {
            this.num = new Label("O_0", Styles.labelYellow);
        }

        this.addActor(this.mask);
        this.num.setPosition(80.0F, 50.0F);
        this.addActor(this.num);
    }
}
