public class Wall extends BaseGameObject implements Walkable { // Должен возвращать объект из массива Walkable
    // и объект Player. Обработка исключений - через консоль.
    @Override
    public boolean isWalkable() {
        return false;
    }
}