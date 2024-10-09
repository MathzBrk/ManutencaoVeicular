import controller.MenuController;
import org.junit.jupiter.api.Test;

public class MenuControllerTest {

    @org.junit.Test
    public void testMenuOptions() {
        MenuController menuController = new MenuController();
    }

    @Test
    public void testGerarArquivoExcel() {
        MenuController menuController = new MenuController();
        menuController.gerarArquivoExcel();

    }
}