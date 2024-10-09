package service;

public class GeradorId {
    private static int id = 1;

    public static int getProximoId() {
        return ++id;
    }
}
