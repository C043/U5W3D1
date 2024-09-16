package fragnito.U5W3D1.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Nessun elemento con id: " + id + " è stato trovato");
    }
}
