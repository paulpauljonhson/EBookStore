package by.paul.application.util.id_generator;

public class OrderIDGenerator implements IDGenerator {
    private static Integer idCounter = 0;

    public Integer getIdCounter() {
        return idCounter;
    }

    @Override
    public String createID() {
        return String.valueOf(++idCounter);
    }

    @Override
    public void plusCount() {
        ++idCounter;
    }

    @Override
    public void minusCount() {
        --idCounter;
    }
}

