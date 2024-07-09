import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/elo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Crear tablas si no existen
    public void createTablesIfNotExist() {
        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement()) {
            String createLibrosTable = "CREATE TABLE IF NOT EXISTS libros (" +
                    "id SERIAL PRIMARY KEY," +
                    "titulo VARCHAR(255)," +
                    "autor VARCHAR(255)," +
                    "descripcion VARCHAR(255)," +
                    "cantidadDisp INTEGER," +
                    "numPaginas INTEGER," +
                    "imagen VARCHAR(255)" +
                    ")";
            stmt.executeUpdate(createLibrosTable);

            String createDocumentosTable = "CREATE TABLE IF NOT EXISTS documentos (" +
                    "id SERIAL PRIMARY KEY," +
                    "titulo VARCHAR(255)," +
                    "publicador VARCHAR(255)," +
                    "descripcion VARCHAR(255)," +
                    "cantidadDisp INTEGER," +
                    "numPaginas INTEGER," +
                    "imagen VARCHAR(255)" +
                    ")";
            stmt.executeUpdate(createDocumentosTable);

            String createRevistasTable = "CREATE TABLE IF NOT EXISTS revistas (" +
                    "id SERIAL PRIMARY KEY," +
                    "titulo VARCHAR(255)," +
                    "descripcion VARCHAR(255)," +
                    "cantidadDisp INTEGER," +
                    "numPaginas INTEGER," +
                    "imagen VARCHAR(255)" +
                    ")";
            stmt.executeUpdate(createRevistasTable);

            System.out.println("Tablas creadas correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT
    public void insertLibro(Libro libro) {
        try (Connection conn = getConnection()) {
            String insertQuery = "INSERT INTO libros (autor, titulo, descripcion, cantidadDisp, numPaginas, imagen) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setString(1, libro.getAutor());
                pstmt.setString(2, libro.getTitulo());
                pstmt.setString(3, libro.getDescripcion());
                pstmt.setInt(4, libro.getCantidadDisp());
                pstmt.setInt(5, libro.getNumPaginas());
                pstmt.setString(6, libro.getImagen());
    
                pstmt.executeUpdate();
                System.out.println("Libro insertado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDocumento(Documento documento) {
        try (Connection conn = getConnection()) {
            String insertQuery = "INSERT INTO documentos (titulo, publicador, descripcion, cantidadDisp, numPaginas, imagen) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setString(1, documento.getTitulo());
                pstmt.setString(2, documento.getPublicador());
                pstmt.setString(3, documento.getDescripcion());
                pstmt.setInt(4, documento.getCantidadDisp());
                pstmt.setInt(5, documento.getNumPaginas());
                pstmt.setString(6, documento.getImagen());
    
                pstmt.executeUpdate();
                System.out.println("Documento insertado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRevista(Revista revista) {
        try (Connection conn = getConnection()) {
            String insertQuery = "INSERT INTO revistas (titulo, descripcion, cantidadDisp, numPaginas, imagen) " +
                    "VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                pstmt.setString(1, revista.getTitulo());
                pstmt.setString(2, revista.getDescripcion());
                pstmt.setInt(3, revista.getCantidadDisp());
                pstmt.setInt(4, revista.getNumPaginas());
                pstmt.setString(5, revista.getImagen());
    
                pstmt.executeUpdate();
                System.out.println("Revista insertada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // SELECT
    public List<Libro> getAllLibros() {
        List<Libro> libros = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String selectQuery = "SELECT * FROM libros";
            try (PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String autor = rs.getString("autor");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    int cantidadDisp = rs.getInt("cantidadDisp");
                    int numPaginas = rs.getInt("numPaginas");
                    String imagen = rs.getString("imagen");
    
                    Libro libro = new Libro(id, titulo, autor, descripcion, cantidadDisp, numPaginas, imagen);
                    libros.add(libro);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }

    public List<Documento> getAllDocumentos() {
        List<Documento> documentos = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String selectQuery = "SELECT * FROM documentos";
            try (PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String titulo = rs.getString("titulo");
                    String publicador = rs.getString("publicador");
                    String descripcion = rs.getString("descripcion");
                    int cantidadDisp = rs.getInt("cantidadDisp");
                    int numPaginas = rs.getInt("numPaginas");
                    String imagen = rs.getString("imagen");
    
                    Documento documento = new Documento(id, titulo, publicador, descripcion, cantidadDisp, numPaginas, imagen);
                    documentos.add(documento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentos;
    }

    public List<Revista> getAllRevistas() {
        List<Revista> revistas = new ArrayList<>();
        try (Connection conn = getConnection()) {
            String selectQuery = "SELECT * FROM revistas";
            try (PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    int cantidadDisp = rs.getInt("cantidadDisp");
                    int numPaginas = rs.getInt("numPaginas");
                    String imagen = rs.getString("imagen");
    
                    Revista revista = new Revista(id, titulo, descripcion, cantidadDisp, numPaginas, imagen);
                    revistas.add(revista);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return revistas;
    }

    // Prueba de conexión a la base de datos
    public static void main(String[] args) {
        Database database = new Database();
        database.createTablesIfNotExist();

        // Ejemplo de inserción de un libro
        Libro libro = new Libro(1, "El nombre del viento", "Patrick Rothfuss", "...", 10, 400, "imagen.jpg");
        database.insertLibro(libro);

        // Ejemplo de inserción de un documento
        Documento documento = new Documento(2, "Documento importante", "Editorial X", "...", 20, 100, "documento.jpg");
        database.insertDocumento(documento);

        // Ejemplo de inserción de una revista
        Revista revista = new Revista(3, "Revista mensual", "...", 30, 50, "portada.jpg");
        database.insertRevista(revista);

        // Prueba de obtener todos los libros
        List<Libro> libros = database.getAllLibros();
        for (Libro l : libros) {
            System.out.println("Título del libro: " + l.getTitulo());
        }

        // Prueba de obtener todos los documentos
        List<Documento> documentos = database.getAllDocumentos();
        for (Documento d : documentos) {
            System.out.println("Título del documento: " + d.getTitulo());
        }

        // Prueba de obtener todas las revistas
        List<Revista> revistas = database.getAllRevistas();
        for (Revista r : revistas) {
            System.out.println("Título de la revista: " + r.getTitulo());
        }
    }
}
