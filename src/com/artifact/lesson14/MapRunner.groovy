package com.artifact.lesson14

class MapRunner {

    static void main(String[] args) {

        // такая инициализация вернет LinkedHashMap
//        def map = ["one": 1, "two": 2]

        // можем опустить кавычки
        def map = [one: 1, "two": 2]
        assert map.getClass() == LinkedHashMap

        // read
        assert map.get("one") == 1
        assert map["one"] == 1
        assert map."one" == 1
        assert map.one == 1             // propertyMissing
        // по такому ключу у нас нет значения, тогда вернется установленное дефолтное 10
        // и это значение ляжет в мапу
        assert map.get("qwe", 10) == 10
        println map

        // write
        // можно заюзать и put() и putAll() но есть иной способ:
        map.one = 111       // переприсвоили
        map.tree = 3        // добавили новый

        // new method что получить подмножество, типа subMap
        assert map.subMap("one", "two") == [one: 111, "two": 2]

        // new operator
        // если я хочу добавить в нашу мапу все значения из другой мапы, то я могу заюзать
        // такой опрератор *:имяПрисоединяемойМапы
        def newMap = ["q": 22, "rt": 99, *: map]
        println newMap
    }
}
