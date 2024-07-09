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
    private static final String PASSWORD = "dev2108";

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

    // SELECT
    // Obtener la cantidad disponible de una publicación
    public int getCantidadDisp(String tipo, int id) {
        String tableName = "";
        switch (tipo) {
            case "l":
                tableName = "libros";
                break;
            case "d":
                tableName = "documentos";
                break;
            case "r":
                tableName = "revistas";
                break;
            default:
                System.out.println("Tipo de publicacion no valido.");
                return 0;
        }

        String sql = "SELECT cantidadDisp FROM " + tableName + " WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("cantidadDisp");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
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
            String insertQuery = "INSERT INTO documentos (titulo, publicador, descripcion, cantidadDisp, numPaginas, imagen) "
                    +
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

                    Documento documento = new Documento(id, titulo, publicador, descripcion, cantidadDisp, numPaginas,
                            imagen);
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

    // UPDATE
    public void updateCantidadDisp(String tipo, int id, int cantidad) {
        String tableName = "";
        switch (tipo) {
            case "l":
                tableName = "libros";
                break;
            case "d":
                tableName = "documentos";
                break;
            case "r":
                tableName = "revistas";
                break;
            default:
                System.out.println("Tipo de publicacion no valido.");
                return;
        }

        try (Connection conn = getConnection()) {
            String updateQuery = "UPDATE " + tableName + " SET cantidadDisp = cantidadDisp + ? WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                pstmt.setInt(1, cantidad);
                pstmt.setInt(2, id);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Cantidad disponible actualizada correctamente.");
                } else {
                    System.out.println("No se encontró el elemento con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deletePublicacion(String tipo, int id) {
        String tableName = "";
        switch (tipo) {
            case "l":
                tableName = "libros";
                break;
            case "d":
                tableName = "documentos";
                break;
            case "r":
                tableName = "revistas";
                break;
            default:
                System.out.println("Tipo de publicacion no valido.");
                return;
        }

        try (Connection conn = getConnection()) {
            String deleteQuery = "DELETE FROM " + tableName + " WHERE id = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
                pstmt.setInt(1, id);

                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Elemento eliminado correctamente.");
                } else {
                    System.out.println("No se encontró el elemento con el ID proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
