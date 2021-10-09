import java.time.LocalDateTime;

/**
 * @Autor Acosta
 * @Autor Olarte
 * @Version 1.0 - 2021-2
 */
public class Message {
    private int id;
    private String text;
    private LocalDateTime date;
    private boolean read;
    private User sender;
    private File file;
}
