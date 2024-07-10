PATH_TO_FX := "C:/Users/danie/Desktop/ProyectoPOO/Proyecto_POO/javafx-sdk-21.0.3/lib"
PATH_TO_POSTGRES = "C:/Users/danie/Desktop/ProyectoPOO/Proyecto_POO/lib/postgresql-42.7.3.jar"
OUTPUT_DIR = "C:/Users/danie/Desktop/ProyectoPOO/Proyecto_POO/bin"

MODULES = javafx.controls,javafx.fxml

default:
	javac --module-path $(PATH_TO_FX) --add-modules $(MODULES) -cp $(PATH_TO_POSTGRES) -d $(OUTPUT_DIR) *.java

clean:
	rm -rf $(OUTPUT_DIR)/*.class

run:
	java --module-path $(PATH_TO_FX) --add-modules $(MODULES) -cp $(PATH_TO_POSTGRES) -cp $(OUTPUT_DIR) App
