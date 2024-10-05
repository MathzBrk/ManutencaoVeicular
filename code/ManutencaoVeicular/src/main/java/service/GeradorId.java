package service;

public class GeradorId {
    private static int id = 0;

    public static int getProximoId() {
        return ++id;
    }
}
